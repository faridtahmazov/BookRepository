import model.Employee;
import model.EmployeeInfo;

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

        Employee employee = new Employee("Farid", "Tahmazov", "Programmer", 3500, new Date());
        EmployeeInfo employeeInfo = new EmployeeInfo(19, "Azerbaijan", "Baku");
        employee.setEmployeeInfo(employeeInfo);

        Employee employee2 = new Employee("Xanim", "Racabova", "Debater", 1200, new Date());
        EmployeeInfo employeeInfo2 = new EmployeeInfo(18, "Azerbaijan", "Baku");
        employee2.setEmployeeInfo(employeeInfo2);

        System.out.println(employee);
        System.out.println(employeeInfo);

        transaction.begin();
        entityManager.persist(employee);
        entityManager.persist(employeeInfo);
        entityManager.persist(employee2);
        entityManager.persist(employeeInfo2);

        transaction.commit();
    }
}
