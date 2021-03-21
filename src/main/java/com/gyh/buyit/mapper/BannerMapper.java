package com.gyh.buyit.mapper;

import com.gyh.buyit.entity.Admin;
import com.gyh.buyit.entity.Banner;
import com.gyh.buyit.entity.ListInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BannerMapper {
    List<Banner> findAllBanner();
    List<Banner> findAllBannerByPage(ListInfo listInfo);
    int addBanner(Banner banner);
    int deleteBannerByBannerId(int bannerId);
    int updateBanner(Banner banner);
    int bannerCount();
    int setBannerPath(Banner banner);
}
