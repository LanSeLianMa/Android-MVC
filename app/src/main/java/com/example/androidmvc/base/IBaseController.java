package com.example.androidmvc.base;

/**
 * Base 控制器接口 负责业务逻辑
 */
public interface IBaseController {

    // 写一些，公用或者通用的方法，用于扩展

    default void removeHandlerMsgAndCallback() {} // 删除handler 回调和消息

}
