package com.example.hcl.bottlespin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView bottle;
    private Random random=new Random();
    private int lastDir;
    private boolean spinning=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottle=findViewById(R.id.bottle1);
    }

    public void spinBottle(View v){
        if(!spinning){
            int newDir=random.nextInt(3600);
            float pivotx=bottle.getWidth()/2;
            float pivoty=bottle.getHeight()/2;
            Animation rotate= new RotateAnimation(lastDir,newDir,pivotx,pivoty);
            rotate.setDuration(1000);
            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning=true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning=false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            lastDir=newDir;
            bottle.startAnimation(rotate);
        }
    }
}
