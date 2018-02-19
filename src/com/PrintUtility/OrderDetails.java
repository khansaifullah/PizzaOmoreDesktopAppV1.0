package com.PrintUtility;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by DELL on 2/14/2018.
 */
public class OrderDetails extends JFrame {
    private JPanel panel1;
    private JSplitPane jSplitPane;
    private JButton REQTIMEButton;
    private JButton a45MINButton;
    private JButton a60MINButton;
    private JButton a75MINButton;
    private JButton a90MINButton;
    private JButton accpetBtn;
    private JButton rejectBtn;
    private JButton NODRIVERButton;
    private JButton NOFOODButton;
    private JButton TOOBUSYButton;
    private JButton CLOSEButton;
    private JButton OTHERButton;
    private JTextArea orderItemList;
    private JTextArea orderTimeDetails;
    private JButton backToOrdersListButton;
    //private JEditorPane editorPane1;
    private JPanel orderDetailsPanel;
    private JPanel ordersActionPanel;
    JFrame frame = new JFrame("Pizza Omore");
    Border border;
    //private WelcomeForm welcomeForm;


    public  OrderDetails(){

        //this.welcomeForm=welcomeForm;
        //editorPane1= new JEditorPane("text/html", "");

        orderTimeDetails.append("Order Placed At  :\n");
        orderTimeDetails.append("Order Type           :\n");
        orderTimeDetails.append("Requested For    :\n");

        border = BorderFactory.createLineBorder(Color.BLACK,3);
        orderTimeDetails.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        //orderTimeDetails.setText("Order Placed At:17:35" +"/n"+ "Order Type:  Delivery Requested for: ASAP (Around 45 Minutes)");

        orderItemList.append("Hello\n");


        frame.setContentPane(panel1);
        //frame.setSize(900, 700);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setTitle("Pizza Omore");
        frame.setLocationRelativeTo(null);
        try {
            frame.setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon.png")));
        }catch (Exception ex){

        }
         restoreDefaults();
        backToOrdersListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WelcomeForm form =  new WelcomeForm();
                form.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                form.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                form.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
    }

    private void restoreDefaults() {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                jSplitPane.setSize(frame.getSize());
                System.out.println("Total Width :" + jSplitPane.getSize().width);
                System.out.println("Total height :" + jSplitPane.getSize().height);
                jSplitPane.setDividerLocation(jSplitPane.getSize().width /2 );
                //mainSplittedPane.setDividerLocation(mainSplittedPane.getSize().width /2);
            }
        });
    }
    public static void main(String[] args) {


        OrderDetails orderDetails= new OrderDetails();
        orderDetails.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        orderDetails.frame.setVisible(true);
    }
}
