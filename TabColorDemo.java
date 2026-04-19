package swingg;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class TabColorDemo extends JFrame {

    JTabbedPane tabbedPane;

    public TabColorDemo() {

        setTitle("Tabbed Pane Color Demo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create TabbedPane
        tabbedPane = new JTabbedPane();

        // Create panels for each tab
        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.BLUE);

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.GREEN);

        // Add tabs
        tabbedPane.addTab("RED", redPanel);
        tabbedPane.addTab("BLUE", bluePanel);
        tabbedPane.addTab("GREEN", greenPanel);

        // Add ChangeListener
        tabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int index = tabbedPane.getSelectedIndex();

                if (index == 0) {
                    System.out.println("RED tab selected");
                } else if (index == 1) {
                    System.out.println("BLUE tab selected");
                } else if (index == 2) {
                    System.out.println("GREEN tab selected");
                }
            }
        });

        // Add tabbed pane to frame
        add(tabbedPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        new TabColorDemo();
    }
}