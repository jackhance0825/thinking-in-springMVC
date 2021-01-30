package com.jackhance.annotation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 1. 实现接口Controller定义控制器是较老的办法：
 * 缺点是：一个控制器中只有一个方法，如果要多个方法则需要定义多个Controller；定义的方式比较麻烦；
 * <p>
 * 2. 使用注解@Controller：（重点）
 * 注解方式是平时使用的最多的方式！
 * <p>
 * 3. RestFul风格：（重点）
 * Restful就是一个资源定位及资源操作的风格。不是标准也不是协议，只是一种风格。基于这个风格设计的软件可以更简洁，更有层次，更易于实现缓存等机制。
 */
@Controller
@RequestMapping("restful")
public class RestfulController {

    // http://localhost:8080/restful/t1?a=1&b=jack
    @RequestMapping("/t1")
    public String restful1(int a, String b, Model model) {
        String msg = a + b;
        model.addAttribute("msg", msg);
        return "restful/test";
    }

    // http://localhost:8080/restful/t2/1/jack
    @RequestMapping("/t2/{a}/{b}")
    public String restful2(@PathVariable int a, @PathVariable String b, Model model) {
        String msg = a + b;
        model.addAttribute("msg", msg);
        return "restful/test";
    }

    // http://localhost:8080/restful/t3/1/jack
    @RequestMapping(path = "/t3/{a}/{b}", method = {RequestMethod.GET})
    public String restful3(@PathVariable int a, @PathVariable String b, Model model) {
        String msg = a + b;
        model.addAttribute("msg", msg);
        return "restful/test";
    }

    /**
     * url相同，不同的请求方式，实现不同的效果！
     * 如下：请求地址一样，但是功能可以不同！
     * <p>
     * 更多注解：
     *
     * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     */
    //http://localhost:8080/restful/t4/1/jack
    @GetMapping("/t4/{a}/{b}")
    public String restful4(@PathVariable int a, @PathVariable String b, Model model) {
        String msg = "method=get&a=" + a + "&b=" + b;
        model.addAttribute("msg", msg);
        return "restful/test";
    }

    @PostMapping("/t4/{a}/{b}")
    public String restful5(@PathVariable int a, @PathVariable String b, Model model) {
        String msg = "method=post&a=" + a + "&b=" + b;
        model.addAttribute("msg", msg);
        return "restful/test";
    }

    // 声明多个时，只生效第一个
    @PostMapping("/t5/{a}/{b}")
    @GetMapping("/t5/{a}/{b}")
    public String restful6(@PathVariable int a, @PathVariable String b, Model model) {
        String msg = "method=post + get &a=" + a + "&b=" + b;
        model.addAttribute("msg", msg);
        return "restful/test";
    }
}
