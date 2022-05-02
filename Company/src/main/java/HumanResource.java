import model.Department;
import model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class HumanResource {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence-unit");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        Employee employee = new Employee("Farid", "Tahmazov", 4700, new Date());
        Employee employee1 = new Employee("Nargiz", "Aliyeva", 1300, new Date());
        Employee employee2 = new Employee("Maya", "Hasanova", 2430, new Date());

        Employee employee3 = new Employee("Nazrin", "Valiyeva", 2670, new Date());
        Employee employee4 = new Employee("Xanim", "Racabova", 2140, new Date());

        Department infoTech = entityManager.find(Department.class, 1);
        Department marketing = entityManager.find(Department.class, 2);

        employee.setDepartment(infoTech);
        employee1.setDepartment(infoTech);
        employee2.setDepartment(infoTech);
        employee3.setDepartment(marketing);
        employee4.setDepartment(marketing);

        System.out.println(infoTech.getEmployees());

        transaction.begin();
        entityManager.persist(employee);
        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityManager.persist(employee3);
        entityManager.persist(employee4);
        transaction.commit();



    }
}
