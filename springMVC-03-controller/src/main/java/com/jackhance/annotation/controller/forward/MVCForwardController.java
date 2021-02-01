package com.jackhance.annotation.controller.forward;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MVCForwardController {
    // 无视图解析器转发-------------------------------------------------------------

    @RequestMapping("/rsm/t1")
    public String test1() {
        //转发
        return "/index.jsp";
    }

    @RequestMapping("/rsm/t2")
    public String test2() {
        //转发二（相当于test1）
        return "forward:/index.jsp";
    }

    @RequestMapping("/rsm/t3")
    public String test3() {
        //重定向, 需要完整路径，如/rsm/t1
        return "redirect:/test.jsp";
    }

    // 有视图解析器转发-------------------------------------------------------------

    @RequestMapping("/far/t1")
    public String test1(Model model) {
        model.addAttribute("msg", "SpringMVCForward");
        //转发
        return "hello";
    }

    @RequestMapping("/far/t2")
    public String test2(Model model) {
        model.addAttribute("msg", "SpringMVCRedirect");
        //重定向
        return "redirect:/index.jsp";
        //return "redirect:hello.do"; //hello.do为另一个请求/
    }
}
