package com.example.myfirstxm.dto;

import lombok.Getter;

/**
 * @author blind
 * @create 2023-03-05-17:09
 */
@Getter
public enum QueueEnum {
    /**
     * 消息通知队列
     */
    QUEUE_ORDER_CANCEL("example.order.direct", "example.order.cancel", "example.order.cancel"),
    /**
     * 消息通知ttl队列
     */
    QUEUE_TTL_ORDER_CANCEL("example.order.direct.ttl", "example.order.cancel.ttl", "example.order.cancel.ttl");

    /**
     * 交换名称
     */
    private String exchange;

    /**
     * 队列名称
     */
    private String name;
    /**
     * 路由键
     */
    private String routeKey;

    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }

}
