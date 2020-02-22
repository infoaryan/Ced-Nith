package infoaryan.in.qsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//Animation can be used with the linear layout after applying the basic
        //background to the Linear layout also butsince we have given the background so we dont need to do it
        //otherwise we would have done it by using setBackgroundresource

        LinearLayout linearLayout = findViewById(R.id.linearlayout);
        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(800);
        animationDrawable.setExitFadeDuration(900);
        animationDrawable.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            //  The splash screen comes here
                Intent i=new Intent(MainActivity.this,Home1.class);
                startActivity(i);
                finishAfterTransition();
//the animation is starting here
            }
        },2000);
    }
}
