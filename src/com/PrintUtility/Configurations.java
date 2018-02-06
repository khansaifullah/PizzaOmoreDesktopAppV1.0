package com.PrintUtility;

import java.io.IOException;

/**
 * Created by DELL on 1/31/2018.
 */
public class Configurations {

    public  String printConfiguration;
    private FileIOHelper fileIOHelper;
    private String branchId;


    public  Configurations(){
        fileIOHelper= new FileIOHelper();

    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
        try {
            fileIOHelper.writeData(branchId);
        }
        catch (IOException e){
            System.out.print("Exception Occurred at setPrintConfiguration"+ e);
        }

    }

    public String getPrintConfiguration() {
        return printConfiguration;
    }


    public  void setPrintConfiguration(String configuration) {

        try {
            fileIOHelper.writeData(configuration);
        }
        catch (IOException e){
            System.out.print("Exception Occurred at setPrintConfiguration"+ e);
        }

        this.printConfiguration = configuration;
    }

}
