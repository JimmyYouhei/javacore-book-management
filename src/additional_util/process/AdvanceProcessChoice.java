package additional_util.process;

import additional_util.IntegerUtil;
import additional_util.file.FileUtil;
import additional_util.file.print.PrinterUtil;
import additional_util.sort.BookListSort;
import additional_util.ui.AdvanceUI;
import additional_util.ui.UICommand;
import exception.BooksInMemoryException;
import exception.InputNotProperlyException;
import exception.NoBookException;
import wrapper.BookList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

import static additional_util.ui.UICommand.printBookColumName;

public interface AdvanceProcessChoice {

    public static void choice7(BookList books){
        AdvanceUI.printSortMenu();

        try {
            int sortType = IntegerUtil.askForInt("Please Input sort type: ");
            BookListSort.sortBook(books , sortType);
            printBookColumName();
            books.list();
        } catch (InputNotProperlyException e) {
            System.out.println(e.getMessage());
            choice7(books);
        } catch (NoBookException e) {
            System.out.println(e.getMessage());
            UICommand.reRun(books);
        }

    }

    public static void choice8(BookList books){

            try {
                FileUtil.saveFile(books);
                System.out.println("File saved");
            } catch (FileAlreadyExistsException e){
                System.out.println(e.getMessage());

                if (askForConfirm()){
                    try {
                        FileUtil.confirmSave(books);
                        System.out.println("File saved");
                    } catch (NoBookException | IOException ex) {
                        System.out.println(ex.getMessage());
                        UICommand.reRun(books);
                    }
                } else {
                    UICommand.reRun(books);
                }
            } catch (NoBookException | IOException e) {
                System.out.println(e.getMessage());
            }

    }

    public static void choice9(BookList books){

            try {
                FileUtil.loadFile(books);
            } catch (BooksInMemoryException e) {
                System.out.println(e.getMessage());
                if (askForConfirm()){
                    try {
                        FileUtil.confirmLoad(books);
                    } catch (FileNotFoundException ex) {
                        System.out.println(e.getMessage());
                        UICommand.reRun(books);
                    }
                } else {
                    UICommand.reRun(books);
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
                UICommand.reRun(books);
            }

    }



    private static boolean askForConfirm() {

        printYesNoMenu();
        int choice = -1;
        try {
            choice = IntegerUtil.askForInt("Please input the choice: ");
            return processChoice(choice);
        } catch (InputNotProperlyException e) {
            System.out.println(e.getMessage());
            askForConfirm();
        }

        return false;
    }

    private static boolean processChoice(int choice) throws InputNotProperlyException {

        switch (choice){
            case 1:
                return true;

            case 0:
                return false;


            default:
                throw new InputNotProperlyException("Please input properly");
        }

    }



    private static void printYesNoMenu(){
        System.out.println("Please confirm: 1 = yes and 0 = no");
    }

}
