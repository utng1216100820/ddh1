package mx.com.dloza.descendent;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Daniel on 07/03/2018.
 */

public class AdapterListElement extends BaseAdapter {

    private static LayoutInflater inflater = null;

    Context context;
    String[][] data;
    int[] dataImg;

    public AdapterListElement(Context context, String[][] data, int[] image){
        this.context = context;
        this.data = data;
        this.dataImg = image;

        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final View v =  inflater.inflate(R.layout.list_element, null);
        TextView txtTitle = v.findViewById(R.id.txt_title);
        TextView txtLocation = v.findViewById(R.id.txt_location);
        ImageView imageView= v.findViewById(R.id.image_View);
        txtTitle.setText(data[i][0]);
        txtLocation.setText(data[i][1]);
        imageView.setImageResource(dataImg[i]);
        imageView.setTag(i);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ImageSight.class);
                intent.putExtra("IMG", dataImg[(Integer)view.getTag()]);
                context.startActivity(intent);
            }
        });
        return v;
    }

    @Override
    public int getCount() {
        return dataImg.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
 }

