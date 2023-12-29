package com.example.androidmvc.mvc.controller;

import com.example.androidmvc.mvc.model.IModel;

/**
 * 业务逻辑 具体实现
 */
public class IControllerImp implements IController {

    private IModel model;

    @Override
    public void setModel(IModel model) {
        this.model = model;
    }

    @Override
    public void removeHandlerMsgAndCallback() {
        model.removeHandlerMsgAndCallback();
    }

    @Override
    public void onDataChanged(String data) {
        model.onDataChanged(data);
    }

    @Override
    public void submitFrom() {
        model.submitFromData();
    }

    @Override
    public void clearData() {
        model.clearData();
    }
}
