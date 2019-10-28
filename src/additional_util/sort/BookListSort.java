package additional_util.sort;

import exception.InputNotProperlyException;
import exception.NoBookException;
import util.MyList;
import wrapper.BookList;

public interface BookListSort {


    public static void sortBook(BookList books , int sortType) throws NoBookException, InputNotProperlyException {

        switch (sortType){
            case 1:
                books.setBooks(BookListSort.sortByPrice(books.getBooks()));
                break;

            case 2:
                books.setBooks(BookListSort.sortByBCode(books.getBooks()));
                break;

            default:
                throw new InputNotProperlyException("please input choice properly");

        }

    }

    private static MyList sortByPrice(MyList list) throws NoBookException {

        if (list.isEmpty() ){
            throw new NoBookException("no book is loaded");
        }

        if (list.size() == 1){
            return list;
        }

        return QuickSortUtil.sortPrice(list);

    }

    private static MyList sortByBCode (MyList list) throws NoBookException {

        if (list.isEmpty() ){
            throw new NoBookException("no book is loaded");
        }

        if (list.size() == 1){
            return list;
        }

        return QuickSortUtil.sortBCode(list);

    }

}
