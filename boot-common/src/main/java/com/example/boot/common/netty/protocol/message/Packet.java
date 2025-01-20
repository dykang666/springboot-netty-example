package com.example.boot.common.netty.protocol.message;

import lombok.Data;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2025/1/17 18:19
 */
@Data
public abstract  class Packet {
    /**
     * 版本
     */
    private Byte version = 1;

    public abstract Byte getCommand();
}
