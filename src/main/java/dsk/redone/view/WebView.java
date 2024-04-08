package dsk.redone.view;

import dsk.redone.controllers.AppController;
import dsk.redone.models.ExRate;
import dsk.redone.repository.DataRepo;

import javax.swing.*;
import java.util.ArrayList;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class WebView implements UserView {
    @Override
    public void dataOut() {
        StringBuilder builder=new StringBuilder();
        DataRepo.getErList().forEach(l-> builder.append(l).append("\n"));
        JOptionPane.showMessageDialog(null,builder.toString(),"Курсы валюты "
                + AppController.curName,INFORMATION_MESSAGE);
    }
}
