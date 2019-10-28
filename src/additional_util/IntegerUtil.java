package additional_util;

import exception.InputNotProperlyException;

import java.util.Scanner;

public interface IntegerUtil {

    static Scanner sc = new Scanner(System.in);

    public static int askForInt(String message) throws InputNotProperlyException {
        try {
            System.out.print(message);
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            throw new InputNotProperlyException("Please Input a number");
        }
    }

}
