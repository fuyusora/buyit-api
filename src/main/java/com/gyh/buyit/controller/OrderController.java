package com.gyh.buyit.controller;

import com.gyh.buyit.annotation.UserLoginToken;
import com.gyh.buyit.entity.ListInfo;
import com.gyh.buyit.entity.Order;
import com.gyh.buyit.mapper.OrderMapper;
import com.gyh.buyit.service.OrderService;
import com.gyh.buyit.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private SkuService skuService;

    @RequestMapping("/findOrderByUserId/{userId}")
    public List<Order> findOrderByUserId(@PathVariable("userId") int userId) {
        return orderMapper.findOrderByUserId(userId);
    }

    @UserLoginToken
    @RequestMapping("/buy")
    public int buy(@RequestBody Order order) {
        String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        order.setOrderTime(time);
        int result = orderMapper.buy(order);
        int result2=skuService.destockBySkuId(order);
        System.out.println(order);
        System.out.println(result);
        System.out.println(result2);
        return result;
    }

    @UserLoginToken
    @RequestMapping("/orderBuy")//提交购物车订单
    public List<Integer> orderBuy(@RequestBody List<Order> orders) {
        List<Integer> orderIds= new ArrayList<>();
        for(Order order : orders){
            String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            order.setOrderTime(time);
            orderMapper.buy(order);
            skuService.destockBySkuId(order);
            orderIds.add(order.getOrderId());
            System.out.println(order);
        }
        return orderIds;
    }

    @RequestMapping("/findAllOrder")
    public List<Order> findAllOrder() {
        return orderMapper.findAllOrder();
    }

    @RequestMapping("/findAllOrderByPage")
    public List<Order> findAllOrderByPage(@RequestBody ListInfo listInfo) {
        return orderMapper.findAllOrderByPage(listInfo);
    }

    @RequestMapping("/deleteOrderByOrderId/{orderId}")
    int deleteOrderByOrderId(@PathVariable("orderId") int orderId){
        return orderMapper.deleteOrderByOrderId(orderId);
    }

    @RequestMapping("/orderCount")
    int orderCount(){
        return orderMapper.orderCount();
    }

    @RequestMapping("/setOrderStatus/{orderId}/{status}")
    int setOrderStatus(@PathVariable("orderId") int orderId,@PathVariable("status") String status){
        return orderMapper.setOrderStatus(orderId,status);
    }

    @RequestMapping("/orderCancel")
    int orderCancel(@RequestBody Order order){
        skuService.restockBySkuId(order);
        return orderMapper.setOrderStatus(order.getOrderId(),"已取消");
    }

    @UserLoginToken
    @RequestMapping("/orderPay")
    int orderPay(@RequestBody List<Integer> orderIds){
        int result=0;
        for(Integer orderId:orderIds){
            result+=orderMapper.setOrderStatus(orderId,"待发货");
        }
        return result;
    }

    @UserLoginToken
    @RequestMapping("/pay/{orderId}")
    int pay(@PathVariable("orderId") int orderId){
        return orderMapper.setOrderStatus(orderId,"待发货");
    }

    @RequestMapping("/countOrderByWeek")
    List<Integer> countOrderByWeek(){
        return orderMapper.countOrderByWeek();
    }

    @RequestMapping("/findAllWeek")
    List<String> findAllWeek(){
        return orderMapper.findAllWeek();
    }

}
