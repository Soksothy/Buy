package com.example.buy;

public class Customer {

    private String id;
    private String name;
    private String type;
    private String price;
    private String status;

    public Customer(String id,String name, String type,String price, String status) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String Status) {
        this.status = status;
    }
}