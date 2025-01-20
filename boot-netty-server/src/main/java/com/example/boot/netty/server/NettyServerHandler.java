package com.example.boot.netty.server;


import com.example.boot.common.netty.protocol.message.HeartbeatResponsePacket;
import com.example.boot.common.netty.protocol.protobuf.MessageBase;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:  netty服务端处理器
 * @date 2025/1/17 18:06
 */
@Slf4j
@ChannelHandler.Sharable
public class NettyServerHandler   extends SimpleChannelInboundHandler<MessageBase.Message> {


    // NettyServerHandler     暂时没有收到 client hello server消息  也不知道什么原因
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageBase.Message msg) throws Exception {
        //MessageBase.Message.CommandType.HEARTBEAT_REQUEST
        if (MessageBase.Message.CommandType.HEARTBEAT_REQUEST.equals(msg.getCmd())) {
            if (msg.getCmd().equals(MessageBase.Message.CommandType.HEARTBEAT_REQUEST)) {
                log.info("收到客户端发来的心跳消息：{}", msg.toString());
                //回应pong
                ctx.writeAndFlush(new HeartbeatResponsePacket());
            } else if (msg.getCmd().equals(MessageBase.Message.CommandType.NORMAL)) {
                log.info("收到客户端的业务消息：{}", msg.toString());
            }
        }
    }
}