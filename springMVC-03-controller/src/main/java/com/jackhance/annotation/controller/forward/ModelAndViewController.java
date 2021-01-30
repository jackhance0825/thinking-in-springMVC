package com.jackhance.annotation.controller.forward;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 转发方式：ModelAndView
 * 设置ModelAndView对象 , 根据view的名称 , 和视图解析器跳到指定的页面 .
 * 页面 : {视图解析器前缀} + viewName +{视图解析器后缀}
 */
public class ModelAndViewController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //返回一个模型视图对象
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","ControllerTest1");
        mv.setViewName("hello");
        return mv;
    }
}
