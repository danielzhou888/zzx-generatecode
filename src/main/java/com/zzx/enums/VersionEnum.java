package com.zzx.enums;

public enum VersionEnum {

    VERSOIN1(1,"v1.0"),
    VERSION2(2,"v2.0")
    ;

    private Integer code;

    private String msg;

    VersionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
