package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @ClassName websocketConfig
 * @Description:
 * @Author εθδΉ
 * @Date 2023/1/27 8:49
 * @Version 1.0
 */
@Configuration
public class websocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
