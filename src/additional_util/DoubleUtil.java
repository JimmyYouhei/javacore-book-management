package additional_util;

import exception.InputNotProperlyException;

import java.util.Scanner;

public interface DoubleUtil {

    static Scanner sc = new Scanner(System.in);

    public static double askForDouble(String message) throws InputNotProperlyException {
        try {
            System.out.print(message);
            return Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            throw new InputNotProperlyException("Please Input a number");
        }

    }

}
