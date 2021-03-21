package com.gyh.buyit.mapper;

import com.gyh.buyit.entity.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
@Mapper
public interface CartMapper {
    List<Cart> findCartByUserId(int userId);
    int addCart(Cart cart);
    List<Cart> findAllCart();
    int deleteCartByCartId(int cartId);
    int deleteCartByUserId(int userId);
    int quantityChange(int cartId, int quantity);
    int addQuantity(int cartId, int quantity);
    Integer isExistSkuInCart(Cart cart);
    int countCartByUserId(int userId);
}
