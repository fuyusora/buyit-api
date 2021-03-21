package com.gyh.buyit;

import com.gyh.buyit.component.SendSms;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BuyitApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void sendsms(){
        new SendSms().send("18596692201");
    }

    @Test
    void create(){
        String code=String.valueOf((int)((Math.random()*9+1)*100000));
        System.out.println(code);
    }
}
