package mx.com.dloza.descendent.dolores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mx.com.dloza.descendent.R;

public class ToursActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tours);
    }

    public void nextPaiting (View view){
        Intent intent= new Intent(ToursActivity.this,PaitingTour.class);
        startActivity(intent);
    }

    public void nextPhoto (View view){
        Intent intent= new Intent(ToursActivity.this,PhotoTour.class);
        startActivity(intent);
    }

    public void nextModel (View view){
        Intent intent= new Intent(ToursActivity.this,ModelTour.class);
        startActivity(intent);
    }

    public void nextStatue (View view){
        Intent intent= new Intent(ToursActivity.this,StatueTour.class);
        startActivity(intent);
    }
}
