package com.example.androidmvc.mvc.controller;

import com.example.androidmvc.base.IBaseController;
import com.example.androidmvc.mvc.model.IModel;

/**
 * 控制器接口 负责业务逻辑
 */
public interface IController extends IBaseController {

    void setModel(IModel model); // 持有model

    /**
     * 这些都是方法，都是由 View 调用的
     */

    void onDataChanged(String data); // 监听输入文本事件，通知 Model

    void submitFrom(); // 提交表单事件，通知 Model

    void clearData(); // 清空按钮点击事件，通知 Model

}
