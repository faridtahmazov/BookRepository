package repository;

import entityFactory.EntityFactory;
import entityFactoryImpl.EntityFactoryImpl;
import model.User;
import model.UserInfo;

import java.util.List;

public interface UserRepository {
    EntityFactory entityFactory = new EntityFactoryImpl();

    Boolean saveUser(User user);

    Boolean updateUser(User user);

    Boolean removeUser(User user);

    User findById(Integer id);

    User findByUsername(String username);

    User findWithUserDetailByUsername(String username);

    List<User> findUsers();

    List<User> findUsers(Integer firstResult, Integer maxResult);

    Integer findUserCount();

    UserInfo findUserInfoByUsername(String username);
}
