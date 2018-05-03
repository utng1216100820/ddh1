package mx.com.dloza.descendent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SubMenuVideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu_video);
    }

    public void videoOneActivity (View view){
        Intent intent= new Intent(SubMenuVideoActivity.this,VideoDoloresActivity.class);
        startActivity(intent);
    }

    public void videoTwoActivity (View view){
        Intent intent= new Intent(SubMenuVideoActivity.this,VideoTwoDoloresActivity.class);
        startActivity(intent);
    }

    public void videoThreeActivity (View view){
        Intent intent= new Intent(SubMenuVideoActivity.this,VideoThreeDoloresActivity.class);
        startActivity(intent);
    }

    public void videoFourActivity (View view){
        Intent intent= new Intent(SubMenuVideoActivity.this,VideoFourDoloresActivity.class);
        startActivity(intent);
    }

    public void videoFiveActivity (View view){
        Intent intent= new Intent(SubMenuVideoActivity.this,VideoFiveActivity.class);
        startActivity(intent);
    }
}
