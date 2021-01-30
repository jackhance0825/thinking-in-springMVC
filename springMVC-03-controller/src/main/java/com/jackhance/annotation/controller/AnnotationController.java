package com.jackhance.annotation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类声明/hello & 方法声明 /h1
 * 等价于
 * 类不声明 & 方法声明 /hello/h1
 */
@Controller
@RequestMapping("/hello")
public class AnnotationController {

    /**
     * 真实访问地址 : 项目名/hello/h1
     */
    @RequestMapping("/h1")
    public String hello(Model m) {
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        m.addAttribute("msg", "hello,SpringMVC");
        //web-inf/jsp/hello.jsp
        return "hello";
    }

    @RequestMapping("/h2")
    public String hello2(Model m) {
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        m.addAttribute("msg", "hello,SpringMVC2");
        //web-inf/jsp/hello.jsp
        return "hello";
    }
}
