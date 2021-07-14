package com.codeWithMoh;

import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.awt.*;

public class Notepad {
    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;

    public static void main(String[] args){
        new Notepad();
    }
    public Notepad(){
        createWindow();
        createTextArea();
        window.setVisible(true);
    }
    public void createWindow(){
        //How we want our window to be displayed
        window = new JFrame("Notepad");
        window.setSize(1000,800);
        window.setBackground(Color.green);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //Enabling the text area and scroll functions
    public void createTextArea(){
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        window.add(scrollPane);
        //disable border
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        //window.add(textArea);
    }

}
