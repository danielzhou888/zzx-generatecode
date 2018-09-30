package com.zzx.common;

import com.zzx.enums.ResponseEnum;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.io.Serializable;

public class ServiceResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer code;
    private String msg;
    private T data;
    private String version;

    public ServiceResponse() {
        this.setCode(ResponseEnum.SUCCESS.getCode());
        this.setMsg(ResponseEnum.SUCCESS.getMsg());
    }

    public ServiceResponse(T data) {
        this.setCode(ResponseEnum.SUCCESS.getCode());
        this.setMsg(ResponseEnum.SUCCESS.getMsg());
        this.data = data;
    }

    public ServiceResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ServiceResponse(ResponseEnum responseEnum) {
        this.setCode(responseEnum.getCode());
        this.setMsg(responseEnum.getMsg());
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public ServiceResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
