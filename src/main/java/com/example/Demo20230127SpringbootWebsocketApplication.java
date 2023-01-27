package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@EnableWebSocket
@SpringBootApplication
public class Demo20230127SpringbootWebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo20230127SpringbootWebsocketApplication.class, args);
    }

}
