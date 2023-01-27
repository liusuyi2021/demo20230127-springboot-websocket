package com.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

import static com.example.util.WebSocketUtils.ONLINE_USER_SESSIONS;
import static com.example.util.WebSocketUtils.sendMessageAll;

/**
 * @ClassName ChatServerEndpoint
 * @Description:
 * @Author 刘苏义
 * @Date 2023/1/27 7:42
 * @Version 1.0
 */

@RestController
@ServerEndpoint("/chat/{username}")
@Slf4j
public class ChatServerEndpoint {

    @OnOpen
    public void openSession(@PathParam("username") String username, Session session) {
        ONLINE_USER_SESSIONS.put(username, session);
        String message = "欢迎用户[" + username + "] 来到聊天室！";
        log.info("用户登录："+message);
        sendMessageAll(message);
    }

    @OnMessage
    public void onMessage(@PathParam("username") String username, String message) {
        log.info("发送消息："+message);
        sendMessageAll("用户[" + username + "] : " + message);
    }

    @OnClose
    public void onClose(@PathParam("username") String username, Session session) {
        //当前的Session 移除
        ONLINE_USER_SESSIONS.remove(username);
        //并且通知其他人当前用户已经离开聊天室了
        String message="用户[" + username + "] 已经离开聊天室了！";
        sendMessageAll(message);
        log.info("发送消息："+message);
        try {
            session.close();
        } catch (IOException e) {
            log.error("onClose error",e);
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        try {
            session.close();
        } catch (IOException e) {
            log.error("onError excepiton",e);
        }
        log.info("Throwable msg "+throwable.getMessage());
    }
}