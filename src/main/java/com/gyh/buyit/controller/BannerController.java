package com.gyh.buyit.controller;

import com.gyh.buyit.annotation.AdminLoginToken;
import com.gyh.buyit.entity.Banner;
import com.gyh.buyit.entity.ListInfo;
import com.gyh.buyit.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    BannerMapper bannerMapper;

    @RequestMapping("/findAllBanner")
    public List<Banner> findAllBanner(){
        return bannerMapper.findAllBanner();
    }

    @RequestMapping("/findAllBannerByPage")
    List<Banner> findAllBannerByPage(@RequestBody ListInfo listInfo){
        return bannerMapper.findAllBannerByPage(listInfo);
    }

    @AdminLoginToken
    @RequestMapping("/addBanner")
    int addBanner(@RequestBody Banner banner){
//        return bannerMapper.addBanner(banner);
        int result = bannerMapper.addBanner(banner);
        System.out.println(banner.getBannerId());
        if(result==0){
            return 0;
        }else {
            return banner.getBannerId();
        }
    }

    @AdminLoginToken
    @RequestMapping("/deleteBannerByBannerId/{bannerId}")
    int deleteBannerByBannerId(@PathVariable("bannerId") int bannerId){
        return bannerMapper.deleteBannerByBannerId(bannerId);
    }

    @AdminLoginToken
    @RequestMapping("/updateBanner")
    int updateBanner(@RequestBody Banner banner){
        return bannerMapper.updateBanner(banner);
    }

    @RequestMapping("/bannerCount")
    int bannerCount(){
        return bannerMapper.bannerCount();
    }

}
