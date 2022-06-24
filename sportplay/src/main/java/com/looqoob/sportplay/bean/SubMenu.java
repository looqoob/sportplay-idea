package com.looqoob.sportplay.bean;
//分支导航
public class SubMenu {
    private int id;
    private String title;
    private String path;
    private String icon;

    public SubMenu() {
    }

    public SubMenu(String title, String path, String icon) {
        this.title = title;
        this.path = path;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "SubMenu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", path='" + path + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
