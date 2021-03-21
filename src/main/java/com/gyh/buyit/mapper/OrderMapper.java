package com.gyh.buyit.mapper;

import com.gyh.buyit.entity.ListInfo;
import com.gyh.buyit.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface OrderMapper {
    List<Order> findOrderByUserId(int userId);

    List<Order> findAllOrder();

    List<Order> findAllOrderByPage(ListInfo listInfo);

    int buy(Order order);

    int orderBuy(List<Order> orders);

    int deleteOrderByOrderId(int orderId);

    int orderCount();

    int setOrderStatus(int orderId, String status);

    List<Integer> countOrderByWeek();

    List<String> findAllWeek();
}
