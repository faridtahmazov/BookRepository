package entityFactoryImpl;

import entityFactory.EntityFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityFactoryImpl implements EntityFactory {
    @Override
    public EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence-unit");
        return factory.createEntityManager();
    }
}
