package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText1;
    private EditText editText2;
    private Button button;
    private MediaPlayer mp2;
    public static final String Extra_Name = "com.example.tictactoe.extra.NAME";
    public static final String Extra_Name2="com.example.tictactoe.extra.Name1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp2=MediaPlayer.create(this,R.raw.game);

    }
    public void openActivity(View v){
        //Toast.makeText(this, "Hii", Toast.LENGTH_SHORT).show();
        mp2.start();
        Intent i = new Intent(this,MainActivity2.class);
        editText1=findViewById(R.id.editTextTextPersonName);
        editText2=findViewById(R.id.editTextTextPersonName2);
        String Player1 = editText1.getText().toString();
        String Player2 = editText2.getText().toString();
        i.putExtra(Extra_Name,Player1);
        i.putExtra(Extra_Name2,Player2);
        startActivity(i);
    }
}