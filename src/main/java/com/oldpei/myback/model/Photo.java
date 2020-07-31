package com.oldpei.myback.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class Photo {
    public static Set<Photo> set;

    Date date;
    String type;
    String Name;
    String path;

    public Photo(Date date, String type, String name, String path) {
        this.date = date;
        this.type = type;
        Name = name;
        this.path = path;
    }

    public static Set<Photo> getSet() {
        return set;
    }

    public static void setSet(Set<Photo> set) {
        Photo.set = set;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}