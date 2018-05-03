package mx.com.dloza.descendent.hidalgo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import mx.com.dloza.descendent.R;

public class CostTicketsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost_tickets);

    }

    public void phone (View v){
        Intent intent;
        permission(v);
        intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:418-184-6151"));
        if (ActivityCompat.checkSelfPermission(CostTicketsActivity.this,Manifest.permission.CALL_PHONE)!=
                PackageManager.PERMISSION_GRANTED)
            return;
        startActivity(intent);
    }


    public void permission(View v){
        int permissionCheck = ContextCompat.checkSelfPermission(
                this,Manifest.permission.CALL_PHONE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED){
            Log.i("Mensaje", getString(R.string.not_permission_call));
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},225);
        }else{
            Log.i("Mensaje", getString(R.string.permission_call));
        }
    }
}
