package com.gyh.buyit.mapper;

import com.gyh.buyit.entity.Order;
import com.gyh.buyit.entity.Sku;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SkuMapper {
    Sku findSkuBySkuId(int skuId);
    Sku findFirstSkuByGoodId(int goodId);
    List<Sku> findSkuByGoodId(int goodId);
    List<Sku> findAllSku();
    List<String> findColorByGoodId(int goodId);
    List<Sku> findSkuByColorAndGoodId(String color,int goodId);
    int deleteSkuBySkuId(int skuId);
    int offShelfSkuBySkuId(int skuId);
    int updateSku(Sku sku);
    int insertSku(Sku sku);
    int setSkuImg(Sku sku);
    int skuCount();
    int destockBySkuId(Order order);
    int restockBySkuId(Order order);
}
