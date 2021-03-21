package com.gyh.buyit.service;

import com.gyh.buyit.entity.Banner;
import com.gyh.buyit.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerService {

    @Autowired
    BannerMapper bannerMapper;

    public void setBannerPath(int bannerId,String imgPath){
        Banner banner=new Banner();
        banner.setBannerId(bannerId);
        banner.setBannerPath(imgPath);
        bannerMapper.setBannerPath(banner);
    }
}
