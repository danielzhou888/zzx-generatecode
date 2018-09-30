package com.zzx.system.controller;

/**
 * Created by Administrator on 2018/9/10.
 */
public class ObjectResult<T extends Object> {
    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
