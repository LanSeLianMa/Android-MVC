package com.example.androidmvc.mvc.model;

import com.example.androidmvc.base.IBaseModel;
import com.example.androidmvc.mvc.view.IView;

/**
 * 数据模型接口 负责数据逻辑
 */
public interface IModel extends IBaseModel {

    void setView(IView view); // 持有View

    /**
     * 这些都是方法，都是由 Controller 调用的
     */

    void onDataChanged(String data); // 监听文本变化，时时更新数据后，通知 View

    void submitFromData(); // 提交表单数据后，通知 View

    void clearData(); // 清空数据后，通知 View

}
