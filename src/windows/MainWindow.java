package windows;

import functionality.FileOperator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by AKrzos on 2016-08-15.
 */
public class MainWindow extends JFrame {
    private JButton saveStashButton;
    private JButton loadStashButton;
    private JPanel rootPanel;
    private JButton saveCharButton;
    private JButton savePersonalStashButton;
    private JButton savePersonalStashButton1;
    private JButton loadCharButton;
    private JComboBox charSelectionComboBox;
    
    public final static String saveGamePath = "C:\\Program Files (x86)\\Diablo II\\save";

    public MainWindow() {

        //todo - create backup folder on creation
        super("Diablo Saver");
        setResizable(false);
        setContentPane(rootPanel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        saveStashButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileOperator.makeBackup("_LOD_SharedStashSave.sss"); //todo
                FileOperator.saveSharedStash();
            }
        });
        loadStashButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileOperator.makeBackup("_LOD_SharedStashSave.sss"); //todo
                FileOperator.loadSharedStash();
            }
        });

        for (String s : FileOperator.listCharsInDirectory()) {
            charSelectionComboBox.addItem(s);
        }
        FileOperator.setSelectedChar((String) charSelectionComboBox.getSelectedItem());
        saveCharButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileOperator.saveCharFile();
            }
        });
        loadCharButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileOperator.loadCharFile();
            }
        });
    }


}
