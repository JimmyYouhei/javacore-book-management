package additional_util.sort;

import entity.Book;
import exception.DuplicationException;
import exception.InputNotProperlyException;
import exception.NoBookException;
import util.MyList;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public interface QuickSortUtil {

    public static MyList sortPrice(MyList bookList) throws NoBookException {

        ArrayList<Book> bookArrayList = makeNewArrayListFromList(bookList);

        quickSortPrice(bookArrayList , 0 , bookArrayList.size()-1);

        return convertBackToMyList(bookArrayList);

    }

    public static MyList sortBCode(MyList bookList) throws NoBookException {

        ArrayList<Book> bookArrayList = makeNewArrayListFromList(bookList);

        quickSortBCode(bookArrayList , 0 , bookArrayList.size()-1);

        return convertBackToMyList(bookArrayList);

    }

    private static void quickSortBCode(ArrayList<Book> bookArrayList, int start , int end) {

        if (start < end+1){

            int pivot = partitionBCode(bookArrayList , start , end);

            quickSortBCode(bookArrayList , start , pivot -1);
            quickSortBCode(bookArrayList , pivot+1 , end);
        }

    }

    private static int partitionBCode(ArrayList<Book> bookArrayList , int start , int end){

        swapPosition(bookArrayList , start , getPivot(start , end));

        int border = start + 1;

        for (int i = border ; i <= end ; i++){
            if (bookArrayList.get(i).getbCode().compareTo(bookArrayList.get(start).getbCode()) <0){
                swapPosition(bookArrayList , i , border++);
            }
        }

        swapPosition(bookArrayList , start , border-1);

        return border -1;
    }

    private static MyList convertBackToMyList(ArrayList<Book> bookArrayList) {
        MyList list = new MyList();
        for (Book aBookFromList: bookArrayList) {
            try {
                list.addLast(aBookFromList);
            } catch (InputNotProperlyException | DuplicationException ignored) {

            }
        }

        return list;
    }

    private static ArrayList<Book> makeNewArrayListFromList(MyList bookList) throws NoBookException {
        ArrayList<Book> bookArrayList = new ArrayList<>();

        for (int i = 0 ; i < bookList.size() ; i ++){

            bookArrayList.add(bookList.getNode(i).getInfo());

        }
        return bookArrayList;
    }

    private static void quickSortPrice(ArrayList<Book> bookArrayList , int start , int end){

        if (start < end+1){

            int pivot = partitionPrice(bookArrayList , start , end);

            quickSortPrice(bookArrayList , start , pivot -1);
            quickSortPrice(bookArrayList , pivot+1 , end);
        }

    }

    private static int partitionPrice(ArrayList<Book> bookArrayList , int start , int end){

        swapPosition(bookArrayList , start , getPivot(start , end));

        int border = start + 1;

        for (int i = border ; i <= end ; i++){
            if (bookArrayList.get(i).getPrice() < bookArrayList.get(start).getPrice()){
                swapPosition(bookArrayList , i , border++);
            }
        }

        swapPosition(bookArrayList , start , border-1);

        return border -1;
    }

    private static void swapPosition(ArrayList<Book> bookArrayList , int position1 , int position2){

        Book book = bookArrayList.get(position1);

        bookArrayList.set(position1 , bookArrayList.get(position2));
        bookArrayList.set(position2 , book);

    }

    private static int getPivot(int start , int end){
        return ThreadLocalRandom.current().nextInt(start , end +1);
    }

}
