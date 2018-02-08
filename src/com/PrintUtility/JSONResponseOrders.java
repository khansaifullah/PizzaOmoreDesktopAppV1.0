package com.PrintUtility;

/**
 * Created by DELL on 2/7/2018.
 */
public class JSONResponseOrders {

    private String status;
    private String message;
    private Order[] object;

    public JSONResponseOrders(String status, String message, Order[] object) {
        this.status = status;
        this.message = message;
        this.object = object;
    }

    public JSONResponseOrders() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Order[] getObject() {
        return object;
    }

    public void setObject(Order[] object) {
        this.object = object;
    }
}
