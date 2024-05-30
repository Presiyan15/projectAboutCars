/*
 * Decompiled with CFR 0.150.
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static String mostExpensiveCar() {
        File file1 = new File("Cars.txt");
        String name = "";
        double mostExpensive = 0.0;
        try {
            Scanner input = new Scanner(file1);
            while (input.hasNext()) {
                String name1 = input.next();
                String year = input.next();
                double horsePower = input.nextDouble();
                double price = input.nextDouble();
                if (!(price > mostExpensive)) continue;
                name = name1;
                mostExpensive = price;
            }
            input.close();
        }
        catch (Exception e) {
            System.out.println("There is an error in the system, please wait");
        }
        return name;
    }

    public static String oldestCar() {
        File file1 = new File("Cars.txt");
        String name = "";
        double oldest = 3000.0;
        try {
            Scanner input = new Scanner(file1);
            String p = input.nextLine();
            while (input.hasNext()) {
                String name1 = input.next();
                double year = Double.valueOf(input.next());
                double horsePower = Double.valueOf(input.next());
                double price = Double.valueOf(input.next());
                if (!(year < oldest)) continue;
                name = name1;
                oldest = year;
            }
            input.close();
        }
        catch (Exception e) {
            System.out.println("There is an error in the system, please wait");
        }
        return name;
    }

    public static void addCar(int n) {
        try (FileWriter file2 = new FileWriter("Cars.txt", true);
             BufferedWriter file3 = new BufferedWriter(file2);
             Scanner input = new Scanner(System.in);){
            for (int i = 0; i < n; ++i) {
                String name1 = input.next();
                String year = input.next();
                double horsePower = Double.valueOf(input.next());
                double price = Double.valueOf(input.next());
                file3.append(name1 + " " + year + " " + horsePower + " " + price);
                file3.newLine();
            }
            input.close();
        }
        catch (Exception e) {
            System.out.println("An error may have occurred");
        }
    }

    public static void main(String[] args) {
        GUI sample = new GUI();
    }
}
