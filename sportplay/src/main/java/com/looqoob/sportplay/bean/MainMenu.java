package com.looqoob.sportplay.bean;

import java.util.List;

public class MainMenu {
    private int id;
    private String title;
    private String path;
    private String icon;
    private List<SubMenu> sList;

    public MainMenu() {
    }

    public MainMenu(String title, String path, String icon, List<SubMenu> sList) {
        this.title = title;
        this.path = path;
        this.sList = sList;
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPath() {
        return path;
    }

    public List<SubMenu> getsList() {
        return sList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPath(String pash) {
        this.path = pash;
    }

    public void setsList(List<SubMenu> sList) {
        this.sList = sList;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "MainMenu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", path='" + path + '\'' +
                ", icon='" + icon + '\'' +
                ", sList=" + sList +
                '}';
    }
}
