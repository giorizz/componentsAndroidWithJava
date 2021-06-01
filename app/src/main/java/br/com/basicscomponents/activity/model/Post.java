package br.com.basicscomponents.activity.model;

import android.widget.ImageView;

public class Post {

    private String name;
    private String postage;
    private int image;

    public Post(){}

    public Post(String name, String postage, int image) {
        this.name = name;
        this.postage = postage;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostage() {
        return postage;
    }

    public void setPostage(String postage) {
        this.postage = postage;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
