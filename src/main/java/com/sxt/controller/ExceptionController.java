package com.sxt.controller;

import com.sxt.base.ControllerException;
import com.sxt.exception.BusinessException;
import com.sxt.exception.ParamsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionController extends ControllerException  {
    @RequestMapping("test01")
    @ResponseBody
    public String test01() {
        if (true) {
            /* 模拟程序抛出异常*/
            throw new ParamsException("ParamsException"); //抛出的异常信息要和 全局捕获异常的 匹配信息要保持一致
        }
        return "hello exception";
    }

    @RequestMapping("test02")
    @ResponseBody
    public String test02() {
        if (true) {
            throw new BusinessException("ParamsException"); //抛出的异常信息要和 全局捕获异常的 匹配信息要保持一致
        }
        return "hello exception";
    }

}
