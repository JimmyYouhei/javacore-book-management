package additional_util.ui;

import additional_util.IntegerUtil;
import additional_util.process.ProcessChoice;
import exception.InputNotProperlyException;
import wrapper.BookList;



public interface UICommand {

    public static void printMenu(){
        System.out.println("Book List");
        System.out.println("1.Input Book and add to the end");
        System.out.println("2.Display books");
        System.out.println("3.Search by code");
        System.out.println("4.Input Book and add to beginning");
        System.out.println("5.Add Book after position k");
        System.out.println("6.Delete Book at position k");
        AdvanceUI.printAdvanceCommand();
        System.out.println("0.Exit");
    }

    public static void processChoice(BookList books , int choice) throws InputNotProperlyException {

        switch (choice){
            case 1:
                ProcessChoice.choice1(books);
                reRun(books);
                break;

            case 2:
                ProcessChoice.choice2(books);
                reRun(books);
                break;

            case 3:
                ProcessChoice.choice3(books);
                reRun(books);
                break;

            case 4:
                ProcessChoice.choice4(books);
                reRun(books);
                break;

            case 5:
                ProcessChoice.choice5(books);
                reRun(books);
                break;

            case 6:
                ProcessChoice.choice6(books);
                reRun(books);
                break;

            case 7 :
            case 8 :
            case 9 :
                AdvanceUI.processChoice(books , choice);
                break;

            case 0:
                ProcessChoice.choice0();
                break;

            default:
                throw new InputNotProperlyException("There is no such choice");
        }

    }

    public static void runStart(BookList books){
        printMenu();
        int choice = 0;
        try {
            choice = IntegerUtil.askForInt("Your choice: ");
        } catch (InputNotProperlyException e) {
            System.out.println(e.getMessage());
            reRun(books);
        }

        try {
            processChoice(books , choice);
        } catch (InputNotProperlyException e) {
            System.out.println(e.getMessage());
            reRun(books);
        }
    }

    public static void spacePrint(){
        System.out.println("*************************************");
        System.out.println("*************************************");
    }

    public static void printBookColumName(){
        System.out.println(String.format("%-10s%-20s%-10s%-10s%-10s%-10s", "Code","Title",
                "Quantity" , "Lender" , "Price" , "Value"));
    }

    public static void reRun(BookList books){
        spacePrint();
        runStart(books);
    }

}
