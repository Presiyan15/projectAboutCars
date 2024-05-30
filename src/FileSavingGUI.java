import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileSavingGUI extends GUI {


    @Override
    public void addCar(String name, String horsePower, String year, String price) {
        super.addCar(name, horsePower, year, price); // Call the parent class method

        // Save the car information to file
        String carInfo = "Car Name: " + name + ", Horse Power: " + horsePower + ", Year: " + year + ", Price: " + price;
        saveCarToFile(carInfo);
    }

    private void saveCarToFile(String carInfo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Cars.txt", true))) {
            bw.write(carInfo);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        FileSavingGUI fileSavingGUI = new FileSavingGUI();
    }
}


