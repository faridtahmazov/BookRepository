package jpaFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public interface JpaFactory {
    EntityTransaction getTransaction();
    EntityManager getEntityManager();
}
