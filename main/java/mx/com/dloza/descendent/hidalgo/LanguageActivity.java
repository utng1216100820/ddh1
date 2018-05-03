package mx.com.dloza.descendent.hidalgo;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

import mx.com.dloza.descendent.R;

public class LanguageActivity extends AppCompatActivity {

    private Button button;
    private TextView textview;
    private Locale locale;
    private Configuration config = new Configuration();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        button = (findViewById(R.id.button));


        button.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        showDialog();
                    }});
    }


    private void showDialog(){
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle(getResources().getString(R.string.change));
        //obtiene los idiomas del array de string.xml
        String[] types = getResources().getStringArray(R.array.languages);
        b.setItems(types, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                switch (which) {
                    case 0:
                        locale = new Locale("es");
                        button.setBackgroundResource(R.drawable.spanish);
                        config.locale = locale;
                        break;
                    case 1:
                        locale = new Locale("en");
                        button.setBackgroundResource(R.drawable.english);
                        config.locale = locale;
                        break;

                }
                getResources().updateConfiguration(config, null);
                Intent refresh = new Intent(LanguageActivity.this, LanguageActivity.class);
                startActivity(refresh);
                finish();
            }


        });

        b.show();
    }
}

