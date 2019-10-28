package additional_util.file.loader;

import additional_util.file.FileUtil;
import entity.Book;
import exception.DuplicationException;
import exception.InputNotProperlyException;
import util.MyList;
import wrapper.BookList;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public interface FileLoader {

    public static void loadFile(BookList books) throws FileNotFoundException {

        Scanner scanner = new Scanner(FileUtil.newFile);

        scanner.nextLine();

        MyList bookList = new MyList();

        while (scanner.hasNext()){
            String bCode = scanner.next();
            String title = scanner.next();
            int quantity = scanner.nextInt();
            int lended = scanner.nextInt();
            double price = scanner.nextDouble();
            Book newBook = new Book(bCode , title , quantity , lended , price);
            try {
                bookList.addLast(newBook);
            } catch (InputNotProperlyException | DuplicationException ignored) {

            }
            scanner.nextLine();
        }

        books.setBooks(bookList);

    }

}
