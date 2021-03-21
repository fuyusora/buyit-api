package com.gyh.buyit.service;

import com.gyh.buyit.entity.Order;
import com.gyh.buyit.entity.Sku;
import com.gyh.buyit.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private SkuService skuService;

    public List<Order> findOrderByUserId(int userId) {
//        List<Order> orders= orderMapper.findOrderByUserId(userId);
//        for(Order order : orders){
//            Sku sku=skuService.findSkuBySkuId(order.getSkuId());
//            order.setMainImg(sku.getMainImg());
//        }
//        return orders;
        return orderMapper.findOrderByUserId(userId);
    }
}
