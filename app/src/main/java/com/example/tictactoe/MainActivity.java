 package com.example.tictactoe;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean gameactive = true;
      // player reprasentation
      // o - X
      // 1 - O

    int activeplayer = 0;
    int[] gamestate = {2, 2, 2, 2, 2, 2, 2, 2, 2,};

     // gamestate meaning

        // 0 - X
        // 1 - O
        // 2 - Null

    int[][] winpositions = {{0,1,2} , {3,4,5} , {6,7,8} , {0,3,6} , {1,4,7} , {2,5,8} ,
                            {0,4,8} , {2,4,6}};


    @SuppressLint("WrongConstant")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void playertap(View View){
        Log.e("gggg","raju");
        Object view = null;
        ImageView img = (ImageView) View;

        int tappedimage;
        tappedimage = Integer.parseInt(img.getTag().toString());
        if(!gameactive){
             gameReset((android.view.View)view);
         }
         if(gamestate[tappedimage] == 2){
             gamestate[tappedimage] = activeplayer;
             //img.setTranslationY(-1000f);
             if(activeplayer == 0){
                 img.setImageResource(R.drawable.x);
                 activeplayer = 1;
                 final TextView  status = (TextView)findViewById(R.id.status);
                 status.setText("O's Turn - Tap To Play");
             }
             else{
                 img.setImageResource(R.drawable.o);
                 activeplayer = 0;
                 final TextView status = (TextView)findViewById(R.id.status);
                 status.setText("X's Turn - Tap To Play");
             }
         //    img.animate().translationXBy(1000f).setDuration(300);
         }

         // check if any player one

        for(int[] winposition: winpositions){
            if(gamestate[winposition[0]] == gamestate[winposition[1]] &&
                    gamestate[winposition[1]] == gamestate[winposition[2]] &&
                    gamestate[winposition[0]]!=2){
                // somebody has won - Find out who?
               String winnerstr;
               gameactive = false;
                if(gamestate[winposition[0]] == 0){
                    winnerstr = "X has Won!";
                }
                else{
                    winnerstr = "O has Won!";
                }

                // update status bar for winner

                final TextView status = (TextView)findViewById(R.id.status);
                status.setText(winnerstr);
                
            }
        }

         
    }

    public void gameReset(View View) {
        gameactive = true;
        activeplayer = 0;
        for(int i=0; i<gamestate.length;i++){
            gamestate[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}