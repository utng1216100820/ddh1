package mx.com.dloza.descendent.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import mx.com.dloza.descendent.R;
import mx.com.dloza.descendent.model.DoloresGallery;
import mx.com.dloza.descendent.model.Gallery;

/**
 * Created by Jairo on 10/03/2018.
 */

public class DoloresGalleryAdapter extends BaseAdapter {
    List<DoloresGallery> doloresGalleryList;
    Context context;

    public DoloresGalleryAdapter(List<DoloresGallery> doloresGalleryList, Context context){
        this.context=context;
        this.doloresGalleryList=doloresGalleryList;
    }

    @Override
    public int getCount() {
        return doloresGalleryList.size();
    }

    @Override
    public Object getItem(int i) {
        return doloresGalleryList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = view;
        if (rootView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View itemView = inflater.inflate(R.layout.layout_item, null);
            TextView name = itemView.findViewById(R.id.label);
            ImageView imageView = itemView.findViewById(R.id.image);

            Picasso.with(context).load(doloresGalleryList.get(i).getUrl()).into(imageView);
            name.setText(doloresGalleryList.get(i).getTitle());
            return itemView;
        }
        return rootView;
    }
}
