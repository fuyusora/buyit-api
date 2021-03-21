package com.gyh.buyit.controller;


import com.gyh.buyit.annotation.AdminLoginToken;
import com.gyh.buyit.entity.Good;
import com.gyh.buyit.entity.ListInfo;
import com.gyh.buyit.entity.Sku;
import com.gyh.buyit.mapper.GoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/good")
public class GoodController {

    @Autowired
    private GoodMapper goodMapper;

    @RequestMapping("/findGoodByGoodId/{goodId}")
    public Good findGoodByGoodId(@PathVariable("goodId") int goodId){
        return goodMapper.findGoodByGoodId(goodId);
    }

    @RequestMapping("/findGoodByCategoryKey/{categoryKey}")
    public List<Good> findGoodByCategoryKey(@PathVariable("categoryKey") String categoryKey){
        return goodMapper.findGoodByCategoryKey(categoryKey);
    }

    @RequestMapping("/findGoodByKeyword/{keyword}")
    public List<Good> findGoodByKeyword(@PathVariable("keyword") String keyword){
        return goodMapper.findGoodByKeyword(keyword);
    }

    @RequestMapping("/findAllGood")
    public List<Good> findAllGood(){
        return goodMapper.findAllGood();
    }

    @RequestMapping("/findAllGoodByPage")
    public List<Good> findAllGoodByPage(@RequestBody ListInfo listInfo){
        return goodMapper.findAllGoodByPage(listInfo);
    }

    @RequestMapping("/goodCount")
    int goodCount(){
        return goodMapper.goodCount();
    }

    @AdminLoginToken
    @RequestMapping("/updateGood")
    int updateGood(@RequestBody Good good){
        return goodMapper.updateGood(good);
    }

    @AdminLoginToken
    @RequestMapping("/insertGood")
    int insertGood(@RequestBody Good good){
        int result= goodMapper.insertGood(good);
        if(result==0){
            return 0;
        }else {
            return good.getGoodId();
        }
    }

    @AdminLoginToken
    @RequestMapping("/deleteGoodByGoodId/{goodId}")
    int deleteGoodByGoodId(@PathVariable("goodId") int goodId){
        return goodMapper.deleteGoodByGoodId(goodId);
    }

    @AdminLoginToken
    @RequestMapping("/setDefaultSku")
    int setDefaultSku(@RequestBody Sku sku){
        return goodMapper.setDefaultSku(sku);
    }

}
