package com.example.nettyhelloworld.client;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2025/1/20 15:00
 */
@ChannelHandler.Sharable
public class ClientHandler  extends SimpleChannelInboundHandler<String> {
    //读取数据
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.err.println(msg);
    }

    //异常处理
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
