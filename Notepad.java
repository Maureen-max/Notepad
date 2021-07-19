package com.codeWithMoh;

import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class Notepad implements ActionListener {
        JFrame window;
        JTextArea textArea;
        JScrollPane scrollPane;
        JMenuBar menuBar;
        JMenu menuFile,menuEdit,menuFormat,menuColor ,menuView,menuHelp;
        JMenuItem INew, IOpen,ISave , ISaveAs,IExit;

        Function_File file = new Function_File(this);
        //Function_File open = new Function_File(this);
    

    public static void main(String[] args){
        new Notepad();
    }
    public Notepad(){
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();

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

        //disable border
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);

    }
    public void createMenuBar(){
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);

        menuView= new JMenu("view");
        menuBar.add(menuView);

        menuHelp = new JMenu("Help");
        menuBar.add(menuHelp);


    }
    public void createFileMenu(){
        INew = new JMenuItem("New");
        INew.addActionListener(this);
        INew.setActionCommand("New");
        menuFile.add(INew);

        IOpen = new JMenuItem("Open");
        IOpen.addActionListener(this);
        IOpen.setActionCommand("Open");
        menuFile.add(IOpen);

        ISave = new JMenuItem("Save");
        ISave.addActionListener(this);
        ISave.setActionCommand("Save");
        menuFile.add(ISave);

        ISaveAs = new JMenuItem("Save As");
        ISaveAs.addActionListener(this);
        ISaveAs.setActionCommand(" ISaveAs");
        menuFile.add(ISaveAs);

        IExit = new JMenuItem("Exit");
        IExit.addActionListener(this);
        ISaveAs.setActionCommand(" IExit");
        menuFile.add(IExit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "New":
                file.newFile();
                break;

            case "Open":
                file.open();
                break;

            case "SaveAs":
                file.saveAs();
                break;

            case "Save":
                    file.save();
                break;



        }
    }
}
