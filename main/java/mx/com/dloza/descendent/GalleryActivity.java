package mx.com.dloza.descendent;

import android.content.Intent;
import android.content.pm.FeatureGroupInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.squareup.picasso.Picasso;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;
import mx.com.dloza.descendent.adapter.GalleryAdapter;
import mx.com.dloza.descendent.common.Common;
import mx.com.dloza.descendent.model.Gallery;

public class GalleryActivity extends AppCompatActivity {

    FeatureCoverFlow coverFlow;
    GalleryAdapter galleryAdapter;
    TextSwitcher mTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        //create data first
        initData();
        galleryAdapter = new GalleryAdapter(Common.galleryList,this);
        coverFlow = findViewById(R.id.cover_flow);
        mTitle = findViewById(R.id.m_title);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(GalleryActivity.this);
                TextView text = (TextView)inflater.inflate(R.layout.layout_title,null);
                return text;
            }
        });
        coverFlow.setAdapter(galleryAdapter);
        coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(Common.galleryList.get(position).getTitle());
            }

            @Override
            public void onScrolling() {

            }
        });
        coverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(GalleryActivity.this,GalleryDetail.class);
                intent.putExtra("gallery_index",i);
                startActivity(intent);
            }
        });
    }

    private void initData() {

        Common.galleryList.add(new Gallery(getString(R.string.title_gallery_one), "https://78.media.tumblr.com/8a98a6cc0e389ad913a4bf580155efc1/tumblr_p7eqiipDIt1x8mzzro1_1280.jpg",
                getString(R.string.summary_gallery_one)));

        Common.galleryList.add(new Gallery(getString(R.string.title_gallery_two), "https://78.media.tumblr.com/ff6e465fafed8725272c886b484fa35a/tumblr_p5ed46QcHq1x8mzzro1_1280.jpg",
                getString(R.string.summary_gallery_two)));

        Common.galleryList.add(new Gallery(getString(R.string.title_gallery_three), "https://78.media.tumblr.com/f4c276647e206839a7cd26ff178abb74/tumblr_p5ed46QcHq1x8mzzro2_1280.jpg",
                getString(R.string.summary_gallery_three)));

        Common.galleryList.add(new Gallery(getString(R.string.title_gallery_four), "https://78.media.tumblr.com/f447b41667bc3906f036f1238edf7f93/tumblr_p7eqiipDIt1x8mzzro3_1280.jpg",
                getString(R.string.summary_gallery_four)));

        Common.galleryList.add(new Gallery(getString(R.string.title_gallery_five), "https://78.media.tumblr.com/1dec75e4b197b84bf2c7615179124a2e/tumblr_p7eqiipDIt1x8mzzro2_500.jpg",
                getString(R.string.summary_gallery_five)));


    }
}
