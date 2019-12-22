package com.example.a38_buivanquang_food_order;

import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private float cost;
    private int count;

    public Contact(String name, float cost,int count) {
        this.name = name;
        this.cost = cost;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
