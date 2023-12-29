package com.example.androidmvc.mvc.model;

import android.os.Handler;

import com.example.androidmvc.mvc.view.IView;

/**
 * 数据模型逻辑 具体实现
 */
public class IModelImp implements IModel {

    private String mData = "";
    private Handler handler = new Handler();
    private IView iview;

    @Override
    public void setView(IView view) {
        this.iview = view;
    }

    @Override
    public void removeHandlerMsgAndCallback() {
        handler.removeCallbacksAndMessages(null);
    }

    @Override
    public void onDataChanged(String data) {
        mData = data;
        iview.onDataChangedUpdateText(data);
    }

    @Override
    public void submitFromData() {
        iview.showSubmitFromLoading(mData);
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iview.hideSubmitFromLoading();
            }
        }, 1500);
    }

    @Override
    public void clearData() {
        mData = "";
        iview.clearFromData();
    }
}
