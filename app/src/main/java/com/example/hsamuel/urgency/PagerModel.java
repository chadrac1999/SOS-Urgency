package com.example.hsamuel.urgency;

import android.widget.ImageView;

/**
 * Created by chadrac on 11/28/18.
 */

public class PagerModel {
    String id;
    Integer title;
    String etape;
    Integer description;
    Integer img;

    public PagerModel(String id, Integer title, String etape, Integer description, Integer img){
        this.id = id;
        this.title = title;
        this.etape = etape;
        this.description = description;
        this.img = img;
    }

    public String getId(){

        return id;
    }

    public void setId(String id){

        this.id = id;
    }

    public Integer getTitle(){

        return title;
    }

    public void setTitle(Integer title){

        this.title = title;
    }

    public String getEtape(){

        return etape;
    }

    public  void setEtape(){

        this.etape = etape;
    }

    public Integer getDescription(){

        return description;
    }

    public void setDescription(){

        this.description = description;
    }

    public Integer getImg(){

        return img;
    }

    public void setImg(){

        this.img = img;
    }

}
