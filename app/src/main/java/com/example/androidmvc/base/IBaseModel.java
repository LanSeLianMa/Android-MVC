package com.example.androidmvc.base;

/**
 * Base 数据模型接口 负责数据逻辑
 */
public interface IBaseModel {

    // 写一些，公用或者通用的方法，用于扩展

    default void removeHandlerMsgAndCallback() {} // 删除handler 回调和消息

}
