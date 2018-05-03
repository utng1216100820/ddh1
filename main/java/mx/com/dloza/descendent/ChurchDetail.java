package mx.com.dloza.descendent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ChurchDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_church_detail);


        TextView title = findViewById(R.id.txt_title);
        TextView description = findViewById(R.id.txt_description);
       // ImageView image = findViewById(R.id.imv_detail);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle!=null){
            title.setText(bundle.getString("TIT"));
            description.setText(bundle.getString("DET"));
            //image.setImageResource(bundle.getInt("IMG"));
        }

    }

    public void mapsActivity (View view){
        Intent intent= new Intent(ChurchDetail.this,MapsActivity.class);
        startActivity(intent);
        finish();
    }

}
