package serviceImpl;

import model.User;
import model.UserInfo;
import repository.UserRepository;
import repositoryImpl.UserRepositoryImpl;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository = new UserRepositoryImpl();
    @Override
    public Boolean saveUser(User user) {
        return this.userRepository.saveUser(user);
    }

    @Override
    public Boolean updateUser(User user) {
        return this.userRepository.saveUser(user);
    }

    @Override
    public Boolean removeUser(User user) {
        return this.userRepository.removeUser(user);
    }

    @Override
    public User findById(Integer id) {
        return this.userRepository.findById(id);
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public User findWithUserDetailByUsername(String username) {
        return this.userRepository.findWithUserDetailByUsername(username);
    }

    @Override
    public List<User> findUsers() {
        return this.userRepository.findUsers();
    }

    @Override
    public List<User> findUsers(Integer firstResult, Integer maxResult) {
        return this.userRepository.findUsers(firstResult, maxResult);
    }

    @Override
    public Integer findUserCount() {
        return this.userRepository.findUserCount();
    }

    @Override
    public UserInfo findUserInfoByUsername(String username) {
        return this.userRepository.findUserInfoByUsername(username);
    }
}
