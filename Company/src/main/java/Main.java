import model.Department;
import model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence-unit");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        Department informationTech = new Department("Information Technology", 900, 5700);
        Department marketing = new Department("Marketing", 700, 4500);


        transaction.begin();
        entityManager.persist(informationTech);
        entityManager.persist(marketing);
        transaction.commit();
    }

}
