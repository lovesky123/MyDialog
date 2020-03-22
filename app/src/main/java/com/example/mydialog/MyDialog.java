package com.example.mydialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * BottomDialog
 * @author zhanghuibin
 * @desc Dialog封装
 */
public class MyDialog extends Dialog {

    TextView title, yesTv, noTv, cancelTv;
    LinearLayout yesLl,noLl;

    TextView yesRb, noRb;

    String sTitle, sYes, sNo, sCancel;

    public MyDialog(Context context) {
        super(context, R.style.DailyCheckDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_daily_check);
        //按空白处取消动画
        setCanceledOnTouchOutside(true);
        //初始化界面控件
        initView();
        //初始化界面数据
        initData();
        //初始化界面控件的事件
        initEvent();
    }

    /**
     * 初始化界面控件的显示数据
     */
    private void initData() {
        if (!TextUtils.isEmpty(sTitle)) {
            title.setText(sTitle);
        }
        if (!TextUtils.isEmpty(sYes)) {
            yesTv.setText(sYes);
        }
        if (!TextUtils.isEmpty(sNo)) {
            noTv.setText(sNo);
        }
        if (!TextUtils.isEmpty(sCancel)) {
            cancelTv.setText(sCancel);
        }
    }

    /**
     * 初始化控件
     */
    private void initView() {
        title = findViewById(R.id.title);
        yesLl = findViewById(R.id.ll_yes);
        noLl = findViewById(R.id.ll_no);
        yesTv = findViewById(R.id.tv_yes);
        noTv = findViewById(R.id.tv_no);
        cancelTv = findViewById(R.id.tv_cancel);
        yesRb = findViewById(R.id.rb_yes);
        noRb = findViewById(R.id.rb_no);
    }

    /**
     * 对外提供的设置Dialog内容的方法
     *
     * @param title
     * @return
     */
    public MyDialog setTitle(String title) {
        this.sTitle = title;
        return this;
    }

    public MyDialog setYes(String sYes) {
        this.sYes = sYes;
        return this;
    }

    public MyDialog setNo(String sNo) {
        this.sNo = sNo;
        return this;
    }

    public MyDialog setCancel(String sCancel) {
        this.sCancel = sCancel;
        return this;
    }

    private void initEvent() {
        yesLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onYesNoCancelOnclickListener != null) {
                    yesRb.setSelected(true);
                    noRb.setSelected(false);
                    onYesNoCancelOnclickListener.onYesClick();
                    dismiss();
                }
            }
        });

        noLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onYesNoCancelOnclickListener != null) {
                    yesRb.setSelected(false);
                    noRb.setSelected(true);
                    onYesNoCancelOnclickListener.onNoClick();
                    dismiss();
                }
            }
        });

        cancelTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onYesNoCancelOnclickListener != null) {
                    onYesNoCancelOnclickListener.onCancelClick();
                }
            }
        });
    }

    /**
     * 设置确定按钮和取消被点击的接口
     */
    public interface OnYesNoCancelOnclickListener {

        void onNoClick();

        void onYesClick();

        void onCancelClick();
    }

    private OnYesNoCancelOnclickListener onYesNoCancelOnclickListener;

    public void setOnYesNoCancelOnclickListener(OnYesNoCancelOnclickListener onYesNoCancelOnclickListener) {
        this.onYesNoCancelOnclickListener = onYesNoCancelOnclickListener;
    }
}
