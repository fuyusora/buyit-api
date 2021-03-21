package com.gyh.buyit.controller;

import com.gyh.buyit.annotation.AdminLoginToken;
import com.gyh.buyit.component.SHAUtil;
import com.gyh.buyit.entity.Admin;
import com.gyh.buyit.entity.ListInfo;
import com.gyh.buyit.mapper.AdminMapper;
import com.gyh.buyit.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    TokenService tokenService;

    @RequestMapping("/isExist/{adminName}")
    public boolean isExist(@PathVariable("adminName") String adminName){
        String result = adminMapper.isExist(adminName);
        System.out.println(result);
        return result != null;
    }
    
    @RequestMapping("/adminCheckPassword")
    public boolean checkPassword(@RequestBody Admin admin){
        String realPassword = adminMapper.getPasswordByAdminName(admin.getAdminName());
        String loginPassword=new SHAUtil().SHA512(admin.getPassword());
        return loginPassword.equals(realPassword);
    }

    @RequestMapping("/findAdminByAdminId/{adminId}")
    public Admin findAdminByAdminId(@PathVariable("adminId") int adminId){
        return adminMapper.findAdminByAdminId(adminId);
    }


    /**
     * 登录
     * @param admin
     * @param session
     * @return
     */
    @RequestMapping("/adminLogin")
    public Admin adminLogin(@RequestBody Admin admin, HttpSession session){
        Admin result=adminMapper.adminLogin(admin);
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
     * @param admin
     * @return
     */
    @AdminLoginToken
    @RequestMapping("/createAdmin")
    public int createAdmin(@RequestBody Admin admin){
        admin.setPassword(new SHAUtil().SHA512(admin.getPassword()));
        int result = adminMapper.createAdmin(admin);
        System.out.println(result);
        return result;
    }

    @RequestMapping("/findAllAdmin")
    public List<Admin> findAllAdmin(){
        return adminMapper.findAllAdmin();
    }

    @RequestMapping("/findAllAdminByPage")
    public List<Admin> findAllAdminByPage(@RequestBody ListInfo listInfo){
        return adminMapper.findAllAdminByPage(listInfo);
    }

    @AdminLoginToken
    @RequestMapping("/setAdminInfo")
    public int setAdminInfo(@RequestBody Admin admin){
        System.out.println(admin);
        int result=adminMapper.setAdminInfo(admin);
        System.out.println(result);
        return result;
    }

    @AdminLoginToken
    @RequestMapping("/setAdminPassword")
    public int setAdminPassword(@RequestBody Admin admin){
        admin.setPassword(new SHAUtil().SHA512(admin.getPassword()));
        return adminMapper.setAdminPassword(admin);
    }

    @RequestMapping("/adminCount")
    int adminCount(){
        return adminMapper.adminCount();
    }

    @AdminLoginToken
    @RequestMapping("/disableAdminByAdminId/{adminId}")
    int disableAdminByAdminId(@PathVariable("adminId") int adminId){
        return adminMapper.disableAdminByAdminId(adminId);
    }

    @AdminLoginToken
    @RequestMapping("/enableAdminByAdminId/{adminId}")
    int enableAdminByAdminId(@PathVariable("adminId") int adminId){
        return adminMapper.enableAdminByAdminId(adminId);
    }

    @AdminLoginToken
    @RequestMapping("/deleteAdminByAdminId/{adminId}")
    int deleteAdminByAdminId(@PathVariable("adminId") int adminId){
        return adminMapper.deleteAdminByAdminId(adminId);
    }

}
