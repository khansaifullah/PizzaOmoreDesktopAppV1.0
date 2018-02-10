package com.PrintUtility;

import org.apache.http.client.methods.HttpOptions;

/**
 * Created by DELL on 2/7/2018.
 */
public class ResourceProvider {

    private Branch[] branches;
    private HttpHelper httpHelper;
    public static String [] branchNames;

    public ResourceProvider() {
        httpHelper= new HttpHelper();
        try {
            branches=httpHelper.getBranches();
        }catch (Exception e){
            System.out.println("Exception In Getting Resources : "+e);
        }
        setAllBranchNames();

    }

    public Branch[] getBranches() {
        return branches;
    }

    public void setBranches(Branch[] branches) {
        this.branches = branches;
    }

    public void setAllBranchNames() {
        if (branches!=null){
            branchNames= new String[branches.length];
            for(int i =0; i < branchNames.length;i++){
                branchNames[i]=branches[i].getTitle();
            }
        }
        else {
            branchNames=null;
        }

        //return branchNames;
    }

}
