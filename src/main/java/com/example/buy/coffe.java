package com.example.buy;

public class coffe {
    private int no;
    private String name;
    private int qty;
    private int price;
    private int cost;
    private String size;

    public coffe(int no, String name, int qty, int price, int cost, String size) {
        this.no = no;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.cost = cost;
        this.size = size;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public int getPrice() {
        return price;
    }

    public int getCost() {
        return cost;
    }

    public String getSize() {
        return size;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
