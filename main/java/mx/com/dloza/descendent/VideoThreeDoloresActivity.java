package mx.com.dloza.descendent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoThreeDoloresActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener, YouTubePlayer.PlaybackEventListener {

    String apiYouTube="AIzaSyDKAkbxcDezLGrRFBgMPOUWTZZfr0Z3rOc";
    YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_three_dolores);

        youTubePlayerView=(YouTubePlayerView)findViewById(R.id.youtube_view);
        youTubePlayerView.initialize(apiYouTube,this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if (!b){
            youTubePlayer.cueVideo("-riObenPK5Y"); //https://www.youtube.com/watch?v=-riObenPK5Y
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(this, 1).show();
        }else{
            String error= "Error al inicializar YouTube"+youTubeInitializationResult.toString();
            Toast.makeText(getApplication(),error,Toast.LENGTH_LONG).show();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode==1){
            getYoutubePlayerProvider().initialize(apiYouTube,this);
        }
    }

    protected  YouTubePlayer.Provider getYoutubePlayerProvider(){
        return youTubePlayerView;
    }

    @Override
    public void onPlaying() {

    }

    @Override
    public void onPaused() {

    }

    @Override
    public void onStopped() {

    }

    @Override
    public void onBuffering(boolean b) {

    }

    @Override
    public void onSeekTo(int i) {

    }
}
