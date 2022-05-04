package kg.geektech.newsapp42.models;

import android.net.Uri;

import java.io.Serializable;

public class Avatar implements Serializable {
    private String text;
    private Uri uri;

    public Avatar(String text, Uri uri) {
        this.text = text;
        this.uri = uri;
    }

    public Avatar(Uri uri) {
        this.uri = uri;
    }

    public Avatar() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }
}
