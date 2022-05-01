import model.Address;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence-unit");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        User user = new User(null, "Farid", "Tahmazov", new Date());
        user.addAddress(new Address("Azerbaijan", "Baku", "Qalubiyya 17A", "A66"));
        user.addAddress(new Address("Italy", "Milano", "Joinure ab", "W2"));

        User user2 = new User(null, "Xanim", "Racabova", new Date());
        user2.addAddress(new Address("Azerbaijan", "Baku", "H.Aliyev 12", "M14"));

        transaction.begin();
        manager.persist(user);
        manager.persist(user2);
        transaction.commit();
    }
}
