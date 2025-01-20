package com.example.netty.pack.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.net.InetAddress;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2025/1/20 17:51
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /** 条数 */
    private  AtomicInteger atomicInt = new AtomicInteger(0);

    /**
     * 业务逻辑处理
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        String body = (String) msg;
        System.out.println("接受的数据是: " + body + ";条数是: " + atomicInt.incrementAndGet());
    }

    /**
     * 建立连接时，返回消息
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("连接的客户端地址:" + ctx.channel().remoteAddress());
        ctx.writeAndFlush("客户端"+ InetAddress.getLocalHost().getHostAddress() + "成功与服务端建立连接！ ");
        super.channelActive(ctx);
    }


}
