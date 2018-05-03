package mx.com.dloza.descendent;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ChurchActivity extends AppCompatActivity {

    ListView list;
    String [][] data;
    int[] dataImg = {R.drawable.image_1,R.drawable.image_2,R.drawable.image_3,R.drawable.image_4,R.drawable.image_5};


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
                Intent detailViewer = new Intent(view.getContext(),ChurchDetail.class);
                detailViewer.putExtra("TIT",data[i][0]);
                detailViewer.putExtra("DET",data[i][2]);
                startActivity(detailViewer);
            }
        });
    }

    private void getData(){
        data = new String[][]{
                {getString(R.string.title_church_one),getString(R.string.detail_church_one),getString(R.string.info_church_one)},

                {getString(R.string.title_church_two),getString(R.string.detail_church_two),getString(R.string.info_church_two)},

                {getString(R.string.title_church_three),getString(R.string.detail_church_three),getString(R.string.info_church_three)},

                {getString(R.string.title_church_four),getString(R.string.detail_church_four),getString(R.string.info_church_four)},

                {getString(R.string.title_church_five),getString(R.string.detail_church_five),getString(R.string.info_church_five)},
        };
    }
}
