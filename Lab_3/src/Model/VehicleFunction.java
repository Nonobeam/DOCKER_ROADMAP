package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author minht
 */
public class VehicleFunction {

    VehicleData vehData = new VehicleData();
    List<Vehicle> vehList = vehData.loadDataFromFile();

    public void addVehicle() {
        String id;
        String name;
        String color;
        int price;
        String brand;
        String type;
        int productYear;
        String check;
        //Input type of product want to add
        do {

            do {
                id = DataInput.getStringreg("Input Vehicle's ID (Cxxx): ", "C\\d{3}$", "ID must not be empty", "Invalid ID!");
                if (checkCode(id) == false) {
                    System.out.println("The code is duplicate");
                }
            } while (checkCode(id) == false);
            name = DataInput.getStringreg("Input Vehicle's name: ", "([A-Za-z]+(\\s{0,1}[A-Za-z]+)+)", "Name must not be empty", "Invalid name!");
            color = DataInput.getStringreg("Input Vehicle's color: ", "([A-Za-z]+(\\s{0,1}[A-Za-z]+)+)", "Color must not be empty", "Invalid color!");
            price = DataInput.getInt("Input Vehicle's price: ", -1);
            brand = DataInput.getStringreg("Input Vehicle's brand: ", "([A-Za-z]+(\\s{0,1}[A-Za-z]+)+)", "Brand must not be empty", "Invalid brand!");
            type = DataInput.getStringreg("Input Vehicle's type: ", "([A-Za-z]+(\\s{0,1}[A-Za-z]+)+)", "Type must not be empty", "Invalid type!");
            productYear = DataInput.getIntInRange("Input Vehicle's year: ", 1800, 2999);
            Vehicle newVehicle = new Vehicle(id, name, color, price, brand, type, productYear);
            vehList.add(newVehicle);
            System.out.println("Success");
            check = DataInput.getString("Do you want to continue?(Y/N):", "Must not be empty");
        } while (check.equalsIgnoreCase("y") || check.equalsIgnoreCase("yes"));
        vehData.createLog("Vehicle.txt", vehList);
    }

    public boolean checkExistVehicle() {
        String id = DataInput.getStringreg("Input Vehicle's ID: ", "C\\d{3}$", "ID must not be empty", "Invalid code!");
        for (Vehicle vehicle : vehList) {
            if (vehicle.getID_Vehicle().matches(id)) {
                return true;
            }
        }
        return false;
    }

    public Vehicle updateVehicle() {
        String check;
        String name;
        String color;
        int price;
        String brand;
        String type;
        int productYear;
        check = DataInput.getStringreg("Input Vehicle's ID: ", "C\\d{3}$", "ID must not be empty", "Invalid ID!");
        for (Vehicle vehicle : vehList) {
            if (check.equals(vehicle.getID_Vehicle())) {
                name = DataInput.getStringAllowEmpty("Input updated Vehicle's name: ");
                color = DataInput.getStringAllowEmpty("Input updated Vehicle's color: ");
                price = DataInput.getInt("Input updated product's price(input -1 for no change): ", -2);
                brand = DataInput.getStringAllowEmpty("Input updated Vehicle's brand: ");
                type = DataInput.getStringAllowEmpty("Input updated Vehicle's size: ");
                do {
                    productYear = DataInput.getInt("Input updated product's year(input -1 for no change): ", -2);
                    if (productYear == -1) {
                        break;
                    } else if (productYear < 1800 || productYear > 2999) {
                        System.out.println("Invalid Year");
                    }
                } while ((productYear < 1800 || productYear > 2999));
                if (!"".equals(name)) {
                    vehicle.setName_Vehicle(name);
                }

                if (!"".equals(color)) {
                    vehicle.setColor_Vehicle(color);
                }

                if (price != -1) {
                    vehicle.setPrice_Vehicle(price);
                }

                if (!"".equals(brand)) {
                    vehicle.setBrand_Vehicle(brand);
                }

                if (!"".equals(type)) {
                    vehicle.setType(type);
                }

                if (productYear != -1) {
                    vehicle.setProductYear(productYear);
                }
                vehData.createLog("Vehicle.txt", vehList);
                return vehicle;
            }

        }
        return null;
    }

