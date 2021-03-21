package com.gyh.buyit.mapper;

import com.gyh.buyit.entity.Good;
import com.gyh.buyit.entity.ListInfo;
import com.gyh.buyit.entity.Sku;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GoodMapper {
    Good findGoodByGoodId(int goodId);
    List<Good> findGoodByCategoryKey(String categoryKey);
    List<Good> findGoodByKeyword(String keyword);
    List<Good> findAllGood();
    List<Good> findAllGoodByPage(ListInfo listInfo);
    int goodCount();
    int updateGood(Good good);
    int insertGood(Good good);
    void setDetailImg(Good good);
    int deleteGoodByGoodId(int goodId);
    int setDefaultSku(Sku sku);
}
