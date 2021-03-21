package com.gyh.buyit.service;

import com.gyh.buyit.entity.Good;
import com.gyh.buyit.mapper.GoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodService {

    @Autowired
    GoodMapper goodMapper;

    Good findGoodByGoodId(int goodId){
        return goodMapper.findGoodByGoodId(goodId);
    }

    public void setDetailImg(int goodId,String imgPath){
        Good good=new Good();
        good.setDetailImg(imgPath);
        good.setGoodId(goodId);
        goodMapper.setDetailImg(good);
    }

}
