package repository;

import jpaFactory.JpaFactory;
import jpaFactory.JpaFactoryImpl;
import model.Book;

public interface BookRepository {
    JpaFactory jpaFactory = new JpaFactoryImpl();

    void save(Book book);

    void remove(Book book);

    Book update(Book book);

    Book find(Integer id);
}
