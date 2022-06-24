package com.looqoob.sportplay.bean;

public class Sport {
    private int id;
    private String name;
    private String title;
    private String img;

    public Sport() {
    }

    public Sport(String name, String title, String img) {
        this.name = name;
        this.title = title;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    @Override
    public String toString() {
        return "Sport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
