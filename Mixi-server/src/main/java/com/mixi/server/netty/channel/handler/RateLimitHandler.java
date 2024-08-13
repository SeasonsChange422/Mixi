package com.mixi.server.netty.channel.handler;

import com.mixi.server.core.worker.SlidWindowLimiter;
import com.mixi.server.netty.channel.MixiNettyChannel;
import com.mixi.server.util.ApplicationContextUtils;
import lombok.NonNull;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author welsir
 * @Date 2024/8/6 19:23
 */
public class RateLimitHandler extends AbstractChannelHandler{

    private SlidWindowLimiter slidWindowLimiter;

    protected RateLimitHandler(@NonNull ChannelHandler handler) {
        super(handler);
        slidWindowLimiter = ApplicationContextUtils.getBean(SlidWindowLimiter.class);
    }

    @Override
    public void send(MixiNettyChannel channel, Object message) {

        super.send(channel, message);
    }
}
