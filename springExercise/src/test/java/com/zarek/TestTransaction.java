package com.zarek;

import com.zarek.transactionspring.service.BuyGoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhao
 * @date 2021/3/4 10:11
 */
public class TestTransaction {

    @Test
    public void testBuy(){

        String configLocation = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
        BuyGoodsService proxy = (BuyGoodsService) context.getBean("buyService");
        proxy.buy(1001,2);

    }

}
