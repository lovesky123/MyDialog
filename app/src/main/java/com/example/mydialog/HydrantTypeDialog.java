package com.example.mydialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author zhanghuibin
 * @desc Dialog封装
 */
public class HydrantTypeDialog extends Dialog {
    TextView cancelTv;
    TextView cityRb, unitRoomOutRb, unitRoomInRb, carneRb;
    LinearLayout cityLl,unitRoomOutLl,unitRoomInLl,carneLl;
    public HydrantTypeDialog(Context context) {
        super(context, R.style.DailyCheckDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dailog_hydrant_type);
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
    }
    /**
     * 初始化控件
     */
    private void initView() {
        cancelTv = findViewById(R.id.tv_cancel);
        cityRb = findViewById(R.id.rb_city);
        unitRoomOutRb = findViewById(R.id.rb_unit_room_out);
        unitRoomInRb = findViewById(R.id.rb_unit_room_in);
        carneRb = findViewById(R.id.rb_crane);

        cityLl = findViewById(R.id.ll_city);
        unitRoomOutLl = findViewById(R.id.ll_unit_room_out);
        unitRoomInLl = findViewById(R.id.ll_unit_room_in);
        carneLl = findViewById(R.id.ll_crane);
    }

    private void initEvent() {
        cityLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onMyClickListener != null) {
                    cityRb.setSelected(true);
                    unitRoomOutRb.setSelected(false);
                    unitRoomInRb.setSelected(false);
                    carneRb.setSelected(false);
                    onMyClickListener.onCityClick();
                    dismiss();
                }
            }
        });

        unitRoomOutLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onMyClickListener != null) {
                    cityRb.setSelected(false);
                    unitRoomOutRb.setSelected(true);
                    unitRoomInRb.setSelected(false);
                    carneRb.setSelected(false);
                    onMyClickListener.onUnitRoomOutClick();
                    dismiss();
                }
            }
        });
        unitRoomInLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onMyClickListener != null) {
                    cityRb.setSelected(false);
                    unitRoomOutRb.setSelected(false);
                    unitRoomInRb.setSelected(true);
                    carneRb.setSelected(false);
                    onMyClickListener.onUnitRoomInClick();
                    dismiss();
                }
            }
        });
        carneLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onMyClickListener != null) {
                    cityRb.setSelected(false);
                    unitRoomOutRb.setSelected(false);
                    unitRoomInRb.setSelected(false);
                    carneRb.setSelected(true);
                    onMyClickListener.onCraneClick();
                    dismiss();
                }
            }
        });


        cancelTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    /**
     * 设置确定按钮和取消被点击的接口
     */
    public interface OnMyClickListener {
        void onCityClick();

        void onUnitRoomOutClick();

        void onUnitRoomInClick();

        void onCraneClick();
    }

    private OnMyClickListener onMyClickListener;

    public void setOnMyClickListener(OnMyClickListener onMyClickListenerr) {
        this.onMyClickListener = onMyClickListenerr;
    }
}
