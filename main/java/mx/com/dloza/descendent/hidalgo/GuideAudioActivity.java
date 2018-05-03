package mx.com.dloza.descendent.hidalgo;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import mx.com.dloza.descendent.R;

public class GuideAudioActivity extends AppCompatActivity {

    Button play_stop;
    MediaPlayer mp;
    int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_audio);
        play_stop = findViewById(R.id.play_stop);
        mp = MediaPlayer.create( this, R.raw.audioguide);
        play_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp.isPlaying()){
                    mp.pause();
                    play_stop.setBackgroundResource(R.drawable.play);
                    Toast.makeText(GuideAudioActivity.this, "Pause", Toast.LENGTH_SHORT).show();
                }else{
                    mp.start();
                    play_stop.setBackgroundResource(R.drawable.pause);
                    Toast.makeText(GuideAudioActivity.this, "Play", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void destruir() {
        if (mp != null) {
            mp.release();
        }
    }
/*
    public void stop(View v){
        if (mp != null){
            mp.stop();
            position = 0;
        }
    }*/
}

