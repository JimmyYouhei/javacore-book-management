package additional_util;

import exception.InputNotProperlyException;

import java.util.Scanner;

public interface StringUtil  {

    static Scanner sc = new Scanner(System.in);

    public static boolean checkInputProperly(String entity) throws InputNotProperlyException {
        if (entity.trim().equals("")){
            throw new InputNotProperlyException("no String input is given");
        }
        return true;
    }

    public static String askForString(String message){
        System.out.print(message);
        return sc.nextLine();
    }

}
