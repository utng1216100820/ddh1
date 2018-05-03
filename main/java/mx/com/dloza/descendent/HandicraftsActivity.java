package mx.com.dloza.descendent;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HandicraftsActivity extends AppCompatActivity implements HandicraftsOne.OnFragmentInteractionListener,
        HandicraftsTwo.OnFragmentInteractionListener,
        HandicraftsThree.OnFragmentInteractionListener{


    HandicraftsOne handicraftsOne;
    HandicraftsTwo handicraftsTwo;
    HandicraftsThree handicraftsThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handicrafts);

        handicraftsOne = new HandicraftsOne();
        handicraftsTwo = new HandicraftsTwo();
        handicraftsThree = new HandicraftsThree();

        getSupportFragmentManager().beginTransaction().add(R.id.container_fragment,handicraftsOne).commit();

    }

    public void onClick(View view){

        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (view.getId()){
            case R.id.btn_dolores:
                transaction.replace(R.id.container_fragment, handicraftsOne);
                break;
            case R.id.btn_handicrafts:
                transaction.replace(R.id.container_fragment, handicraftsTwo);
                break;
            case R.id.btn_handicrafts_two:
                transaction.replace(R.id.container_fragment, handicraftsThree);
                break;
        }
        transaction.commit();
    }








    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
