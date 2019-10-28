package additional_util.process;

import additional_util.BookUtil;
import additional_util.IntegerUtil;
import additional_util.StringUtil;
import entity.Book;
import exception.DuplicationException;
import exception.InputNotProperlyException;
import exception.NoBookException;
import wrapper.BookList;

import java.io.FileNotFoundException;

import static additional_util.ui.UICommand.*;

public interface ProcessChoice {

    static void choice1(BookList books) {
        try {
            books.addLast(BookUtil.askForBookInput(books.getBooks()));
            printBookColumName();
            books.list();
        } catch (DuplicationException | NoBookException e) {
            System.out.println(e.getMessage());
            reRun(books);
        } catch (InputNotProperlyException e) {
            System.out.println(e.getMessage());
            choice1(books);
        }
    }

    static void choice2(BookList books){

        try {
            printBookColumName();
            books.list();
        } catch (NoBookException e) {
            System.out.println(e.getMessage());
            reRun(books);
        }
    }

    static void choice3(BookList books) {

        try {
            String bCode = StringUtil.askForString("Enter book Code: ");
            StringUtil.checkInputProperly(bCode);

            Book bookFound = books.search(bCode);
            System.out.println("Information of book code: " + bCode);
            printBookColumName();
            System.out.println(bookFound.toString());
        } catch (InputNotProperlyException e) {
            System.out.println(e.getMessage());
            choice3(books);
        } catch (FileNotFoundException | NoBookException e) {
            System.out.println(e.getMessage());
            reRun(books);
        }

    }

    static void choice4(BookList books){

        try {
            books.addFirst(BookUtil.askForBookInput(books.getBooks()));
            printBookColumName();
            books.list();
        } catch (DuplicationException | NoBookException e) {
            System.out.println(e.getMessage());
            reRun(books);
        } catch (InputNotProperlyException e) {
            System.out.println(e.getMessage());
            choice4(books);
        } catch (NumberFormatException e){
            System.out.println("please input number properly");
            choice4(books);
        }

    }

    static void choice5(BookList books){
        try {
            Book newBook = BookUtil.askForBookInput(books.getBooks());
            int positionToAdd = IntegerUtil.askForInt("Enter adding position: ");
            books.addAfter(newBook , positionToAdd);
            printBookColumName();
            books.list();
        } catch (InputNotProperlyException | DuplicationException e) {
            System.out.println(e.getMessage());
            choice5(books);
        } catch (NoBookException | IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            reRun(books);
        }
    }

    static void choice6(BookList books){
        try {
            int positionToDelete = IntegerUtil.askForInt("Enter Delete Position: ");
            books.deleteAt(positionToDelete);
            books.list();
        } catch (NoBookException | IndexOutOfBoundsException | InputNotProperlyException e) {
            System.out.println(e.getMessage());
            reRun(books);
        }

    }

    static void choice0(){
        System.exit(0);
    }

}
