
package Controller;

import java.util.List;

import Model.Vehicle;
import Model.VehicleFunction;
import View.VehicleView;

/**
 *
 * @author minht
 */
public class VehicleController {
    
    VehicleFunction model = new VehicleFunction();
    VehicleView view = new VehicleView();
    
    public void addVehicle(){
        model.addVehicle();
    }
    
    public void checkExistVehicle(){
         boolean check;
         check = model.checkExistVehicle();
         view.exist(check);
    }
    
    public void updateVehicle(){
        Vehicle updateVehicle = model.updateVehicle();
        if(updateVehicle != null)
        view.printVehicle(updateVehicle);
        else{
            view.exist(false);
        }
    }
    
    public void deleteVehicle(){
        view.checkSuccess(model.deleteVehicle());
    }
    
    public void searchVehcile(){
         List<Vehicle> tempList = model.searchVehicle();
        if(!tempList.isEmpty()){
            for (Vehicle vehicle : tempList) {
                view.printVehicle(vehicle);
            }
        }else{
            view.exist(false);
        }
    }
    
    public void displayVechicle(){
        List<Vehicle> tempList = model.displayVehicle();
        if(!tempList.isEmpty()){
            for (Vehicle vehicle : tempList) {
                view.printVehicle(vehicle);
            }
        }else{
            view.exist(false);
        }
    }
    
    public void saveData(){
        model.saveData();
    }
    
    public void printVehicle(){
         List<Vehicle> tempList = model.printVehicle();
        if(!tempList.isEmpty()){
            for (Vehicle vehicle : tempList) {
                view.printVehicle(vehicle);
            }
        }else{
            view.exist(false);
        }
    }
}
