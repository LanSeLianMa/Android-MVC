package com.example.androidmvc.ui.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import com.example.androidmvc.databinding.ActivityMvcBinding;
import com.example.androidmvc.mvc.controller.IController;
import com.example.androidmvc.mvc.controller.IControllerImp;
import com.example.androidmvc.mvc.model.IModel;
import com.example.androidmvc.mvc.model.IModelImp;
import com.example.androidmvc.mvc.view.IView;

/**
 * 视图逻辑 具体实现
 */
public class MVCActivity extends AppCompatActivity implements IView,View.OnClickListener {

    private IModel iModel; // 数据层 M
    private IController iController; // 控制器层 C
    private AlertDialog dialog;

    private ActivityMvcBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMvcBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        iModel = new IModelImp();
        iController = new IControllerImp();

        // 注意一下，写的顺序

        iModel.setView(this); // 持有View
        iController.setModel(iModel); // 持有Model
        setController(iController); // 持有控制器

        init();
    }

    @Override
    public void onClick(View v) {
        if (v == binding.submitBtn) {
            iController.submitFrom();
        } else if (v == binding.clearBtn) {
            iController.clearData();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iController.removeHandlerMsgAndCallback();
    }

    private void init() {
        binding.editMsg.setText("normal");
        binding.edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                iController.onDataChanged(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.submitBtn.setOnClickListener(this);
        binding.clearBtn.setOnClickListener(this);
    }

    @Override
    public void onDataChangedUpdateText(String data) {
        binding.editMsg.setText(data);
    }

    @Override
    public void showSubmitFromLoading(String data) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        TextView textView = new TextView(this);
        if (TextUtils.isEmpty(data)) {
            data = "normal";
        }
        textView.setText("正在提交：" + data);
        builder.setCancelable(false);
        builder.setView(textView);
        dialog = builder.show();
    }

    @Override
    public void hideSubmitFromLoading() {
        dialog.dismiss();
    }

    @Override
    public void clearFromData() {
        binding.edit.setText("");
        binding.editMsg.setText("normal");
    }
}