package com.example.administrator.onesecond;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvTime;
    LinearLayout llButton;
    TextView tvNomal;
    TextView tvGod;
    TextView tvAction;
    TextView tvDes;
    TextView tvTry;
    long downTime;
    long upTime;
    int godTime;
    int nomalTime;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        initListener();
    }

    private void initListener() {
        llButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    num++;
                    downTime =System.currentTimeMillis();

                }else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    upTime =System.currentTimeMillis();
                    tvTry.setText("你尝试了"+num+"次");
                    double time =calculateTime();
                    tvTime.setText(""+time);
                    if(Math.abs(time -1)>0.1){
                        nomalTime++;
                        tvNomal.setText("凡人:"+nomalTime);
                        tvDes.setText("少侠，你还是凡人!!");
                        setVisibleToBtn();

                    }else{
                        godTime++;
                        setVisibleToBtn();
                        tvGod.setText("大神:"+godTime);
                        tvDes.setText("碉堡了,少侠你是大神!!");
                    }
                }else if(motionEvent.getAction() == MotionEvent.ACTION_MOVE){

            }return false;
            }
        });
    }

    private void setVisibleToBtn() {
        tvAction.setVisibility(View.GONE);
        tvDes.setVisibility(View.VISIBLE);
        tvTime.setVisibility(View.VISIBLE);


    }

    private double calculateTime() {
        return (double )(upTime-downTime)/1000;
    }

    private void findView() {
        tvTime =(TextView) findViewById(R.id.tv_time);
        llButton =(LinearLayout) findViewById(R.id.ll_btn);
        tvNomal =(TextView) findViewById(R.id.tv_nomal);
        tvGod =(TextView) findViewById(R.id.tv_god);
        tvAction =(TextView) findViewById(R.id.tx_action);
        tvDes =(TextView) findViewById(R.id.tx_des);
        tvTry =(TextView) findViewById(R.id.tx_try);
    }


}
