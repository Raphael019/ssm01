package com.sxt.handle;

import com.sxt.exception.BusinessException;
import com.sxt.exception.ParamsException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Component
public class GlobalExceptionResolve implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object target,
                                         Exception ex) {
        //创建 ModelAndView 对象
        ModelAndView modelAndView = new ModelAndView();
        //设置默认信息
        modelAndView.setViewName("error"); // 设置默认错误页面
        modelAndView.addObject("ex",ex); //设置默认异常信息
        /**
         * 区分异常 ParamsException  BusinessException
         */
        if(ex instanceof ParamsException){
            ParamsException e = (ParamsException) ex;
            System.out.println(e+"++++++++++++++++++++++++++++++");
            modelAndView.setViewName("paramException");
            modelAndView.addObject("ex",e.getMsg());
        }

        if (ex instanceof BusinessException){
            BusinessException e = (BusinessException) ex;
            System.out.println(e+"*************************");
            modelAndView.setViewName("businessException");
            modelAndView.addObject("ex",e.getMsg());

        }
        return modelAndView;
    }
}
