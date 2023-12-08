
import Controller.VehicleController;
import Model.DataInput;
/**
 *
 * @author minht
 */
public class Program {
    public static void main(String[] args) {
        int inputNum;
        boolean stop = true;
        VehicleController controller = new VehicleController();
        do {
            System.out.println("1: Add new vehicle ");
            System.out.println("2: Check to exist Vehicle");
            System.out.println("3: Update vehicle");
            System.out.println("4: Delete vehicle");
            System.out.println("5: Search vehicle");
            System.out.println("6: Display vehicle list");
            System.out.println("7: Save data to file");
            System.out.println("8: Print vehicle list");
            System.out.println("9: Close the Application");
            inputNum = DataInput.getIntInRange("Input your choices: ", 1, 9);
            switch (inputNum) {
                case 1 -> {
                    controller.addVehicle();
                    break;
                }
                case 2 -> {
                    controller.checkExistVehicle();
                    break;
                }
                case 3 -> {
                    controller.updateVehicle();
                    break;
                }
                case 4 -> {
                    controller.deleteVehicle();
                    break;
                }
                 case 5 -> {
                    controller.searchVehcile();
                    break;
                }
                  case 6 -> {
                    controller.displayVechicle();
                    break;
                }
                   case 7 -> {
                    controller.saveData();
                    break;
                }
                    case 8 -> {
                    controller.printVehicle();
                    break;
                }
                case 9 -> {
                    System.out.println("Have a nice day");
                    stop = false;
                }

                default -> {
                    System.out.println("Invalid input");
                }
            }
        } while (stop);
    }
}
