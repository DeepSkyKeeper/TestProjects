package dsk.redone.repository;

import dsk.redone.models.Currency;
import dsk.redone.models.ExRate;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Хранит список валют curList  и список курсов за указанные даты
 */
public abstract class DataRepo {
    @Setter
    @Getter
    protected  ArrayList<Currency> curList;
    @Getter
    protected  ArrayList<String> curNames;
    protected  ArrayList<String> curIdLst;
    @Getter
    protected  HashMap<String, String> curMap;

    @Getter
    protected  static ArrayList<ExRate> erList;


    public DataRepo() {
        setCurrency();
        setCurMap();
        setCurNames();
    }

    /**
     * getCurrency() - получить список валют из указанного источника
     */
    protected abstract void setCurrency();
    public abstract void setErList(String url);

    /**
     * получает список названий валют из списка моделей валют
     */
    private  void setCurNames() {
        curNames = new ArrayList<>();
        curList.forEach(t -> curNames.add(t.getName()));
    }

    /**
     * получает список id валют из списка моделей валют
     */
    private  void getCurId() {
        curIdLst=new ArrayList<>();
        curList.forEach(t -> curIdLst.add(t.getId()));
    }
    public String getIdByCurName(String curName){
        return curMap.get(curName);
    }

    /**
     * Получает
     * @HashMap <curName,CurId> curMap из списка моделей валют
     * @key curName
     * @value curId
     */
    private  void setCurMap() {
        curMap = new HashMap<>();
        curList.forEach(t -> curMap.put(t.getName(), t.getId()));
    }



}
