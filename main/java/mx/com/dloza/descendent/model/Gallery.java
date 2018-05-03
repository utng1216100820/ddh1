package mx.com.dloza.descendent.model;

/**
 * Created by Jairo on 10/03/2018.
 */

public class Gallery {
    public String title, summary, url;

    public Gallery(String title, String url, String summary){
        this.title=title;
        this.url=url;
        this.summary=summary;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getUrl() {
        return url;
    }
}
