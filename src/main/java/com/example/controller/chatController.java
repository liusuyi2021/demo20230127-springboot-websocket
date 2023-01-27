package com.example.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName chatController
 * @Description:
 * @Author 刘苏义
 * @Date 2023/1/27 7:51
 * @Version 1.0
 */
@RestController
public class chatController {

    @RequestMapping("/")
    String chatServerEndpoint()
    {
        return "chat";
    }
}
