package com.kazim.catchthepicture;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView timeText;
    TextView scoreText;
    int score;
    ImageView imageView;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;
    ImageView imageView13;
    ImageView imageView14;
    ImageView imageView15;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeText =findViewById(R.id.textView);
        scoreText=findViewById(R.id.textView1);
        imageView =findViewById(R.id.imageView);
        imageView1 =findViewById(R.id.imageView1);
        imageView2 =findViewById(R.id.imageView2);
        imageView3 =findViewById(R.id.imageView3);
        imageView4 =findViewById(R.id.imageView4);
        imageView5 =findViewById(R.id.imageView5);
        imageView6 =findViewById(R.id.imageView6);
        imageView7 =findViewById(R.id.imageView7);
        imageView8 =findViewById(R.id.imageView8);
        imageView9 =findViewById(R.id.imageView9);
        imageView10 =findViewById(R.id.imageView10);
        imageView11 =findViewById(R.id.imageView11);
        imageView12 =findViewById(R.id.imageView12);
        imageView13 =findViewById(R.id.imageView13);
        imageView14 =findViewById(R.id.imageView14);
        imageView15 =findViewById(R.id.imageView15);
        imageArray =new ImageView[]{imageView,imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12,imageView13,imageView14,imageView15 };
        score =0;
        hideİmages();
        new CountDownTimer(30000,1000){

            @Override
            public void onTick(long l) {
                timeText.setText("Time: "+l/1000);
            }

            @Override
            public void onFinish() {
                timeText.setText("Finish");
                handler.removeCallbacks(runnable);
                for(ImageView image :imageArray){
                    image.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alert =new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Restart Game");
                alert.setMessage(scoreText.getText());
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //restart
                        Intent intent =getIntent();
                        finish();
                        startActivity(intent);
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Game over", Toast.LENGTH_LONG).show();
                    }
                });
                alert.show();
            }
        }.start();
    }
    public void increaseScore(View view){

         score++;
         scoreText.setText("Score: "+score);


    }
    public void hideİmages(){
        handler =new Handler();
        runnable =new Runnable() {
            @Override
            public void run() {
                for(ImageView image :imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                Random r =new Random();
                int i =r.nextInt(16);
                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(runnable,500);
            }
        };
        handler.post(runnable);


    }
}