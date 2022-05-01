import model.Personel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        Personel personel = new Personel(null, "Farid", "Tahmazov");
        Personel personel2 = new Personel(null, "Xanim", "Racabova");

        personel.addPhoneNumber("Business", "055-977-32-37");
        personel.addPhoneNumber("Private", "077-313-15-23");
        personel2.addPhoneNumber("Business", "077-157-99-23");
        personel2.addPhoneNumber("Private", "055-629-57-45");

        transaction.begin();
        manager.persist(personel);
        manager.persist(personel2);
        transaction.commit();
    }
}
