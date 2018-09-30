package com.zzx.system.base;

import java.util.Map;

/**
 * Created by zhouzhixiang on 2018/8/17.
 */
public interface IServiceParent {

    /**
     * 根据map中的属性将其塞入数据库
     * @param map
     */
    public void insertMap(Map map);
}
