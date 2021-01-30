package com.jackhance.annotation.controller.param;

import com.jackhance.annotation.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    /**接收数据********************************************************************************/

    /**
     * 参数根据参数名注入(只支持单个)
     * <p>
     * http://localhost:8080/user/t1?name=jackhance
     */
    @GetMapping("/t1")
    public String test1(String name, Model model) {
        //1.接收前端传递来的参数
        System.out.println("前端传递来的参数为：name=" + name);

        //2.返回结果传递给前端，使用Model
        model.addAttribute("msg", name);

        //3.视图跳转
        return "test";
    }

    /**
     * 推荐使用注解@RequestParam，当出错时可以显示错误信息为参数错误
     * <p>
     * http://localhost:8080/user/t2?username=jackhance&id=10
     */
    @GetMapping("/t2")
    public String test2(@RequestParam("username") String name, @RequestParam("id") int id, Model model) {
        //1.接收前端传递来的参数
        System.out.println("前端传递来的参数为：name=" + name + ", id=" + id);

        //2.返回结果传递给前端，使用Model
        model.addAttribute("msg", name);

        //3.视图跳转
        return "test";
    }

    /**
     * 接收请求对象
     * 参数名必须和对象的属性一致，否则属性值为null
     * <p>
     * http://localhost:8080/user/t3?name=jackhance&id=1&age=24
     */
    @GetMapping("/t3")
    public String test3(User user, Model model) {
        System.out.println("前端传递来的参数为：" + user);
        model.addAttribute("msg", user);
        return "test";
    }

    /**发送数据********************************************************************************/

    /**
     * 方式1：实现Controller接口，使用ModelAndView
     * 可以在储存数据的同时，可以进行设置返回的逻辑视图，进行控制展示层的跳转。
     */


    /**
     * 方式2：ModelMap
     * 除了实现了自身的一些方法，同样的继承 LinkedHashMap 的方法和特性；
     * <p>
     * http://localhost:8080/user/s1?username=jackhance
     */
    @GetMapping("/s1")
    public String send1(@RequestParam("username") String name, ModelMap model) {
        model.addAttribute("msg", name);
        return "test";
    }

    /**
     * 方式3：Model
     * 只有寥寥几个方法只适合用于储存数据，简化了新手对于Model对象的操作和理解；
     * <p>
     * http://localhost:8080/user/s2?username=jackhance
     */
    @GetMapping("/s2")
    public String send2(@RequestParam("username") String name, Model model) {
        model.addAttribute("msg", name);
        return "test";
    }

}
