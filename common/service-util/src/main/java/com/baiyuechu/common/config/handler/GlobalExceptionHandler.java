package com.baiyuechu.common.config.handler;

import com.baiyuechu.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 */
@ControllerAdvice   //https://blog.csdn.net/qq_36829919/article/details/101210250
public class GlobalExceptionHandler {
    /**
     * 全局异常处理方法
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail().message("执行全局异常处理");
    }

    /**
     * 特定异常处理方法
     * @param e
     * @return
     */
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e) {
        e.printStackTrace();
        return Result.fail().message("执行特定异常处理");
    }

    /**
     * 自定义异常处理方法
     * @param e
     * @return
     */
    @ExceptionHandler(BaiyuechuException.class)
    @ResponseBody
    public Result error(BaiyuechuException e) {
        return Result.fail().message(e.getMessage()).code(e.getCode());
    }
}
