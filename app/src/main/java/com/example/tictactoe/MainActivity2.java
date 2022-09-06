package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private TextView textView3;
    private TextView textView5;
    MediaPlayer mp;
    MediaPlayer mp1;
    int Player_O = 0;
    int Player_X = 1;
    int active_Player = Player_O;
    int[] fill = {-1, -1, -1, -1, -1, -1, -1, -1, -1};
    int isGAmeActive = 1;
    int i, count=0;
    String p1,p2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        textView3=findViewById(R.id.textView3);
        textView5=findViewById(R.id.textView5);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        Intent i = getIntent();
        p1 = i.getStringExtra(MainActivity.Extra_Name);
        p2 =i.getStringExtra(MainActivity.Extra_Name2);
        textView3.setText(""+p1);
        textView5.setText(""+p2);
        mp=MediaPlayer.create(this,R.raw.sample);
        mp1=MediaPlayer.create(this,R.raw.win);
    }
    @Override
    public void onClick(View v) {
        if(isGAmeActive==0)
        {
            return;
        }
        Button clickedBtn = findViewById(v.getId());
        int clickedtag = Integer.parseInt(v.getTag().toString());
        if (fill[clickedtag] != -1) {
            return;
        }
        fill[clickedtag] = active_Player;
        if (active_Player == Player_O) {
            mp.start();
            clickedBtn.setText("O");
            count++;
            active_Player = Player_X;
        } else {
            mp.start();
            clickedBtn.setText("X");
            count++;
            active_Player = Player_O;
        }
        checkWin();
    }

    private void checkWin() {
        int[][] winPos = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0,4,8}, {2,4,6}};
        for (i = 0; i < 8; i++) {
            int val0 = winPos[i][0];
            int val1 = winPos[i][1];
            int val2 = winPos[i][2];
            if (fill[val0] == fill[val1] && fill[val1] == fill[val2]) {
                if (fill[val0] != -1) {
                    isGAmeActive = 0;
                    if (fill[val0] == Player_O) {
                        mp1.start();
                        showDialog(""+p1+" has won the match");
                    }
                    else
                        {
                            mp1.start();
                            showDialog(""+p2+ " has won the match");
                    }
                }
            }
        }
        if(isGAmeActive==1 && count==9 )
        {
            mp1.start();
            showDialog("Draw");
        }
    }
    private void showDialog(String winner){
        new AlertDialog.Builder(this)
                .setTitle(winner)
                .setPositiveButton("Restart game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        restart();
                    }
                })
                .show();
    }
    private void restart(){
        active_Player=Player_O;
        fill=new int[] {-1,-1,-1,-1,-1,-1,-1,-1,-1};
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");
        isGAmeActive=1;
        count= 0;
    }
}


