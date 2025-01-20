package com.example.boot.netty.client;

import ch.qos.logback.core.net.SocketConnector;
import com.example.boot.common.netty.protocol.protobuf.MessageBase;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;


/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 *              客户端初始化器
 * @date 2025/1/17 18:54
 */
public class ClientHandlerInitilizer extends ChannelInitializer<Channel> {
    @Override
    protected void initChannel(Channel channel) throws Exception {
        channel.pipeline()
                .addLast(new IdleStateHandler(0, 10, 0))
                .addLast(new ProtobufVarint32FrameDecoder())
                .addLast(new ProtobufDecoder(MessageBase.Message.getDefaultInstance()))
                .addLast(new ProtobufVarint32LengthFieldPrepender())
                //编码器
                .addLast(new ProtobufEncoder())
                //心跳处理
                .addLast(new HeartbeatHandler(new NettyClient()))
                //业务处理
                .addLast(new NettyClientHandler());


    }
}
