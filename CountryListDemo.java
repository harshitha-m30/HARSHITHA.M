//5a. Develop a Swing program in Java to add the countries USA, India, Vietnam, Canada, Denmark,
//France, Great Britain, Japan, Africa, Greenland, Singapore into a JList and display them on console
//whenever the countries are selected on the list.

package swingg;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class CountryListDemo extends JFrame {

   
	JList<String> countryList;

    public CountryListDemo() {

        setTitle("Country List");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // List of countries
        String[] countries = {
            "USA", "India", "Vietnam", "Canada", "Denmark",
            "France", "Great Britain", "Japan", "Africa",
            "Greenland", "Singapore"
        };

        // Create JList
        countryList = new JList<>(countries);

        // Allow single selection
        countryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Add selection listener
        countryList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {

                // Avoid duplicate events
                if (!e.getValueIsAdjusting()) {

                    String selected = countryList.getSelectedValue();

                    // Print selected country to console
                    System.out.println("Selected Country: " + selected);
                }
            }
        });

        // Add scroll pane (important for JList)
        add(new JScrollPane(countryList));

        setVisible(true);
    }

    public static void main(String[] args) {
        new CountryListDemo();
    }
}
