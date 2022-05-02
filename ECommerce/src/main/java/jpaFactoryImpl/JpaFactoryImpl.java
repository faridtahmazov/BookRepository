package jpaFactoryImpl;

import jpaFactory.JpaFactory;

import javax.persistence.*;

public class JpaFactoryImpl implements JpaFactory {
    private EntityManager entityManager = null;
    @Override
    public EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence-unit");
        this.entityManager = factory.createEntityManager();

        return entityManager;
    }

    @Override
    public EntityTransaction getTransaction() {
        EntityTransaction transaction = getEntityManager().getTransaction();
        return transaction;
    }
}
