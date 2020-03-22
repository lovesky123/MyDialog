package com.example.mydialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MyDialog dailyCheckDialog;
    HydrantTypeDialog hydrantTypeDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dailyCheckDialog == null) {
                    dailyCheckDialog = new MyDialog(MainActivity.this);
                }
                dailyCheckDialog.setOnYesNoCancelOnclickListener(new MyDialog.OnYesNoCancelOnclickListener() {
                    @Override
                    public void onNoClick() {
                        Toast.makeText(MainActivity.this, "no", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onYesClick() {
                        Toast.makeText(MainActivity.this, "Yes", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelClick() {
                        Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
                    }
                });
                dailyCheckDialog.show();
            }
        });
        findViewById(R.id.tv2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hydrantTypeDialog == null) {
                    hydrantTypeDialog = new HydrantTypeDialog(MainActivity.this);
                }
                hydrantTypeDialog.setOnMyClickListener(new HydrantTypeDialog.OnMyClickListener() {
                    @Override
                    public void onCityClick() {
                        Toast.makeText(MainActivity.this, "City", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onUnitRoomOutClick() {
                        Toast.makeText(MainActivity.this, "UnitRoomOut", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onUnitRoomInClick() {
                        Toast.makeText(MainActivity.this, "UnitRoomIn", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCraneClick() {
                        Toast.makeText(MainActivity.this, "Crane", Toast.LENGTH_SHORT).show();
                    }
                });
                hydrantTypeDialog.show();
            }
        });


    }
}
