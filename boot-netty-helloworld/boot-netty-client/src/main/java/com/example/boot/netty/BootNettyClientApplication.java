package com.example.boot.netty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 构建Netty 服务端
//构建Netty 客户端
// 利用protobuf定义消息格式
// 服务端空闲检测
// 客户端发送心跳包与断线重连

@SpringBootApplication
public class BootNettyClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootNettyClientApplication.class, args);
    }

}
