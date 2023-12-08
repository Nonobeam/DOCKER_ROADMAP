
package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author minht
 */
public class VehicleData {

    List<Vehicle> vehList = new ArrayList<>();

    public List<Vehicle> loadDataFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileExist()));
            String id;
            String name;
            String color;
            int price;
            String brand;
            String type;
            int year;
            String line;
            while ((line = br.readLine()) != null) {
                String[] veh = line.split(",");
                id = veh[0];
                name = veh[1];
                color = veh[2];
                price = Integer.parseInt(veh[3]);
                brand = veh[4];
                type = veh[5];
                year = Integer.parseInt(veh[6]);
                Vehicle vehicle = new Vehicle(id, name, color, price, brand, type, year);
                vehList.add(vehicle);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("IO exception");
        }
        return vehList;
    }

    public void saveDataToFile() {
        File f = new File("Vehicle.dat");
        File check = new File("Vehicle.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(check));
            f.createNewFile();
            Path pathOut = (Path) Paths.get("Vehicle.txt");
            Path pathIn = (Path) Paths.get("Vehicle.dat");
            if ((br.readLine()) != null) {
                Files.copy(pathOut, pathIn, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
        }

    }

    public String fileExist() {
        String fileName = "Vehicle.dat";
        File f = new File(fileName);
        try {
            f.createNewFile();
        } catch (IOException ex) {
            System.out.println("IO exception");
        }
        return fileName;
    }

    public void createLog(String fileName, List<Vehicle> list) {
        try {
            File f = new File(fileName);
            PrintWriter pw = new PrintWriter(f);
            list.forEach(pw::println);
            pw.close();
        } catch (IOException e) {
            System.out.println("IO exception");
        }
    }
}
