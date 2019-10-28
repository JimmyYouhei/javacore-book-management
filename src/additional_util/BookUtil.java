package additional_util;

import entity.Book;
import exception.DuplicationException;
import exception.InputNotProperlyException;
import exception.NoBookException;
import util.MyList;

import java.io.FileNotFoundException;

public interface BookUtil {


    public static boolean checkInputProperly(Book entity) throws InputNotProperlyException {
        if (entity.getbCode() == null){
            throw new InputNotProperlyException("all the book must have a bCode");
        }
        return true;
    }

    public static void bCodeAlreadyExist (Book book , MyList thisList) throws InputNotProperlyException, DuplicationException {
        try {
            if (thisList.search(book.getbCode()) != null){
                throw new DuplicationException("book duplication error");
            }
        } catch (FileNotFoundException | NoBookException ignored) {

        }
    }

    public static void bCodeAlreadyExist (String bCode , MyList thisList) throws InputNotProperlyException, DuplicationException {

        try {
            if (thisList.search(bCode) != null){
                throw new DuplicationException("Book code must be unique");
            }
        } catch (FileNotFoundException | NoBookException ignored) {

        }
    }

    public static Book askForBookInput(MyList thisList) throws InputNotProperlyException, NumberFormatException, DuplicationException {
        System.out.println("Please Input the Book Detail below:");

        String bCode = StringUtil.askForString("Book Code: ");

        StringUtil.checkInputProperly(bCode);
        bCodeAlreadyExist(bCode , thisList);

        String title = StringUtil.askForString("Book Title: ");

        int quantity = IntegerUtil.askForInt("Book quantity: ");

        int lender = IntegerUtil.askForInt("Book Lended: ");

        double price = DoubleUtil.askForDouble("Book Price: ");

        return new Book(bCode , title, quantity , lender , price);

    }


}
