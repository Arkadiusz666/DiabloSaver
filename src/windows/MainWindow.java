package windows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by AKrzos on 2016-08-15.
 */
public class MainWindow extends JFrame{
    private JButton saveStashButton;
    private JButton loadStashButton;
    private JPanel rootPanel;

    public MainWindow() {
        super("Diablo Saver");

        setContentPane(rootPanel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        saveStashButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        loadStashButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
