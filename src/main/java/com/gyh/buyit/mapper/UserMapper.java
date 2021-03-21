package com.gyh.buyit.mapper;

import com.gyh.buyit.entity.ListInfo;
import com.gyh.buyit.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    String isRegistered(String phone);
    String getPasswordByPhone(String phone);
    User findUserByPhone(String phone);
    User findUserByUserId(int userId);
    User login(User user);
    int register(User user);
    List<User> findAllUser();
    List<User> findAllUserByPage(ListInfo listInfo);
    int setUserInfo(User user);
    int setUserPassword(User user);
    int resetUserPassword(User user);
    void setUserAvatar(User user);
    int changePhone(User user);
    int userCount();
    int banUserByUserId(int userId);
    int unblockUserByUserId(int userId);
    int deleteUserByUserId(int userId);
}
