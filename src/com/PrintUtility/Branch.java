package com.PrintUtility;

/**
 * Created by DELL on 1/30/2018.
 */
public class Branch {

    private int id;
    private String title;
    private String phone_number_1;

    public Branch() {
    }

    public Branch(int id, String title,  String phone_number_1) {
        this.id = id;
        this.title = title;
        this.phone_number_1=phone_number_1;

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone_number_1() {
        return phone_number_1;
    }

    public void setPhone_number_1(String phone_number_1) {
        this.phone_number_1 = phone_number_1;
    }
}
