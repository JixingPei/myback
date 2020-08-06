package com.oldpei.myback.model;

import java.util.Date;
import java.util.Set;

/**
 * @author jixing.pei
 */
public class Photo {
    public static Set<Photo> set;

    String date;
    String type;
    String name;
    String path;

    public Photo(String date, String type, String name, String path) {
        this.date = date;
        this.type = type;
        this.name = name;
        this.path = path;
    }

    public static Set<Photo> getSet() {
        return set;
    }

    public static void setSet(Set<Photo> set) {
        Photo.set = set;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
