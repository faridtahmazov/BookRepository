package repositoryImpl;

import model.Education;
import repository.EducationRepository;

import javax.persistence.*;
import java.util.List;

public class EducationRepositoryImpl implements EducationRepository {
    EntityManager entityManager = entityFactory.getEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    @Override
    public Boolean saveEducation(Education education) {
        try{
            this.transaction.begin();
            this.entityManager.persist(education);
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
    public Boolean updateEducation(Education education) {
        try{
            this.transaction.begin();
            this.entityManager.merge(education);
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
    public Boolean removeEducation(Education education) {
        try{
            if(this.entityManager.contains(education)){
                this.entityManager.remove(education);
            }else{
                Education deletedEducation = findById(education.getEducationId());
                this.entityManager.remove(deletedEducation);
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
    public Education findById(Integer id) {
        Education education = null;
        try {
            TypedQuery<Education> typedQuery = this.entityManager.createNamedQuery("Education.findById", Education.class);
            typedQuery.setParameter("educationId", id);
            education = typedQuery.getSingleResult();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return education;
    }

    @Override
    public List<Education> findEducation() {
        List<Education> educations = null;
        try {
            TypedQuery<Education> typedQuery = this.entityManager.createNamedQuery("Education.findEducations", Education.class);
            educations = typedQuery.getResultList();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return educations;
    }

    @Override
    public Education findWithAdvertisementById(Integer id) {
        Education education = null;
        try {
            TypedQuery<Education> typedQuery = this.entityManager.createNamedQuery("Education.findWithAdvertisementById", Education.class);
            typedQuery.setParameter("educationId", id);
            education = typedQuery.getSingleResult();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return education;
    }
}
