package mx.com.dloza.descendent.dolores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import mx.com.dloza.descendent.ChurchDetail;
import mx.com.dloza.descendent.MapsActivity;
import mx.com.dloza.descendent.R;

public class SnowDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snow_detail);

        TextView txtTitle = findViewById(R.id.txt_title);
        TextView txtDescription = findViewById(R.id.txt_description);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle!=null){
            title.setText (bundle.getString("TIT"));
            description.setText (bundle.getString("DET"));
        }

    }

    public void mapsActivity (View view){
        Intent intent= new Intent(SnowDetail.this,MapsActivity.class);
        startActivity(intent);
        finish();
    }
}
