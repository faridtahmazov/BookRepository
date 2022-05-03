package repositoryImpl;

import model.Education;
import model.User;
import model.UserDetail;
import repository.UserDetailRepository;

import javax.persistence.*;

public class UserDetailRepositoryImpl implements UserDetailRepository {
    EntityManager entityManager = entityFactory.getEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    @Override
    public Boolean saveUserDetail(UserDetail userDetail) {
        try{
            this.transaction.begin();
            this.entityManager.persist(userDetail);
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
    public Boolean updateUserDetail(UserDetail userDetail) {
        try{
            this.transaction.begin();
            this.entityManager.merge(userDetail);
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
    public Boolean removeUserDetail(UserDetail userDetail) {
        try{
            if(this.entityManager.contains(userDetail)){
                this.entityManager.remove(userDetail);
            }else{
                UserDetail deletedUserDetail = findById(userDetail.getUserDetailId());
                this.entityManager.remove(deletedUserDetail);
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
    public UserDetail findById(Integer id) {
        UserDetail userDetail = null;
        try {
            TypedQuery<UserDetail> typedQuery = this.entityManager.createNamedQuery("UserDetail.findById", UserDetail.class);
            typedQuery.setParameter("userId", id);
            userDetail = typedQuery.getSingleResult();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return userDetail;
    }

    @Override
    public UserDetail findByUsername(String username) {
        UserDetail userDetail = null;
        try {
            TypedQuery<UserDetail> typedQuery = this.entityManager.createNamedQuery("UserDetail.findByUsername", UserDetail.class);
            typedQuery.setParameter("username", username);
            userDetail = typedQuery.getSingleResult();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return userDetail;
    }

    @Override
    public UserDetail findWithAddressByUsername(String username) {
        UserDetail userDetail = null;
        try {
            TypedQuery<UserDetail> typedQuery = this.entityManager.createNamedQuery("UserDetail.findWithAddressByUsername", UserDetail.class);
            typedQuery.setParameter("username", username);
            userDetail = typedQuery.getSingleResult();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return userDetail;
    }

    @Override
    public UserDetail findWithAdvertisementByUsername(String username) {
        UserDetail userDetail = null;
        try {
            TypedQuery<UserDetail> typedQuery = this.entityManager.createNamedQuery("UserDetail.findWithAdvertisementByUsername", UserDetail.class);
            typedQuery.setParameter("username", username);
            userDetail = typedQuery.getSingleResult();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return userDetail;
    }
}
