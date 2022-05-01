package repository;

import model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class BookRepositoryImpl implements BookRepository{

    EntityManager entityManager = jpaFactory.getEntityManager();
    EntityTransaction transaction = jpaFactory.getTransaction();

    @Override
    public void save(Book book) {
        transaction.begin();

        entityManager.persist(book);

        transaction.commit();
    }

    @Override
    public void remove(Book book) {
        transaction.begin();

        entityManager.remove(find(book.getId()));

        transaction.commit();
    }

    @Override
    public Book update(Book book) {
        transaction.begin();

        Book updatedBook = this.entityManager.merge(book);

        transaction.commit();

        return updatedBook;
    }

    @Override
    public Book find(Integer id) {
        Book book = this.entityManager.find(Book.class, id);

        return book;
    }
}
