package com.example.aga.listaobrazkow;

/**
 * Created by aga on 21.03.15.
 */
public class Picture {


    private String name;
    private int mark;
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

    public int getMark() {
        return mark;
    }

    public int getIconID() {
        return iconID;
    }
    public String getDescription(){
        return description;
    }
}
