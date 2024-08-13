package com.mixi.server.core.worker;

import com.mixi.server.netty.channel.MixiNettyChannel;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description
 * @Author welsir
 * @Date 2024/8/6 22:26
 */
@Data
@Component
public class SlidWindowLimiter {

    private final int capacity=5;
    private final long windowSizeMillis=1000;

    private ConcurrentHashMap<MixiNettyChannel,worker> channelLimiter = new ConcurrentHashMap<>();

    public class worker{
        private Queue<Long> timestamps = new LinkedList<>();
        public synchronized boolean tryAcquire(){
            long currentTime = System.currentTimeMillis();
            while (!timestamps.isEmpty() && currentTime - timestamps.peek() > windowSizeMillis) {
                timestamps.poll();
            }
            if (timestamps.size() < capacity) {
                timestamps.offer(currentTime);
                return true;
            } else {
                return false;
            }
        }
    }
}
