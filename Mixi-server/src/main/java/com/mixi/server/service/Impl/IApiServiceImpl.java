package com.mixi.server.service.Impl;

import com.mixi.common.exception.ServeException;
import com.mixi.server.common.ResultCode;
import com.mixi.server.netty.channel.MixiNettyChannel;
import com.mixi.server.netty.channel.RoomChannelManager;
import com.mixi.server.netty.protocol.AccessResponse;
import com.mixi.server.pojo.DTO.RemoveChannelReqDTO;
import com.mixi.server.service.ApiService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @Description
 * @Author welsir
 * @Date 2024/7/14 15:17
 */
@Service
public class IApiServiceImpl implements ApiService {


    @Override
    public void removeChannelById(RemoveChannelReqDTO reqDTO) {
        MixiNettyChannel nettyChannel = MixiNettyChannel.getChannelByUid(reqDTO.getUid());
        if(nettyChannel==null){
            throw new ServeException(ResultCode.INVALID_UID.getCode(),ResultCode.INVALID_UID.getMsg());
        }
        MixiNettyChannel channel = MixiNettyChannel.getChannelByUid(reqDTO.getUid());
        channel.close();
        MixiNettyChannel.removeChannel(reqDTO.getUid());
        RoomChannelManager.removeChannel(reqDTO.getRoomId(),nettyChannel,reqDTO.isOwner());

    }
}
