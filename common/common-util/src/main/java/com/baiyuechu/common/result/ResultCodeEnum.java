package com.baiyuechu.common.result;

import lombok.Getter;

/**
 * 统一返回结果状态信息类
 */
@Getter
public enum ResultCodeEnum {
    SUCCESS(200, "成功"),
    FAIL(201, "失败");

    private Integer code;
    private String message;

    /**
     * 构造方法私有化
     * @param code
     * @param message
     */
    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
