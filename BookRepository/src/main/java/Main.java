import model.Book;
import repository.BookRepository;
import repository.BookRepositoryImpl;

import java.util.Calendar;
import java.util.Date;

public class Main{

    public static void main(String[] args) {
        Book book = new Book(1, "İkinci Addım", 423,
                "relation and gods", "Qaraqan", createCustomDate(21, 7, 2015));

        Book book2 = new Book(2, "Evakuasiya", 497,
                "Masson and actions", "Qaraqan", createCustomDate(13, 10, 2017));

        BookRepository repository = new BookRepositoryImpl();
        book.setPublisherDate(createCustomDate(11, 11, 2011));
        book.setAuthor("Elxan Zeynalli");


        book2.setAuthor("Elxan Zeynalli");
        book2.setTopic("Adventure and Science");

        repository.remove(book2);

    }

    public static Date createCustomDate(int day, int month, int year){

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);

        return calendar.getTime();
    }
}
