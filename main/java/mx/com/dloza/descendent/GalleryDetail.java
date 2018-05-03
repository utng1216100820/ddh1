package mx.com.dloza.descendent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

import mx.com.dloza.descendent.common.Common;
import mx.com.dloza.descendent.model.Gallery;

public class GalleryDetail extends AppCompatActivity {

    KenBurnsView galleryImage;
    TextView galleryTitle, gallerySummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_detail);

        galleryImage = findViewById(R.id.gallery_image);
        galleryTitle = findViewById(R.id.gallery_title);
        gallerySummary = findViewById(R.id.gallery_summary);

        if(getIntent() != null){
            int galleryIndex = getIntent().getIntExtra("gallery_index",-1);
            if (galleryIndex != -1){
                loadGalleryDetail(galleryIndex);
            }
        }
    }

    private void loadGalleryDetail(int index) {
        Gallery gallery = Common.galleryList.get(index);

        //Load image
        Picasso.with(getBaseContext()).load(gallery.getUrl()).into(galleryImage);
        galleryTitle.setText(gallery.getGalleryTitle());
        gallerySummary.setText(gallery.getGallerySummary());
    }
}
