package com.whlg.store.service;

import com.whlg.store.entity.User;

public interface IUserService {

        void addUser(User user);
//        void login(String )
        User login(String username,String password);
        User getPwdBack(String username);
        void editPasswordGetPwdBack(int uid,String newPassword,String conNewPassword);
        void editInfo(User user);

        void editAddress(int uid,String address);

        void editPassword(int uid,String oldPassword,String newPassword,String conNewPassword);

        void editAvatar(int uid,String avatar,String username);

}
