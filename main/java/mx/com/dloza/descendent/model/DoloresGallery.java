package mx.com.dloza.descendent.model;

/**
 * Created by Jairo on 10/03/2018.
 */

public class DoloresGallery {
    public String title, url;

    public DoloresGallery(String title, String url){
        this.title=title;
        this.url=url;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
