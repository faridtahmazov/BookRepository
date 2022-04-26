package jpaFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaFactoryImpl implements JpaFactory {
    EntityManager manager = null;

    @Override
    public EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence-unit");
        this.manager = factory.createEntityManager();

        return manager;
    }

    @Override
    public EntityTransaction getTransaction() {
        EntityTransaction transaction = this.manager.getTransaction();

        return transaction;
    }


}
