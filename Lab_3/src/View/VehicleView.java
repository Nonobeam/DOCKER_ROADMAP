
package View;

import Model.Vehicle;

/**
 *
 * @author minht
 */
public class VehicleView {

    public void exist(boolean check) {
        if (check == false) {
            System.out.println("No vehicle existed");
        } else {
            System.out.println("Existed Vehicle");
        }
    }

    public void printVehicle(Vehicle vehicle) {
        if (vehicle != null) {
            System.out.println("Vehicle's ID: " + vehicle.getID_Vehicle());
            System.out.println("Vehicle's name: " + vehicle.getName_Vehicle());
            System.out.println("Vehicle's color: " + vehicle.getColor_Vehicle());
            System.out.println("Vehicle's price: " + vehicle.getPrice_Vehicle());
            System.out.println("Vehicle's brand: " + vehicle.getBrand_Vehicle());
            System.out.println("Vehicle's type: " + vehicle.getType());
            System.out.println("Product year: " + vehicle.getProductYear());
        } else {
            System.out.println("Vehicle does not exist");
        }

    }
    
    public void checkSuccess(boolean check){
        if(check == false){
            System.out.println("Fail");
        }else{
            System.out.println("Success");
        }
    }
}
