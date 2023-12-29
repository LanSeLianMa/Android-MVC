package com.example.androidmvc.mvc.view;

import com.example.androidmvc.base.IBaseView;
import com.example.androidmvc.mvc.controller.IController;

/**
 * 视图接口 负责视图逻辑
 */
public interface IView extends IBaseView {

    default void setController(IController controller) {} // 持有控制器，根据View事件，通知 Controller

    /**
     * 这些都是方法，都是由 Model 调用的
     */

    void onDataChangedUpdateText(String data); // 根据时时数据更新TextView

    void showSubmitFromLoading(String data); // 显示loading

    void hideSubmitFromLoading(); // 隐藏loading

    void clearFromData(); // 清空EditText数据

}
