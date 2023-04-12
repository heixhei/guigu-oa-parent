package com.baiyuechu.common.result;

import lombok.Data;

/**
 * 全局统一返回结果
 * @param <T>
 */
@Data
public class Result<T> {
    private Integer code;//返回码
    private String message;//返回消息
    private T data;//返回数据

    public Result() {

    }

    /**
     *返回数据
     * @param data
     * @return
     * @param <T> 自定义泛型无意义占位符
     */
    public static <T> Result<T> build(T data) {
        Result<T> result = new Result<>();
        if (data != null) {
            result.setData(data);
        }
        return result;
    }

    public static <T> Result<T> build(T data, Integer code, String message) {
        Result<T> result = build(data);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
    public static <T> Result<T> build(T data, ResultCodeEnum resultCodeEnum) {
        Result<T> result = build(data);
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }

    /**
     * 成功返回
     * @return
     * @param <T>
     */
    public static <T> Result<T> ok() {
        return build(null,ResultCodeEnum.SUCCESS);
    }
    public static <T> Result<T> ok(T data) {
        Result<T> result = build(data);
        return build(data, ResultCodeEnum.SUCCESS);
    }


    public static <T> Result<T> fail() {
        return build(null,ResultCodeEnum.FAIL);
    }
    /**
     * 失败返回
     * @param data
     * @return
     * @param <T>
     */
    public static <T> Result<T> fail(T data) {
        Result<T> result = build(data);
        return build(data, ResultCodeEnum.FAIL);
    }

    public   Result<T> message(String message) {
        this.message = message;
        return this;
    }

    public Result<T> code(Integer code) {
        this.code = code;
        return this;
    }

}
