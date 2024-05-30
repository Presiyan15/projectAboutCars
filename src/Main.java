import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
public class Main {



    public static void main(String[] args) {

       //System.out.println(oldestCar());
     //  System.out.println(mostExpensiveCar());

       //GUI sample  new GUI();
        try {
            // Load the image of a car
            ImageIcon carIcon = new ImageIcon("img.png");

            // Create a label to display the image
            JLabel carLabel = new JLabel(carIcon);

            // Create a frame to display the image
            JFrame frame = new JFrame("Car Picture");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(carLabel, BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null); // Center the frame on the screen
            frame.setVisible(true);
            frame.add(carLabel);
        } catch (Exception e) {
            System.err.println("Error loading or displaying car picture: " + e.getMessage());
        }
        FileSavingGUI fileSavingGUI = new FileSavingGUI();


    }
}