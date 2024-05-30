import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CarDisplay {

    public CarDisplay(List<String> carList) {
        // Create a new frame to display all cars
        JFrame displayFrame = new JFrame("All Cars Information");
        displayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        displayFrame.setSize(400, 300);
        displayFrame.setLayout(new BorderLayout());

        // Create a text area to display car information
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        for (String car : carList) {
            textArea.append(car + "\n");
        }

        // Add the text area to the frame
        displayFrame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Create buttons for oldest and most expensive car
        JButton oldestCarButton = new JButton("Find Oldest Car");
        JButton mostExpensiveCarButton = new JButton("Find Most Expensive Car");

        // Add action listeners for buttons
        oldestCarButton.addActionListener(e -> findOldestCarAndDisplay(carList));
        mostExpensiveCarButton.addActionListener(e -> findMostExpensiveCarAndDisplay(carList));

        // Add buttons to the panel
        buttonPanel.add(oldestCarButton);
        buttonPanel.add(mostExpensiveCarButton);

        // Add the button panel to the frame
        displayFrame.add(buttonPanel, BorderLayout.SOUTH);

        // Set the frame visibility to true
        displayFrame.setVisible(true);
    }

    private void findOldestCarAndDisplay(List<String> carList) {
        String oldestCarName = null;
        int oldestYear = Integer.MAX_VALUE;

        for (String carInfo : carList) {
            int yearIndex = carInfo.indexOf("Year: ");
            if (yearIndex != -1) {
                String yearString = carInfo.substring(yearIndex + 6, yearIndex + 10);
                int year = Integer.parseInt(yearString);
                if (year < oldestYear) {
                    oldestYear = year;
                    int nameIndex = carInfo.indexOf("Car Name: ");
                    if (nameIndex != -1) {
                        int endIndex = carInfo.indexOf(",", nameIndex);
                        oldestCarName = carInfo.substring(nameIndex + 10, endIndex);
                    }
                }
            }
        }

        if (oldestCarName != null) {
            JOptionPane.showMessageDialog(null, "The oldest car is: " + oldestCarName, "Oldest Car", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No cars found!", "Oldest Car", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void findMostExpensiveCarAndDisplay(List<String> carList) {
        String mostExpensiveCarName = null;
        double maxPrice = Double.MIN_VALUE;

        for (String carInfo : carList) {
            int priceIndex = carInfo.indexOf("Price: ");
            if (priceIndex != -1) {
                int endIndex = carInfo.indexOf(",", priceIndex);
                if (endIndex == -1) { // in case price is the last information in the string
                    endIndex = carInfo.length();
                }
                String priceString = carInfo.substring(priceIndex + 7, endIndex).trim();
                try {
                    double price = Double.parseDouble(priceString);
                    if (price > maxPrice) {
                        maxPrice = price;
                        int nameIndex = carInfo.indexOf("Car Name: ");
                        if (nameIndex != -1) {
                            int nameEndIndex = carInfo.indexOf(",", nameIndex);
                            if (nameEndIndex == -1) {
                                nameEndIndex = carInfo.length();
                            }
                            mostExpensiveCarName = carInfo.substring(nameIndex + 10, nameEndIndex);
                        }
                    }
                } catch (NumberFormatException e) {
                    // Handle any potential parsing errors gracefully
                    System.err.println("Error parsing price: " + priceString);
                }
            }
        }

        if (mostExpensiveCarName != null) {
            JOptionPane.showMessageDialog(null, "The most expensive car is: " + mostExpensiveCarName, "Most Expensive Car", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No cars found!", "Most Expensive Car", JOptionPane.ERROR_MESSAGE);
        }
    }
}
