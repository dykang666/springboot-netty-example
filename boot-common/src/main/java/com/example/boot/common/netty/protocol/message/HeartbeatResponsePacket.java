package com.example.boot.common.netty.protocol.message;


import com.example.boot.common.netty.protocol.message.command.Command;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2025/1/17 18:24
 */
public class HeartbeatResponsePacket extends Packet{
    @Override
    public Byte getCommand() {
        return Command.HEARTBEAT_RESPONSE;
    }
}
