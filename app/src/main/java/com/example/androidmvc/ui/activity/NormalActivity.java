package com.example.androidmvc.ui.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidmvc.R;
import com.example.androidmvc.databinding.ActivityNormalBinding;

/**
 * 不使用MVC的 传统写法
 */
public class NormalActivity extends AppCompatActivity {

    private ActivityNormalBinding binding;
    private Handler handler = new Handler();
    private String mData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNormalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.editMsg.setText("normal");
        binding.edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setMsg(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitFrom();
            }
        });

        binding.clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.edit.setText("");
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }

    private void setMsg(String data) {
        if (TextUtils.isEmpty(data)) {
            mData = "normal";
            binding.editMsg.setText("normal");
            return;
        }
        mData = data;
        binding.editMsg.setText(data);
    }

    /**
     * 模拟提交表单
     */
    private void submitFrom() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        TextView textView = new TextView(this);
        if (TextUtils.isEmpty(mData)) {
            mData = "normal";
        }
        textView.setText("正在提交：" + mData);
        builder.setCancelable(false);
        builder.setView(textView);
        AlertDialog dialog = builder.show();
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, 1500);
    }

}