package com.codeWithMoh;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Function_File {
    Notepad notepad;
    String fileName;
    String fileAddress;


    public Function_File(Notepad notepad) {
        //meaning we can access this notepad which is designing the gui from here
        this.notepad = notepad;
    }

    public void newFile() {

        //this is to access a new text area
        notepad.textArea.setText("");//erase the current text
        notepad.window.setTitle("New");//changing the title of the window.
    }

    public void open() {

        //open a pop up dialog box
        FileDialog fd = new FileDialog(notepad.window, "open", FileDialog.LOAD); //checks what is written on this window and button
        fd.setVisible(true);

        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            notepad.window.setTitle(fileName);
        }

        //Get the contents  of the text written ,use try and catch
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName)); //ypu need an address to read a file
            notepad.textArea.setText("");
            String line = null;
            while ((line = br.readLine()) != null) {
                notepad.textArea.append(line + "\n");
            }
            br.close();
        } catch (Exception e) {
            System.out.println("FILE NOT OPENED!!");
        }

    }

    public void save() {
        if (fileName == null) {

        }

    }

    public void saveAs() {
        FileDialog fd = new FileDialog(notepad.window, "save", FileDialog.SAVE);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            notepad.window.setTitle(fileName);
        }

    }
}

