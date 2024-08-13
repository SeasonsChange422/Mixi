package com.mixi.server.common;

/**
 * @Description
 * @Author welsir
 * @Date 2024/8/5 19:53
 */
public enum ResultCode {
    INVALID_UID("违法的uid",101);

    private String msg;
    private int code;

    ResultCode(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
