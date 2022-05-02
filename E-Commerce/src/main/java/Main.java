import model.Product;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence-unit");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        User user = new User("Farid", "Tahmazov");
        Product product1 = new Product("Asus Tuf Gaming F15", 2300.00, 123, new Date());
        Product product2 = new Product("MSI M11", 3400.00, 23, new Date());

        product1.setUser(user);
        product2.setUser(user);

        transaction.begin();
        entityManager.persist(product1);
        entityManager.persist(product2);
        entityManager.persist(user);
        transaction.commit();
    }
}
