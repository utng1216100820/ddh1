package mx.com.dloza.descendent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RestaurantActivity extends AppCompatActivity implements Fruty.OnFragmentInteractionListener,
                RestaurantSquare.OnFragmentInteractionListener,Mostacho.OnFragmentInteractionListener,
                Nana.OnFragmentInteractionListener,Corner.OnFragmentInteractionListener{

    Fruty fragmentFruty;
    RestaurantSquare fragmentRestaurantSquare;
    Mostacho fragmentMostacho;
    Nana fragmentNana;
    Corner fragmentRincon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        fragmentFruty = new Fruty();
        fragmentRestaurantSquare = new RestaurantSquare();
        fragmentMostacho = new Mostacho();
        fragmentNana = new Nana();
        fragmentRincon = new Corner();

        getSupportFragmentManager().beginTransaction().add(R.id.container_fragment, fragmentFruty).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void onClick(View view){

        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (view.getId()){
            case R.id.btn_fruty:
                transaction.replace(R.id.container_fragment, fragmentFruty);
                break;
            case R.id.btn_restaurant_square:
                transaction.replace(R.id.container_fragment, fragmentRestaurantSquare);
                break;
            case R.id.btn_mostacho:
                transaction.replace(R.id.container_fragment, fragmentMostacho);
                break;
            case R.id.btn_nana_pancha:
                transaction.replace(R.id.container_fragment, fragmentNana);
                break;
            case R.id.btn_rincon:
                transaction.replace(R.id.container_fragment, fragmentRincon);
                break;
        }
        transaction.commit();
    }

    public void mapsActivity (View view){
        Intent intent= new Intent(RestaurantActivity.this,MapsActivity.class);
        startActivity(intent);
        finish();
    }

}
