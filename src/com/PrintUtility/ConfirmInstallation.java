package com.PrintUtility;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by DELL on 1/29/2018.
 */
public class ConfirmInstallation extends JFrame {
    private JTextArea message1;
    private JPanel panelContent;
    private JButton nextBtn;
    private JButton cancelBtn;
    JFrame frame = new JFrame("Pizza Omore");
    //Container container;
    //FileIOHelper fileIOHelper;
    //private Boolean isConfigured;

    public ConfirmInstallation()   {

        message1.setEditable(false);
        frame.setContentPane(panelContent);
        frame.pack();
        frame.setSize(700, 500);
        frame.setTitle("Pizza Omore");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(false);
            }
        });
        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                takeInputs form = new takeInputs();
                form.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                form.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        Boolean isConfigured;
        FileIOHelper fileIOHelper=new FileIOHelper();
        ResourceProvider resourceProvider= new ResourceProvider();
        try{
            isConfigured= fileIOHelper.chkIfConfigured();

        }catch (IOException ex){
            isConfigured=false;
        }

        if (isConfigured){
            System.out.println("isConfigured : " + isConfigured);
            WelcomeForm form= new WelcomeForm();
            form.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            form.frame.setVisible(true);
        }
        else{
            System.out.println("is not Configured : " + isConfigured);
            ConfirmInstallation form= new ConfirmInstallation();
            form.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            form.frame.setVisible(true);
        }

    }
}
