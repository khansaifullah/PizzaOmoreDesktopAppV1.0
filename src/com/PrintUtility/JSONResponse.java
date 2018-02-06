package com.PrintUtility;

/**
 * Created by DELL on 1/30/2018.
 */
public class JSONResponse  {

    private String status;
    private String message;
    private Object[] objects;

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

    public Object[] getObjects() {
        return objects;
    }

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }


}
