package com.tfjybj.ftdp.utils;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @Classname ResultUtils 返回结果处理工具
 * @Date 2020/4/1 9:39
 * @Author by 张凯超
 * @Version 1.0
 */



@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultUtils implements Serializable {

    public static final String SUCCESS = "0000";
    public static final String FAIL = "1111";

    private static final long serialVersionUID = 1L;

    /**
     * 结果状态码
     */
    private String code;
    /**
     * 响应结果描述
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;

    /**
     * 异常信息
     */
    private Exception exception;


    public ResultUtils() {
        super();
    }

    /**
     * @param code 结果状态码
     * @param msg  响应结果描述
     */
    public ResultUtils(String code, String msg) {
        super();
        this.code = code;
        this.message = msg;
    }

    /**
     * @param code 结果状态码
     * @param msg  响应结果描述
     * @param data 数据
     */
    public ResultUtils(String code, String msg, Object data) {
        super();
        this.code = code;
        this.message = msg;
        this.data = data;
    }

    /**
     * @param code      结果状态码
     * @param msg       响应结果描述
     * @param exception 异常信息
     */
    public ResultUtils(String code, String msg, Exception exception) {
        super();
        this.code = code;
        this.message = msg;
        this.exception = exception;
    }

    public static com.tfjybj.ftdp.utils.ResultUtils build(String code, String msg, Object data) {
        return new com.tfjybj.ftdp.utils.ResultUtils(code, msg, data);
    }

    public static com.tfjybj.ftdp.utils.ResultUtils build(String code, String msg) {
        return new com.tfjybj.ftdp.utils.ResultUtils(code, msg, null);
    }

    public static com.tfjybj.ftdp.utils.ResultUtils build(String code, String msg, Exception e) {
        return new com.tfjybj.ftdp.utils.ResultUtils(code, msg, e);
    }

    /**
     * 结果状态码
     */
    public String getCode() {
        return code;
    }

    /**
     * 结果状态码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 响应结果描述
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置响应结果描述
     *
     * @param msg 响应结果描述
     */
    public void setMessage(String msg) {
        this.message = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

}

