package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName chatController
 * @Description:
 * @Author 刘苏义
 * @Date 2023/1/27 7:51
 * @Version 1.0
 */
@Controller
public class chatController {
    @RequestMapping("/")
    String chat()
    {
        return "chat";
    }
}
