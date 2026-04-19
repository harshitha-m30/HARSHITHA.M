//5d. Develop a Swing program in Java to create a Tabbed Pan of Cyan, Magenta and Yellow and
//display the concerned color whenever the specific tab is selected in the Pan

package swing;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class TabCMYDemo extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTabbedPane tabbedPane;

    public TabCMYDemo() {

        setTitle("Tabbed Pane - CMY Colors");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create TabbedPane
        tabbedPane = new JTabbedPane();

        // Create panels with colors
        JPanel cyanPanel = new JPanel();
        cyanPanel.setBackground(Color.CYAN);

        JPanel magentaPanel = new JPanel();
        magentaPanel.setBackground(Color.MAGENTA);

        JPanel yellowPanel = new JPanel();
        yellowPanel.setBackground(Color.YELLOW);

        // Add tabs
        tabbedPane.addTab("CYAN", cyanPanel);
        tabbedPane.addTab("MAGENTA", magentaPanel);
        tabbedPane.addTab("YELLOW", yellowPanel);

        // Add ChangeListener
        tabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int index = tabbedPane.getSelectedIndex();

                if (index == 0) {
                    System.out.println("CYAN tab selected");
                } else if (index == 1) {
                    System.out.println("MAGENTA tab selected");
                } else if (index == 2) {
                    System.out.println("YELLOW tab selected");
                }
            }
        });

        // Add to frame
        add(tabbedPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        new TabCMYDemo();
    }
}
