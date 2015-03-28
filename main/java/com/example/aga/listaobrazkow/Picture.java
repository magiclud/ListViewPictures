package com.example.aga.listaobrazkow;

import java.io.Serializable;

/**
 * Created by aga on 21.03.15.
 */

public class Picture implements Serializable {


    private String name;
    private float mark;
    private int iconID;
    private String description;
    private boolean fromResource;
    String path;

    public Picture(String name, int iconID,String description) {
        this.name = name;
        this.mark = 0;
        this.iconID = iconID;
        this.description = description;
        this.fromResource = false;
        this.path = null;
    }
    public Picture(String name,String description, String path) {
        this.name = name;
        this.mark = 0;
        this.iconID = -1;
        this.description = description;
        this.fromResource = true;
        this.path = path;
    }

    public String getName() {
        return name;
    }
    public float getMark() {
        return mark;
    }
    public int getIconID() {
        return iconID;
    }
    public String getDescription(){
        return description;
    }
    public boolean getFromResource(){ return  fromResource;}
    public String getPath(){
        return path;
    }
    public void setMark(float mark){
        this.mark = mark;
    }
    public void setFromResource(boolean fromResource){
        this.fromResource = fromResource;
    }
}
