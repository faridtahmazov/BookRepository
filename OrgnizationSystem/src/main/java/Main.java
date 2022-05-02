import model.Organization;
import model.Volunteer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence-unit");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        Organization organization = new Organization("Davam GH");
        Organization organization1 = new Organization("GMD IB");
        Organization organization2 = new Organization("Birkonullu");

        Volunteer volunteer = new Volunteer("Farid", "Tahmazov", "IT director");
        Volunteer volunteer1 = new Volunteer("Leman", "Zamanzade", "Cyber security");
        Volunteer volunteer2 = new Volunteer("Maya", "Guliyeva", "Graphic Designer");

        List<Organization> organizations = Arrays.asList(organization, organization1, organization2);
        List<Organization> organizations1 = Arrays.asList(organization, organization2);
        List<Organization> organizations2 = Arrays.asList(organization1);

        volunteer.setOrganizations(organizations);
        volunteer1.setOrganizations(organizations1);
        volunteer2.setOrganizations(organizations2);

        transaction.begin();
        entityManager.persist(organization);
        entityManager.persist(organization1);
        entityManager.persist(organization2);

        entityManager.persist(volunteer);
        entityManager.persist(volunteer1);
        entityManager.persist(volunteer2);
        transaction.commit();
    }
}
