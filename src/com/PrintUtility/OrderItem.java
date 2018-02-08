package com.PrintUtility;

/**
 * Created by DELL on 1/26/2018.
 */
public class OrderItem {

    //private int id;
    private String item_name;
    private int item_price;
    private int qty;
    public OrderItem(){

    }
    public OrderItem(String item_name, int item_price, int qty) {
        this.item_name = item_name;
        this.item_price = item_price;
        this.qty = qty;
    }

    public String  toString(){
        return "Item name : "+item_name+" item_price : "+item_price;

    }
    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getItem_price() {
        return item_price;
    }

    public void setItem_price(int item_price) {
        this.item_price = item_price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}

