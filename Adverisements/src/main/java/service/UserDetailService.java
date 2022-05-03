package service;

import model.UserDetail;

public interface UserDetailService {
    Boolean saveUserDetail(UserDetail userDetail);

    Boolean updateUserDetail(UserDetail userDetail);

    Boolean removeUserDetail(UserDetail userDetail);

    UserDetail findById(Integer id);

    UserDetail findByUsername(String username);

    UserDetail findWithAddressByUsername(String username);

    UserDetail findWithAdvertisementByUsername(String username);
}
