package com.PrintUtility;

/**
 * Created by DELL on 1/26/2018.
 */
public class OrderItem {

    private int id;
    private String name;
    private int price;
    private int quantity;


    public OrderItem(int _id,String _name,int _price ,int _quantity){
        id=_id;
        name=_name;
        price=_price;
        quantity=_quantity;
    }
    @Override
     public String  toString(){
    return name+"   quantity "+quantity+"   price "+price ;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
