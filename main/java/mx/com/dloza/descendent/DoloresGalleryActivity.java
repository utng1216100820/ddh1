package mx.com.dloza.descendent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;
import mx.com.dloza.descendent.adapter.DoloresGalleryAdapter;
import mx.com.dloza.descendent.common.Common;
import mx.com.dloza.descendent.model.DoloresGallery;

public class DoloresGalleryActivity extends AppCompatActivity {
    FeatureCoverFlow coverFlow;
    DoloresGalleryAdapter doloresGalleryAdapter;
    TextSwitcher mTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dolores_gallery);

        //create data first
        initData();
        doloresGalleryAdapter = new DoloresGalleryAdapter(Common.doloresGalleryList,this);
        coverFlow = findViewById(R.id.cover_flow);
        mTitle = findViewById(R.id.m_title);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(DoloresGalleryActivity.this);
                TextView text = (TextView)inflater.inflate(R.layout.layout_title,null);
                return text;
            }
        });
        coverFlow.setAdapter(doloresGalleryAdapter);
        coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(Common.doloresGalleryList.get(position).getTitle());
            }

            @Override
            public void onScrolling() {

            }
        });
    }

    private void initData() {
        //let do same with all gallery you want

        Common.doloresGalleryList.add(new DoloresGallery("Monumento a la Bandera", "https://78.media.tumblr.com/f3abbec755b6713582ed7c502ac639fe/tumblr_p6j1ibh3sJ1x8mzzro2_250.jpg"));

        Common.doloresGalleryList.add(new DoloresGallery("Monumento Niños Héroes", "https://78.media.tumblr.com/a8b71ce8b7aaf6de38eb42c90490e588/tumblr_p6j1ibh3sJ1x8mzzro3_1280.jpg"));

        Common.doloresGalleryList.add(new DoloresGallery("Monumento Miguel Hidalgo y Costilla", "https://78.media.tumblr.com/42985aedf3fc21c43e6a516a549d6e37/tumblr_p6j1ibh3sJ1x8mzzro4_1280.jpg"));

        Common.doloresGalleryList.add(new DoloresGallery("Kiosco Principal", "https://78.media.tumblr.com/da7e8836f6cf6f357f04c4f3536854d4/tumblr_p6j1ibh3sJ1x8mzzro5_1280.jpg"));

        Common.doloresGalleryList.add(new DoloresGallery("Uvas Viñedo Cuna de Tierra", "https://78.media.tumblr.com/3d154181b651a18c557d9535d53f0959/tumblr_p6j1ibh3sJ1x8mzzro6_1280.jpg"));

        Common.doloresGalleryList.add(new DoloresGallery("Casa de Visitas", "https://78.media.tumblr.com/d856479d0c7eb815ddda9a9fd20908e9/tumblr_p6kpfbJ5T41x8mzzro1_1280.jpg"));

        Common.doloresGalleryList.add(new DoloresGallery("Vino Cuna de Tierra", "https://78.media.tumblr.com/f1fd21b2c49c98f677c8e7ea6cb530b2/tumblr_p6j1ibh3sJ1x8mzzro8_1280.jpg"));

        Common.doloresGalleryList.add(new DoloresGallery("Cuna de Tierra", "https://78.media.tumblr.com/9f0ca8dad464d92f5e8e7856d7ecc734/tumblr_p6kqqm7LJJ1x8mzzro1_400.png"));

        Common.doloresGalleryList.add(new DoloresGallery("Vendimia Cuna de Tierra", "https://78.media.tumblr.com/977de0ce89b622787030a180b079ac90/tumblr_p6j1ibh3sJ1x8mzzro10_1280.png"));

        Common.doloresGalleryList.add(new DoloresGallery("Iglesia de los Dolores", "https://78.media.tumblr.com/09e09d7ebbdcaa899ff8d6cbaed31259/tumblr_p6kpfbJ5T41x8mzzro2_1280.jpg"));

        Common.doloresGalleryList.add(new DoloresGallery("Monumento a la Libertad", "https://78.media.tumblr.com/b7b8698a35041c1d96c79de873fb0bb1/tumblr_p6j3mbt0F41x8mzzro1_500.jpg"));

        Common.doloresGalleryList.add(new DoloresGallery("Parador Turistico José Alfredo", "https://78.media.tumblr.com/58e973a07d383a184302ccd34efd5e3b/tumblr_p6j27hJHOC1x8mzzro3_1280.jpg"));

        Common.doloresGalleryList.add(new DoloresGallery("Iglesia de la Saleta", "https://78.media.tumblr.com/6e456b04b9033a55b5c8021662985e57/tumblr_p6kq0zzLNA1x8mzzro1_250.jpg"));

        Common.doloresGalleryList.add(new DoloresGallery("Pintura de la Independencia", "https://78.media.tumblr.com/bd02097622169f8744c052367c50d384/tumblr_p6j27hJHOC1x8mzzro5_1280.jpg"));

        Common.doloresGalleryList.add(new DoloresGallery("Jardín Principal", "https://78.media.tumblr.com/a57f35b37f8d989dca4012abe8121611/tumblr_p6j27hJHOC1x8mzzro6_1280.jpg"));

        Common.doloresGalleryList.add(new DoloresGallery("Tumba José Alfredo", "https://78.media.tumblr.com/b415cb7d0059f444ad3b31e3dae26855/tumblr_p6j27hJHOC1x8mzzro8_1280.jpg"));

    }
}
