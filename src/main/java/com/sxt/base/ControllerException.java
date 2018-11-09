package com.sxt.base;


import com.sxt.exception.BusinessException;
import com.sxt.exception.ParamsException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 这种方式处理异常
 *   需要处理的异常的方法要继承这个类
 */
public class ControllerException {
    @ExceptionHandler  // 可以捕获全局异常
    public String preHandle(HttpServletRequest request,
                            HttpServletResponse response,
                            Exception ex){
       //对捕获的异常进行判断处理
       if(ex instanceof ParamsException){
           ParamsException e = (ParamsException) ex;
           request.setAttribute("ex",e.getMsg());
           return "paramException";
       }

        //对捕获的异常进行判断处理
        if(ex instanceof BusinessException){
            BusinessException e = (BusinessException) ex;
            request.setAttribute("ex",e.getMsg());
            return "paramException";
        }

        //捕获的异常都不匹配，就走下面的异常处理程序
        request.setAttribute("ex", ex.getMessage());// ,默认错误信息
        return "error";// 默认错误页面

    }
}
