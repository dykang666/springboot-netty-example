package com.example.boot.netty.client;


import com.example.boot.common.netty.protocol.protobuf.MessageBase;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2025/1/17 18:40
 */
@Component
@Slf4j
public class NettyClient {
    private EventLoopGroup group = new NioEventLoopGroup();
    @Value("${netty.port}")
    private int port;
    @Value("${netty.host}")
    private String host;
    private SocketChannel socketChannel;

    public void sendMsg(MessageBase.Message message) {
        socketChannel.writeAndFlush(message);
    }
    //@PostConstruct注解，在指定的方法上加上 @PostConstruct注解来表示该方法在 Spring 初始化 NettyServer类后调用。
    @PostConstruct
    public void start()  {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .remoteAddress(host, port)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ClientHandlerInitilizer());
        ChannelFuture future = bootstrap.connect();
        //客户端断线重连逻辑
        future.addListener((ChannelFutureListener) future1 -> {
            if (future1.isSuccess()) {
                log.info("连接Netty服务端成功");
            } else {
                log.info("连接失败，进行断线重连");
                future1.channel().eventLoop().schedule(() -> start(), 20, TimeUnit.SECONDS);
            }
        });
        socketChannel = (SocketChannel) future.channel();
    }


}
