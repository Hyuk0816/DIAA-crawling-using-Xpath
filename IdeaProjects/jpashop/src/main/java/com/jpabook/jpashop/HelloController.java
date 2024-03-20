package com.jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){ //Model 데이터 실어서 넘겨받을 수 있음
        model.addAttribute("data", "hello!!");
        return "hello";
    }
}
