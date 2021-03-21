package com.gyh.buyit.controller;

import com.gyh.buyit.annotation.AdminLoginToken;
import com.gyh.buyit.entity.Sku;
import com.gyh.buyit.mapper.SkuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sku")
public class SkuController {

    @Autowired
    private SkuMapper skuMapper;

    @RequestMapping("/findSkuBySkuId/{skuId}")
    public Sku findSkuBySkuId(@PathVariable("skuId") int skuId){
        return skuMapper.findSkuBySkuId(skuId);
    }

    @RequestMapping("/findFirstSkuByGoodId/{goodId}")
    public Sku findFirstSkuByGoodId(@PathVariable("goodId") int goodId){
        return skuMapper.findFirstSkuByGoodId(goodId);
    }

    @RequestMapping("/findSkuByGoodId/{goodId}")
    public List<Sku> findSkuByGoodId(@PathVariable("goodId") int goodId){
        return skuMapper.findSkuByGoodId(goodId);
    }

    @RequestMapping("/findAllSku")
    public List<Sku> findAllSku(){
        return skuMapper.findAllSku();
    }


    @RequestMapping("/findColorByGoodId/{goodId}")
    public List<String> findColorByGoodId(@PathVariable("goodId") int goodId){
        return skuMapper.findColorByGoodId(goodId);
    }

    @RequestMapping("/findSkuByColorAndGoodId/{color}/{goodId}")
    List<Sku> findSkuByColorAndGoodId(@PathVariable("color") String color,@PathVariable("goodId") int goodId){
        return skuMapper.findSkuByColorAndGoodId(color,goodId);
    }

    @AdminLoginToken
    @RequestMapping("/deleteSkuBySkuId/{skuId}")
    int deleteSkuBySkuId(@PathVariable("skuId") int skuId){
        return skuMapper.deleteSkuBySkuId(skuId);
    }

    @AdminLoginToken
    @RequestMapping("/offShelfSkuBySkuId/{skuId}")
    int offShelfSkuBySkuId(@PathVariable("skuId") int skuId){
        return skuMapper.offShelfSkuBySkuId(skuId);
    }

    @AdminLoginToken
    @RequestMapping("/updateSku")
    int updateSku(@RequestBody Sku sku){
        return skuMapper.updateSku(sku);
    }

    @AdminLoginToken
    @RequestMapping("/insertSku")
    int insertSku(@RequestBody Sku sku){
        int result= skuMapper.insertSku(sku);
        if(result==0){
            return 0;
        }else {
            return sku.getSkuId();
        }
    }

    @RequestMapping("/skuCount")
    int skuCount(){
        return skuMapper.skuCount();
    }


}
