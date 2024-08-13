package com.mixi.server.config;

import lombok.Data;

/**
 * @Description
 * @Author welsir
 * @Date 2024/8/6 19:47
 */
@Data
public class RateLimitProperties {

    private int rate;
    private int capacity;
    private String timeUnit;

}
