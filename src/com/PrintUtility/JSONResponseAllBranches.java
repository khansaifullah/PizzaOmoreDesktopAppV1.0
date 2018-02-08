package com.PrintUtility;

/**
 * Created by DELL on 1/30/2018.
 */
public class JSONResponseAllBranches {

    private String status;
    private String message;
    private Branch[] object;


    public Branch[] getObject() {
        return object;
    }

    public void setObject(Branch[] object) {
        this.object = object;
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




}
