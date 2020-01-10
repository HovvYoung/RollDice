package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.util.Random;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView diceImage1 = findViewById(R.id.imgDice1);
        final ImageView diceImage2 = findViewById(R.id.imgDice2);

        final int [] diceImages = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3,
                R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_sound);

        Button btnRoll = findViewById(R.id.btnRollTheDice);
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MyDiceApp", "click botton!!");
                Random rndObject = new Random();

                int rndNumber1 = rndObject.nextInt(6);  // 0 ... 6
                int rndNumber2 = rndObject.nextInt(6);  // 0 ... 6

                diceImage1.setImageResource(diceImages[rndNumber1]);
                diceImage2.setImageResource(diceImages[rndNumber2]);

                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(diceImage1);
                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(diceImage2);

                mp.start();
            }
        });

    }
}
