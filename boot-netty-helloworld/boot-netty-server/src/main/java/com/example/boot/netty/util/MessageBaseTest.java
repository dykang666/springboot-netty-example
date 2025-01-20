package com.example.boot.netty.util;

import com.example.boot.common.netty.protocol.protobuf.MessageBase;

import java.util.UUID;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2025/1/17 19:05
 */
public class MessageBaseTest {
    public static void main(String[] args) {
        MessageBase.Message message = MessageBase.Message.newBuilder()
                .setRequestId(UUID.randomUUID().toString())
                .setContent("hello world").build();
        System.out.println("message: "+message);
    }
}
