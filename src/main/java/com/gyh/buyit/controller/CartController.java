package com.gyh.buyit.controller;

import com.gyh.buyit.annotation.UserLoginToken;
import com.gyh.buyit.entity.Cart;
import com.gyh.buyit.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartMapper cartMapper;

    @UserLoginToken
    @RequestMapping("/findCartByUserId/{userId}")
    public List<Cart> findCartByUserId(@PathVariable("userId") int userId) {
        return cartMapper.findCartByUserId(userId);
    }

    @UserLoginToken
    @RequestMapping("/addCart")//商品加入购物车
    public int addCart(@RequestBody Cart cart) {
        int result = cartMapper.addCart(cart);
        System.out.println(cart);
        System.out.println(result);
        return result;
    }


    @RequestMapping("/findAllCart")
    public List<Cart> findAllCart() {
        return cartMapper.findAllCart();
    }


    @UserLoginToken
    @RequestMapping("/deleteCartByCartId/{cartId}")
    public int deleteCartByCartId(@PathVariable("cartId") int  cartId) {
        return cartMapper.deleteCartByCartId(cartId);
    }

    @UserLoginToken
    @RequestMapping("/deleteCartByUserId/{userId}")//清空指定用户的购物车
    public int deleteCartByUserId(@PathVariable("userId") int  userId) {
        return cartMapper.deleteCartByUserId(userId);
    }

    @UserLoginToken
    @RequestMapping("/quantityChange/{cartId}/{quantity}")
    int quantityChange(@PathVariable("cartId") int cartId,@PathVariable("quantity") int quantity){
        return cartMapper.quantityChange(cartId,quantity);
    }

    @UserLoginToken
    @RequestMapping("/addQuantity/{cartId}/{quantity}")//添加指定数量
    int addQuantity(@PathVariable("cartId") int cartId,@PathVariable("quantity") int quantity){
        return cartMapper.addQuantity(cartId,quantity);
    }

    @RequestMapping("/isExistSkuInCart")//判断购物车中是否已存在此SKU
    Integer isExistSkuInCart(@RequestBody Cart cart){
        return cartMapper.isExistSkuInCart(cart);
    }

    @RequestMapping("/countCartByUserId/{userId}")
    int countCartByUserId(@PathVariable("userId") int userId){
        return cartMapper.countCartByUserId(userId);
    }

}
