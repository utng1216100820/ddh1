package mx.com.dloza.descendent.hidalgo;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;

import mx.com.dloza.descendent.R;

public class ShareActivity extends AppCompatActivity {

    private ImageButton btnShare;
    private ImageButton  btnFacebook;
    private ImageButton  btnWhatsapp;
    private ImageButton  btnTwitter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share);

        btnShare = findViewById(R.id.btn_share);
        btnFacebook = findViewById(R.id.btn_facebook);
        btnWhatsapp = findViewById(R.id.btn_whatsapp);
        btnTwitter = findViewById(R.id.btn_twitter);




        btnCompartir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.house_descendents) );
                startActivity(Intent.createChooser(intent, "compartir"));
            }
        });


        btnFacebook.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.house_descendents));
                intent.setPackage("com.facebook.katana");
                startActivity(intent);
            }
        });



            btnWhatsapp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT,getString(R.string.house_descendents));
                    intent.setPackage("com.whatsapp");
                    startActivity(intent);
                }
            });

            btnTwitter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.house_descendents));
                intent.setPackage("com.twitter.android");
                startActivity(intent);
            }
        });

    }
}
