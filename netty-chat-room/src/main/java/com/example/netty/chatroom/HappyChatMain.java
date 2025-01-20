package com.example.netty.chatroom;

import com.example.netty.chatroom.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 *  WebSocket聊天室，客户端参考docs目录下的websocket.html
 * @date 2025/1/20 18:51
 */
public class HappyChatMain {
    private static final Logger logger = LoggerFactory.getLogger(HappyChatMain.class);

    public static void main(String[] args) {
        final HappyChatServer server = new HappyChatServer(Constants.DEFAULT_PORT);
        server.init();
        server.start();
        // 注册进程钩子，在JVM进程关闭前释放资源
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                server.shutdown();
                logger.warn(">>>>>>>>>> jvm shutdown");
                System.exit(0);
            }
        });
    }

}
