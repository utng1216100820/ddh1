package mx.com.dloza.descendent.dolores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import mx.com.dloza.descendent.AdapterListElement;
import mx.com.dloza.descendent.R;

public class PrincipalActivity extends AppCompatActivity {
    ListView list;
    String [][] data;/* ={
            {"Nieves y Helados \nJouse", "Plaza Principal s/n,\nCentro, Dolores Hidalgo,", "Nieves con más de 30 años de expericia y gran variedad de sabores.\n" +
                    "\n" +
                    "Los sabores más comunes que podrás encontrar son: vainilla, limón, fresa, mango y nuez.\n" +
                    "\n" +
                    "Los sabores más exoticos son: Petalo de rosa, Beso de Angel, Tequila, Camarón con pulpo y Chicharrón Ruso Blanco.. \n" +
                    "\n" +
                    "Fundado por Josué Morales Hernández ."},
            {"Nieves \nEl More","Plaza Principal s/n,\nDolores Hidalgo, Gto., 37800"," Comezarón con su gran popularidad desde el año 1943. \n" +
                    "\n" +
                    "Los sabores más comunes son: Vainilla, Nuez, Limón, Zapote.\n" +
                    "\n" +
                    "Los sabores más exóticos son Tequila, "},
            {"Nieves y Helados \n El volcán","Plaza Principal, Centro,\nDolores Hidalgo, Gto., 37800","Nieves desde 1962.\n" +
                    "\n" +
                    "Los sabores más comunes son: Galleta, Cajeta, Borracha, Limón.\n" +
                    "\n" +
                    "Cuentán con Sabores exóticos como lo son: Gansito, Tequila, Cerveza."},
    };
*/
    int[] dataImg = {R.drawable.snow2,R.drawable.snow3,R.drawable.snow4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_church);

        getData();

        list = findViewById(R.id.lv_list);

        list.setAdapter(new AdapterListElement(this, data, dataImg));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent detailViewer = new Intent(view.getContext(),SnowDetail.class);
                detailViewer.putExtra("TIT",data[i][0]);
                detailViewer.putExtra("DET",data[i][2]);
                startActivity(detailViewer);
            }
        });
    }

    private void getData(){
        data = new String[][] {
                {getString(R.string.title_snow_one), getString(R.string.direction_snow_one), getString(R.string.description_snow_one)},
                {getString(R.string.title_snow_two),getString(R.string.direction_snow_two),getString(R.string.description_snow_two)},
                {getString(R.string.title_snow_three),getString(R.string.direction_snow_three),getString(R.string.description_snow_three)},
        };
    }
}
