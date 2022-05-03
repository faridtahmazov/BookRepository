package serviceImpl;

import model.UserDetail;
import repository.UserDetailRepository;
import repositoryImpl.UserDetailRepositoryImpl;
import service.UserDetailService;

public class UserDetailServiceImpl implements UserDetailService {
    private UserDetailRepository userDetailRepository = new UserDetailRepositoryImpl();

    @Override
    public Boolean saveUserDetail(UserDetail userDetail) {
        return this.userDetailRepository.saveUserDetail(userDetail);
    }

    @Override
    public Boolean updateUserDetail(UserDetail userDetail) {
        return this.userDetailRepository.updateUserDetail(userDetail);
    }

    @Override
    public Boolean removeUserDetail(UserDetail userDetail) {
        return this.userDetailRepository.removeUserDetail(userDetail);
    }

    @Override
    public UserDetail findById(Integer id) {
        return this.userDetailRepository.findById(id);
    }

    @Override
    public UserDetail findByUsername(String username) {
        return this.userDetailRepository.findByUsername(username);
    }

    @Override
    public UserDetail findWithAddressByUsername(String username) {
        return this.userDetailRepository.findWithAddressByUsername(username);
    }

    @Override
    public UserDetail findWithAdvertisementByUsername(String username) {
        return this.userDetailRepository.findWithAdvertisementByUsername(username);
    }
}
