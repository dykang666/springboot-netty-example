package com.example.boot.common.netty.protocol.message;



import com.example.boot.common.netty.protocol.message.command.Command;
import lombok.Data;


/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2025/1/17 18:18
 */
@Data

public class HeartbeatRequestPacket  extends Packet {

    @Override
    public Byte getCommand() {
        return Command.HEARTBEAT_REQUEST;
    }
}
