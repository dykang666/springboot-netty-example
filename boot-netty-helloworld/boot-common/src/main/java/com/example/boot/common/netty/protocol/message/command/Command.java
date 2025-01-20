package com.example.boot.common.netty.protocol.message.command;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2025/1/17 18:21
 */
public interface Command {
    Byte HEARTBEAT_REQUEST = 1;
    Byte HEARTBEAT_RESPONSE = 2;
}
