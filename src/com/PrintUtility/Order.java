package com.PrintUtility;

/**
 * Created by DELL on 2/7/2018.
 */
public class Order {

    private int order_id;
    private String address;
    private String city;
    private String post_code;
    private double delivery_charges;
    private double item_price;
    private double order_price;
    private OrderItem [] items;
    private String customer_name;
    private String customer_number;
    private int status;

    public Order(int order_id, String address, String city, String post_code, double delivery_charges, double item_price, double order_price, OrderItem[] items, String customer_name, String customer_number, int status) {
        this.order_id = order_id;
        this.address = address;
        this.city = city;
        this.post_code = post_code;
        this.delivery_charges = delivery_charges;
        this.item_price = item_price;
        this.order_price = order_price;
        this.items = items;
        this.customer_name = customer_name;
        this.customer_number = customer_number;
        this.status = status;
    }

    public Order() {
    }

    public String  toString(){
        return "    Order Details           Order Id  : "+order_id+" Customer Name : "+customer_name;

    }
    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    public double getDelivery_charges() {
        return delivery_charges;
    }

    public void setDelivery_charges(double delivery_charges) {
        this.delivery_charges = delivery_charges;
    }

    public double getItem_price() {
        return item_price;
    }

    public void setItem_price(double item_price) {
        this.item_price = item_price;
    }

    public double getOrder_price() {
        return order_price;
    }

    public void setOrder_price(double order_price) {
        this.order_price = order_price;
    }


    public OrderItem[] getItems() {
        return items;
    }

    public void setItems(OrderItem[] items) {
        this.items = items;
    }


    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_number() {
        return customer_number;
    }

    public void setCustomer_number(String customer_number) {
        this.customer_number = customer_number;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
