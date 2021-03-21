package com.gyh.buyit.service;

import com.gyh.buyit.entity.User;
import com.gyh.buyit.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public void setUserAvatar(int userId,String imgPath){
        User user=new User();
        user.setUserId(userId);
        user.setAvatar(imgPath);
        userMapper.setUserAvatar(user);
    }

    public User findUserByUserId(int userId){
        return userMapper.findUserByUserId(userId);
    }
}
