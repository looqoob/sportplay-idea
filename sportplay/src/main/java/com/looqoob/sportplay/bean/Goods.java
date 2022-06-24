package com.looqoob.sportplay.bean;

public class Goods {
    private int id;
    private String name;
    private String title;
    private boolean state;
    private String img;
    private int money;
    private int sales;

    public Goods() {
    }

    public Goods(int id, String name, String title, boolean state, String img, int money, int sales) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.state = state;
        this.img = img;
        this.money = money;
        this.sales = sales;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public boolean isState() {
        return state;
    }

    public String getImg() {
        return img;
    }

    public int getMoney() {
        return money;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", state=" + state +
                ", img='" + img + '\'' +
                ", money=" + money + '\'' +
                ", sales=" + sales +
                '}';
    }
}
