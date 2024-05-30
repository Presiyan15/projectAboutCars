import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GUI {
    protected List<String> carList = new ArrayList<>();

    public GUI() {
        // Create the main frame
        JFrame frame = new JFrame("Car Information");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(6, 2));

        // Create labels and text fields
        JLabel nameLabel = new JLabel("Car Name:");
        JTextField nameField = new JTextField();

        JLabel horsePowerLabel = new JLabel("Horse Power:");
        JTextField horsePowerField = new JTextField();

        JLabel yearLabel = new JLabel("Year:");
        JTextField yearField = new JTextField();

        JLabel priceLabel = new JLabel("Price:");
        JTextField priceField = new JTextField();

        // Create the add button
        JButton addButton = new JButton("Add Car");

        // Add action listener to the add button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get text from the text fields
                String name = nameField.getText();
                String horsePower = horsePowerField.getText();
                String year = yearField.getText();
                String price = priceField.getText();

                // Add car information to the list and optionally save to file
                addCar(name, horsePower, year, price);

                // Clear the text fields for new input
                nameField.setText("");
                horsePowerField.setText("");
                yearField.setText("");
                priceField.setText("");

                // Show dialog with options to add another car or finish
                int option = JOptionPane.showOptionDialog(frame,
                        "Car added successfully! Would you like to add another car or finish?",
                        "Continue or Finish",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new String[]{"Add Another Car", "Finish"},
                        "Add Another Car");

                // If the user chooses to finish, display all cars in a new window
                if (option == JOptionPane.NO_OPTION) {
                    new CarDisplay(carList);
                    frame.dispose(); // Close the main application window
                }
            }
        });

        // Add components to the main frame
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(horsePowerLabel);
        frame.add(horsePowerField);
        frame.add(yearLabel);
        frame.add(yearField);
        frame.add(priceLabel);
        frame.add(priceField);
        frame.add(new JLabel()); // empty cell
        frame.add(addButton);

        // Set the frame visibility to true
        frame.setVisible(true);
    }

    // Method to add a car to the list, can be overridden
    protected void addCar(String name, String horsePower, String year, String price) {
        // Combine car information into a single string and add it to the list
        String carInfo = "Car Name: " + name + ", Horse Power: " + horsePower + ", Year: " + year + ", Price: " + price;
        carList.add(carInfo);
    }

    public static void main(String[] args) {
        new GUI();
    }
}




