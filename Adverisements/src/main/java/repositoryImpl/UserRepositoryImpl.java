package repositoryImpl;

import model.User;
import model.UserDetail;
import model.UserInfo;
import repository.UserDetailRepository;
import repository.UserRepository;

import javax.persistence.*;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    EntityManager entityManager = entityFactory.getEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    @Override
    public Boolean saveUser(User user) {
        try{
            this.transaction.begin();
            this.entityManager.persist(user);
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
    public Boolean updateUser(User user) {
        try{
            this.transaction.begin();
            this.entityManager.merge(user);
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
    public Boolean removeUser(User user) {
        try{
            if(this.entityManager.contains(user)){
                this.entityManager.remove(user);
            }else{
                User deletedUser = findById(user.getUserId());
                this.entityManager.remove(deletedUser);
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
    public User findById(Integer id) {
        User user = null;
        try {
            TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findById", User.class);
            typedQuery.setParameter("userId", id);
            user = typedQuery.getSingleResult();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return user;
    }

    @Override
    public User findByUsername(String username) {
        User user = null;
        try {
            TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findByUsername", User.class);
            typedQuery.setParameter("username", username);
            user = typedQuery.getSingleResult();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return user;
    }

    @Override
    public User findWithUserDetailByUsername(String username) {
        User user = null;
        try {
            TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findWithUserDetailByUsername", User.class);
            typedQuery.setParameter("username", username);
            user = typedQuery.getSingleResult();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return user;
    }

    @Override
    public List<User> findUsers() {
        List<User> users = null;
        try {
            TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findUsers", User.class);
            users = typedQuery.getResultList();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return users;
    }

    @Override
    public List<User> findUsers(Integer firstResult, Integer maxResult) {
        List<User> users = null;
        try {
            TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findUsers", User.class);
            typedQuery.setFirstResult(firstResult);
            typedQuery.setMaxResults(maxResult);
            users = typedQuery.getResultList();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return users;
    }

    @Override
    public Integer findUserCount() {
        Integer userCount = null;
        try {
            TypedQuery<Integer> typedQuery = this.entityManager.createNamedQuery("User.count", Integer.class);
            userCount = typedQuery.getSingleResult();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return userCount;
    }

    @Override
    public UserInfo findUserInfoByUsername(String username) {
        UserInfo userInfo = null;
        try {
            TypedQuery<UserInfo> typedQuery = this.entityManager.createNamedQuery("User.findWithUserDetailByUsername", UserInfo.class);
            typedQuery.setParameter("username", username);
            userInfo = typedQuery.getSingleResult();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return userInfo;
    }
}
