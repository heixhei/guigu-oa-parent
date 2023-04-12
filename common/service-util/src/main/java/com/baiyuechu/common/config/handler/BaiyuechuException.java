package com.baiyuechu.common.config.handler;

import com.baiyuechu.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * 自定义异常处理类
 */
@Data
public class BaiyuechuException extends RuntimeException {
    private Integer code;
    private String msg;

    /**
     * 自定义异常处理类构造方法
     * @param code
     * @param msg
     */
    public BaiyuechuException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    /**
     * 枚举变量构造方法
     * @param resultCodeEnum
     */
    public BaiyuechuException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMessage();
    }

}
