package com.PrintUtility;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by DELL on 1/29/2018.
 */
public class takeInputs extends JFrame {

    HttpHelper httpHelper;
    JFrame frame = new JFrame("Pizza Omore");
    private String printType;
    private JPanel contentPanel;
    private JButton nxtBtn;
    private JButton cancelBtn;
    private JComboBox branchesList;
    private JRadioButton manualRadioBtn;
    private JRadioButton autoRadioBtn;
    private Configurations configurations;
    ButtonGroup group;

    public takeInputs(){


        configurations= new Configurations();
        // Populate Branches in Drop Down Menu
        printType=null;
        setBranches();
        branchesList.setVisible(true);

        //Radio Button Group
        group = new ButtonGroup();
        group.add(manualRadioBtn);
        group.add(autoRadioBtn);

        frame.setContentPane(contentPanel);
        frame.pack();
        frame.setSize(700, 500);
        frame.setTitle("Pizza Omore");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        nxtBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


                System.out.println("Print Configuration : " + printType + " Branch Name  : " + branchesList.getSelectedItem());
                configurations.setPrintConfiguration(printType);
                configurations.setBranchId(branchesList.getSelectedItem().toString());

                WelcomeForm form = new WelcomeForm();
                form.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                form.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // CloseFrame();
                frame.setVisible(false);
            }
        });

        autoRadioBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                printType="Auto";
                System.out.print("Auto Clicked");
            }
        });
        manualRadioBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printType="Manual";
                System.out.print("Manual Clicked");
            }
        });

    }

    public void setBranches(){
        //setting Branches

        String [] branchNames =  ResourceProvider.branchNames;
        if(branchNames!=null){
            for(int i =0;i<branchNames.length;i++){
                branchesList.addItem(branchNames[i]);
            }
        }
        else{
            System.out.print("No Branch Names Found");
        }

    }




    public static void main(String[] args) {


        takeInputs form= new takeInputs();
        form.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}



