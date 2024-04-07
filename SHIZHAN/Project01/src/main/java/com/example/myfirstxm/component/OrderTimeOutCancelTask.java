package com.example.myfirstxm.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;


/**
 * 订单超时取消并解锁库存的定时器
 * @author blind
 * @create 2023-03-02-23:38
 */
public class OrderTimeOutCancelTask {
    private Logger LOGGER = LoggerFactory.getLogger(OrderTimeOutCancelTask.class);

    @Scheduled(cron = "0 0/10 * ? * ?")
    private void cancelTimeOutOrder(){

        //TODO:此处应调用取消订单的方法，具体去看mall的源代码
        LOGGER.info("取消订单，并根据sku编号释放锁定库存");
    }


}
