package Model;

import java.util.Scanner;
public class DataInput {

    public static String getStringAllowEmpty(String welcome) {
        String result;
        Scanner sc = new Scanner(System.in);
        System.out.print(welcome);
        result = sc.nextLine().toUpperCase();
        return result;
    }

    public static String getString(String welcome, String msg) {
        boolean check = true;
        String result = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(welcome);
            result = sc.nextLine().toUpperCase();
            if (result.isEmpty()) {
                System.out.println(msg);
            } else {
                check = false;
            }
        } while (check);
        return result;
    }

    public static String getStringreg(String welcome, String pattern, String msg, String msgreg) {
        boolean check = true;
        String result = "";
        Scanner sc = new Scanner(System.in);
        do {

            System.out.print(welcome);
            result = sc.nextLine().toUpperCase();
            if (result.isEmpty()) {
                System.out.println(msg);
            } else if (!result.matches(pattern)) {
                System.out.println(msgreg);
            } else {
                check = false;
            }
        } while (check);
        return result;
    }
    
    public static int getInt(String welcome, int min) {
        boolean check = true;
        int number = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {

                System.out.print(welcome);
                number = Integer.parseInt(sc.nextLine());
                if (number <= min) {
                    System.out.println("Number must be large than " + min);

                } else {
                    check = false;
                }

            } catch (NumberFormatException e) {
                System.out.println("Input number!!!");
            }
        } while (check || number <= min);
        return number;
    }

    public static int getIntInRange(String welcome, int min, int max) {
        boolean check = true;
        int number = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {

                System.out.print(welcome);
                number = Integer.parseInt(sc.nextLine());
                if (number < min) {
                    System.out.println("Number must be large than " + min);
                } else if (number > max) {
                    System.out.println("Number must be smaller than " + max);
                } else {
                    check = false;
                }

            } catch (NumberFormatException e) {
                System.out.println("Input number!!!");
            }
        } while (check || number < min || number > max);
        return number;
    }
}
