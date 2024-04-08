package dsk.redone.services;

import dsk.redone.models.Currency;
import dsk.redone.models.ExRate;
import dsk.redone.repository.DataRepo;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Парсит xml данные с url адреса сохраняет в список моделей валют Currency
 */
public class XmlParser extends DataRepo {
    private static XmlParser instance = null;
    private static Document doc;
    private static final String curListUrl = "https://cbr.ru/scripts/XML_val.asp?d=0";

    private XmlParser() {
        super();
    }


    /**
     * Получает документ по указанному адресу
     * @param curListUrl - url со списком актуальных валют
     */
    private static void getDoc(String url) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            doc = dbf.newDocumentBuilder().parse(url);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    public static XmlParser createXmlParser() {
        if (instance == null) {
            instance = new XmlParser();
            return instance;
        } else return instance;
    }

    /**
     * Получает список актуальных валют из xml документа
     */
    @Override
    public void setCurrency() {

        getDoc(curListUrl);
        curList = new ArrayList<>();
        String name = null;
        String code;
        Currency currency;
        NodeList nodeList = doc.getElementsByTagName("Item");
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            NodeList childNodes = nodeList.item(i).getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                String tagName = childNodes.item(j).getNodeName();
                if (tagName.equals("Name")) {
                    name = childNodes.item(j).getTextContent();
                }
                if (tagName.equals("ParentCode")) {
                    code = childNodes.item(j).getTextContent();
                    currency = new Currency(name, code);
                    curList.add(currency);
                }
            }
        }
    }

    /**
     * Парсинг курсов валюты за период
     *
     * @param url для получения курсов
     *            (Пример: https://cbr.ru/scripts/XML_dynamic.asp?date_req1=01/03/2024&date_req2=05/03/2024&VAL_NM_RQ=R01235)
     *            RQ -код валюты
     *            date_req1 - дата начала периода
     *            date_req2 - дата конца периода
     */
    @Override
    public void setErList(String url) {
        getDoc(url);
        if (erList == null)
            erList = new ArrayList<>();
        ExRate exRate;
        NodeList nodeList;

        nodeList = doc.getElementsByTagName("Record");

        for (int i = 0; i < nodeList.getLength(); i++) {
            exRate = new ExRate();

            exRate.setId(nodeList.item(i).getAttributes().getNamedItem("Id").getNodeValue());
            exRate.setDate(nodeList.item(i).getAttributes().getNamedItem("Date").getNodeValue());

            NodeList childNodes = nodeList.item(i).getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                String tagName = childNodes.item(j).getNodeName();
                if (tagName.equals("Nominal")) {
                    exRate.setNominal(childNodes.item(j).getTextContent());
                }
                if (tagName.equals("Value")) {
                    exRate.setValue(childNodes.item(j).getTextContent());
                    erList.add(exRate);
                }
            }
        }
    }
}