    public boolean deleteVehicle() {
        String check;

        check = DataInput.getStringreg("Input Vehicle's ID: ", "C\\d{3}$", "Code must not be empty", "Invalid code!");
        for (int i = 0; i < vehList.size(); i++) {
            String checkCode = vehList.get(i).getID_Vehicle();
            if (checkCode.equals(check)) {
                check = DataInput.getString("Do you want to delete a product? (Y/N): ", "Must not be empty");
                if (check.equalsIgnoreCase("y") || check.equalsIgnoreCase("yes")) {

                    vehList.remove(i);
                    vehData.createLog("Vehicle.txt", vehList);
                    return true;

                } else {
                    return false;
                }
            }
        }

        return false;
    }

    public List<Vehicle> searchVehicle() {
        int option;
        String check;
        List<Vehicle> tempList = new ArrayList<>();
        System.out.println("1: Search by name");
        System.out.println("2: Search by ID");
        option = DataInput.getIntInRange("Input your search option: ", 1, 2);
        if (option == 1) {
            check = DataInput.getString("Make your input here:", "Must not be empty");
            for (Vehicle vehicle : vehList) {
                if (vehicle.getName_Vehicle().contains(check) == true) {
                    tempList.add(vehicle);
                }
            }
           Collections.sort(tempList, (Vehicle o1, Vehicle o2) -> {
               int d = o1.getName_Vehicle().compareTo(o2.getName_Vehicle());
               return -d;
            });
            return tempList;
        } else {
            check = DataInput.getStringreg("Input Vehicle's ID (Cxxx): ", "C\\d{3}$", "Code must not be empty", "Invalid ID!");
            for (Vehicle vehicle : vehList) {
                if (vehicle.getID_Vehicle().equals(check)) {
                    tempList.add(vehicle);
                }
            }
            return tempList;
        }
    }

    public List<Vehicle> displayVehicle() {
        int option;
        int check;
        List<Vehicle> tempList = new ArrayList<>();
        System.out.println("1: Display all");
        System.out.println("2: Display price");
        option = DataInput.getIntInRange("Input your search option: ", 1, 2);
        if (option == 1) {
            for (Vehicle vehicle : vehList) {
                tempList.add(vehicle);
            }
            return tempList;
        } else {
            check = DataInput.getInt("Input the Vehicle's Price", -1);
            for (Vehicle vehicle : vehList) {
                if (vehicle.getPrice_Vehicle() < check) {
                    tempList.add(vehicle);
                }
            }
            Collections.sort(tempList, (Vehicle o1, Vehicle o2) -> {
                int d = o1.getPrice_Vehicle() - o2.getPrice_Vehicle();
                return -d;
            });
            return tempList;
        }
    }

    public void saveData() {
        vehData.saveDataToFile();
    }

    public List<Vehicle> printVehicle() {
        int option;
        int check;
        List<Vehicle> tempList = new ArrayList<>();
        System.out.println("1: Print all");
        System.out.println("2: Print Year");
        System.out.println("3: print brand and price");
        option = DataInput.getIntInRange("Input your search option: ", 1, 3);
        if (option == 1) {
            for (Vehicle vehicle : vehList) {
                tempList.add(vehicle);
            }
            return tempList;
        } else if(option == 2 ){
            check = DataInput.getIntInRange("Input Vehicle's Year", 1800, 2999);
            for (Vehicle vehicle : vehList) {
                if (vehicle.getProductYear() > check) {
                    tempList.add(vehicle);
                }
            }            
            Collections.sort(tempList, (Vehicle a, Vehicle b) -> {
                int d = a.getProductYear() - b.getProductYear();
                return -d;
            });
            return tempList;
        }
        else{
            String x;
            int y;
            x = DataInput.getString("Input Vehicle's brand: ","must not be empty");
            y = DataInput.getInt("Input the Vehicle's Price: ", -1);
            for (Vehicle vehicle : vehList) {
                if (vehicle.getBrand_Vehicle().contains(x) == true && vehicle.getPrice_Vehicle() >= y) {
                    tempList.add(vehicle);
                }
            }
            return tempList;
        }
    }
    
    //xe cos bramd chua chuoi x  va gia >= y (x,y nhap tu ban phim; x la mot via ky tu bat ky cua brand va no case-sensitive

    public boolean checkCode(String check) {
        for (Vehicle vehicle : vehList) {
            if (vehicle.getID_Vehicle().matches(check)) {
                return false;
            }
        }
        return true;
    }
}
