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

    public Picture(String name, int mark, int iconID,String description) {
        this.name = name;
        this.mark = mark;
        this.iconID = iconID;
        this.description = description;
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
    public void setMark(float mark){
        this.mark = mark;
    }
}
