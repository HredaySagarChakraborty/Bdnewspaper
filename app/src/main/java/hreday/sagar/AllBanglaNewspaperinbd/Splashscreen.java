package hreday.sagar.AllBanglaNewspaperinbd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class Splashscreen extends AppCompatActivity {

    private ProgressBar progressBar;
    private int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slash_screen);


     //  this.setTitle("SplashScreen");
        getSupportActionBar().hide();

        progressBar=findViewById(R.id.progressbarId);


        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                Intent intent=new Intent(Splashscreen.this,MainActivity.class);
                startActivity(intent);
            }
        });
        thread.start();


    }

    private void doWork() {

        for(int progress=20;progress<=100;progress=progress+20){


            try {
                Thread.sleep(1000);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
