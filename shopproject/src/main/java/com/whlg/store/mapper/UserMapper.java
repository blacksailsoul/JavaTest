package com.whlg.store.mapper;

import com.whlg.store.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Date;


@Repository
public interface UserMapper {

    User findByUsername(String username);

    User findByEmail(String email);

    User findByUid(int Uid);

    int UpdatePassword(User user);



    int insertUser(User user);


    int updateInfo(User user);

    int updateAddress(User user);

    int updatePasswordInt(int uid, String oldPassword, String newPassword, String conNewPassword,
                          String changeUser, Date changeTime);
    int updateAvatar(int uid,String avatar,String changeUser,Date changeTime);
}
