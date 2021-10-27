package com.example.tictac;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    TextView tv;
    int player =1;
    int buttonState [] ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        intView();
        addlistenerClick();
        buttonState =new int[]{0,0,0,0,0,0,0,0,0};

    }
    private void intView(){
        btn1=findViewById(R.id.btn_1);
        btn2=findViewById(R.id.btn_2);
        btn3=findViewById(R.id.btn_3);
        btn4=findViewById(R.id.btn_4);
        btn5=findViewById(R.id.btn_5);
        btn6=findViewById(R.id.btn_6);
        btn7=findViewById(R.id.btn_7);
        btn8=findViewById(R.id.btn_8);
        btn9=findViewById(R.id.btn_9);
        tv=findViewById(R.id.tv);
    }
    private void addlistenerClick(){
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_1:
                checWinwer(0,v);
                break;
            case R.id.btn_2:
                checWinwer(1,v);
                break;
            case R.id.btn_3:
                checWinwer(2,v);
                break;
            case R.id.btn_4:
                checWinwer(3,v);
                break;
            case R.id.btn_5:
                checWinwer(4,v);
                break;
            case R.id.btn_6:
                checWinwer(5,v);
                break;
            case R.id.btn_7:
                checWinwer(6,v);
                break;
            case R.id.btn_8:
                checWinwer(7,v);
                break;
            case R.id.btn_9:
                checWinwer(8,v);
                break;


        }

    }
    private void checWinwer(int i,View v){
        changeText(v,i);
        if (buttonState[i]==0){
            buttonState[i]=player;
        }
        if (buttonState[0]==player&&buttonState[1]==player&&buttonState[2]==player
          ||buttonState[0]==player&&buttonState[3]==player&&buttonState[6]==player
          ||buttonState[0]==player&&buttonState[4]==player&&buttonState[8]==player
          ||buttonState[2]==player&&buttonState[5]==player&&buttonState[8]==player
          ||buttonState[1]==player&&buttonState[4]==player&&buttonState[7]==player
          ||buttonState[3]==player&&buttonState[4]==player&&buttonState[5]==player
          ||buttonState[2]==player&&buttonState[4]==player&&buttonState[6]==player
        ){
            showAlertDialoge();
        }

    }
    private void changeText(View v,int i){
        Button selected =(Button) v;
        if (buttonState[i]==0){
            if (player==1){
                selected.setText("X");
                selected.setTextColor(Color.parseColor("#FFC107"));
                player=2;
            }else if (player==2){
                selected.setText("O");
                selected.setTextColor(Color.parseColor("#FF0707"));
                player=1;
            }
            tv.setText("Player :"+player);
        }

    }
    private void showAlertDialoge(){
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setTitle("YOU WIN")
                .setMessage("Do you want to replay...?")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        recreate();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
    }

