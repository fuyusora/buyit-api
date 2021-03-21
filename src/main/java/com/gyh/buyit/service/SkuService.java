package com.gyh.buyit.service;

import com.gyh.buyit.entity.Order;
import com.gyh.buyit.entity.Sku;
import com.gyh.buyit.mapper.SkuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkuService {

    @Autowired
    private SkuMapper skuMapper;

    Sku findSkuBySkuId(int skuId){
        return skuMapper.findSkuBySkuId(skuId);
    }

    public void setSkuImg(int skuId,String imgPath){
        Sku sku=new Sku();
        sku.setSkuImg(imgPath);
        sku.setSkuId(skuId);
        System.out.println(sku);
        System.out.println(skuMapper.setSkuImg(sku));
//        skuMapper.setSkuImg(sku);
    }

    public int destockBySkuId(Order order){
        return skuMapper.destockBySkuId(order);
    }

    public int restockBySkuId(Order order){
        return skuMapper.restockBySkuId(order);
    }


}
