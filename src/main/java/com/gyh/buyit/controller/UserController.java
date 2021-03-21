package com.gyh.buyit.controller;

import com.gyh.buyit.annotation.AdminLoginToken;
import com.gyh.buyit.component.SHAUtil;
import com.gyh.buyit.component.SendSms;
import com.gyh.buyit.entity.ListInfo;
import com.gyh.buyit.entity.User;
import com.gyh.buyit.mapper.UserMapper;
import com.gyh.buyit.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    TokenService tokenService;

    @RequestMapping("/isRegistered/{phone}")//检查手机号是否已注册
    public boolean isRegistered(@PathVariable("phone") String phone){
        String result = userMapper.isRegistered(phone);
        System.out.println(result);
        return result != null;
    }

    @RequestMapping("/checkPassword")//检查密码是否正确
    public boolean checkPassword(@RequestBody User user){
        String realPassword = userMapper.getPasswordByPhone(user.getPhone());
        String loginPassword=new SHAUtil().SHA512(user.getPassword());
        System.out.println(loginPassword);
        return loginPassword.equals(realPassword);
    }

    @RequestMapping("/findUserByPhone/{phone}")
    public User findUserByPhone(@PathVariable("phone") String phone){
        return userMapper.findUserByPhone(phone);
    }

    @RequestMapping("/findUserByUserId/{userId}")
    public User findUserByUserId(@PathVariable("userId") int userId){
        return userMapper.findUserByUserId(userId);
    }

    /**
     * 登录
     * @param user
     * @param session
     * @return
     */
    @RequestMapping("/login")//执行登录操作
    public User login(@RequestBody User user, HttpSession session){
        User result=userMapper.login(user);
        System.out.println(result);
        if(result!=null){
            String token = tokenService.getToken(result);
            System.out.println(token);
            session.setAttribute("token", token);
            result.setToken(token);
            result.setPassword(null);
        }
        return result;
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping("/register")//用户注册
    public int register(@RequestBody User user){
        user.setPassword(new SHAUtil().SHA512(user.getPassword()));//调用SHA512加密
        int result = userMapper.register(user);
        if(result==0){
            return 0;
        }else {
            return user.getUserId();
        }
    }

    @RequestMapping("/findAllUser")
    public List<User> findAllUser(){
        return userMapper.findAllUser();
    }

    @RequestMapping("/findAllUserByPage")
    public List<User> findAllUserByPage(@RequestBody ListInfo listInfo){
        return userMapper.findAllUserByPage(listInfo);
    }

    @RequestMapping("/setUserInfo")
    public int setUserInfo(@RequestBody User user){
        System.out.println(user);
        int result=userMapper.setUserInfo(user);
        System.out.println(result);
        return result;
    }

    @RequestMapping("/setUserPassword")
    public int setUserPassword(@RequestBody User user){
        user.setPassword(new SHAUtil().SHA512(user.getPassword()));
        return userMapper.setUserPassword(user);
    }

    @RequestMapping("/resetUserPassword")
    public int resetUserPassword(@RequestBody User user){
        user.setPassword(new SHAUtil().SHA512(user.getPassword()));
        return userMapper.resetUserPassword(user);
    }

    @RequestMapping("/changePhone")
    public int changePhone(@RequestBody User user){
        System.out.println("phone");
        return userMapper.changePhone(user);
    }

    @RequestMapping("/userCount")
    int userCount(){
        return userMapper.userCount();
    }

    @AdminLoginToken
    @RequestMapping("/banUserByUserId/{userId}")
    int banUserByUserId(@PathVariable("userId") int userId){
        return userMapper.banUserByUserId(userId);
    }

    @AdminLoginToken
    @RequestMapping("/unblockUserByUserId/{userId}")
    int unblockUserByUserId(@PathVariable("userId") int userId){
        return userMapper.unblockUserByUserId(userId);
    }

    @AdminLoginToken
    @RequestMapping("/deleteUserByUserId/{userId}")
    int deleteUserByUserId(@PathVariable("userId") int userId){
        return userMapper.deleteUserByUserId(userId);
    }

    @RequestMapping("/sendCode/{phone}")
    String sendCode(@PathVariable("phone") String phone){
        return new SendSms().send(phone);
    }

}
