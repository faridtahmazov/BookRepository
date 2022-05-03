package repositoryImpl;

import model.Advertisements;
import repository.AdvertisementsRepository;

import javax.persistence.*;
import java.util.List;

public class AdvertisementsRepositoryImpl implements AdvertisementsRepository {

    private EntityManager entityManager = entityFactory.getEntityManager();
    private EntityTransaction transaction = this.entityManager.getTransaction();

    @Override
    public Boolean saveAdvertisement(final Advertisements advertisements) {
        try{
            this.transaction.begin();
            this.entityManager.persist(advertisements);
            this.transaction.commit();
        }catch (RuntimeException e){
            System.out.println("Error: " + e);
            try{
                this.transaction.rollback();
            }catch (RollbackException e2){
                System.out.println("Error: " + e2);
            }
            return false;
        }

        return true;
    }

    @Override
    public Boolean updateAdvertisement(final Advertisements advertisements) {
        try{
            this.transaction.begin();
            this.entityManager.merge(advertisements);
            this.entityManager.flush();
            this.transaction.commit();
        }catch (RuntimeException e){
            System.out.println("Error: " + e);
            try{
                this.transaction.rollback();
            }catch (RollbackException e2){
                System.out.println("Error: " + e2);
            }
            return false;
        }
        return true;
    }

    @Override
    public Boolean removeAdvertisement(final Advertisements advertisements) {
        try{
            if(this.entityManager.contains(advertisements)){
                this.entityManager.remove(advertisements);
            }else{
                Advertisements deletedAdvertisements = findById(advertisements.getAdvertisementsId());
                this.entityManager.remove(deletedAdvertisements);
            }
        }catch (RuntimeException e){
            System.out.println("Error: " + e);
            try{
                this.transaction.rollback();
            }catch (RollbackException e2){
                System.out.println("Error: " + e2);
            }
            return false;
        }

        return true;
    }

    @Override
    public Advertisements findById(final Integer id) {
        Advertisements advertisements = null;
        try {
            TypedQuery<Advertisements> typedQuery = this.entityManager.createNamedQuery("Advertisements.findById", Advertisements.class);
            typedQuery.setParameter("advertisementsId", id);
            advertisements = typedQuery.getSingleResult();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return advertisements;
    }

    @Override
    public List<Advertisements> findByUsername(String username) {
        List<Advertisements> advertisements = null;
        try {
            TypedQuery<Advertisements> typedQuery = this.entityManager.createNamedQuery("Advertisements.findByUsername", Advertisements.class);
            typedQuery.setParameter("username", username);

            advertisements = typedQuery.getResultList();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return advertisements;
    }

    @Override
    public List<Advertisements> findAdvertisements() {
        List<Advertisements> advertisements = null;
        try {
            TypedQuery<Advertisements> typedQuery = this.entityManager.createNamedQuery("Advertisements.findAdvertisement", Advertisements.class);

            advertisements = typedQuery.getResultList();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return advertisements;
    }

    @Override
    public List<Advertisements> findAdvertisementEntities(Integer firstResult, Integer maxResult) {
        List<Advertisements> advertisements = null;
        try {
            TypedQuery<Advertisements> typedQuery = this.entityManager.createNamedQuery("Advertisements.findAdvertisement", Advertisements.class);
            typedQuery.setFirstResult(firstResult);
            typedQuery.setMaxResults(maxResult);

            advertisements = typedQuery.getResultList();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return advertisements;
    }
}
