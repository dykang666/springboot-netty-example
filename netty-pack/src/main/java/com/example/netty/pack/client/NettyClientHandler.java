package com.example.netty.pack.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2025/1/20 17:47
 */
public class NettyClientHandler  extends ChannelInboundHandlerAdapter {
    /** 条数 */
    private int count=0;

    /**
     * 建立连接时
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("建立连接时："+new Date());
        ctx.fireChannelActive();
    }
    /**
     * 关闭连接时
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("关闭连接时："+new Date());
    }


    /**
     * 业务逻辑处理
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("第"+count+"次"+",客户端接受的消息:"+msg);
        count++;
    }
}
