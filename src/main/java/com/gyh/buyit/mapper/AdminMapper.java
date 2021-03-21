package com.gyh.buyit.mapper;

import com.gyh.buyit.entity.ListInfo;
import com.gyh.buyit.entity.Admin;
import com.gyh.buyit.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdminMapper {
    String isExist(String adminName);
    String getPasswordByAdminName(String adminName);
    Admin findAdminByAdminId(int adminId);
    Admin adminLogin(Admin admin);
    int createAdmin(Admin admin);
    List<Admin> findAllAdmin();
    List<Admin> findAllAdminByPage(ListInfo listInfo);
    int setAdminInfo(Admin admin);
    int setAdminPassword(Admin admin);
    int adminCount();
    int disableAdminByAdminId(int adminId);
    int enableAdminByAdminId(int adminId);
    int deleteAdminByAdminId(int adminId);
}