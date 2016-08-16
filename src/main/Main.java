package main;

import functionality.FileOperator;
import windows.MainWindow;

import javax.swing.*;

/**
 * Created by AKrzos on 2016-08-15.
 */
public class Main {
    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        FileOperator.testPrintFiles(FileOperator.listFilesInDirectory("/src/data/save"));
        FileOperator.saveStash("/src/data/save");
    }
}
