package com.PrintUtility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/**
 * Created by DELL on 1/23/2018.
 */
//ac043ce7ab3374eb4ed58354a6b2c3de
public class WelcomeForm extends JFrame {

    private JButton chkOrder;
    private JPanel WelcomePanel;
    private JTabbedPane tabbedPane1;
    private JScrollPane scrollPane;
    private JButton printBtn;
    private JButton SettingBtn;
    JFrame frame = new JFrame("Pizza Omore");
    public HttpHelper httpHelper;
    public  Printsupport ps;
    JList ordersJList;
    DefaultListModel<Order> orderDefaultListModel;
    Order [] ordersList;
    SoundUtils soundUtils;

    public WelcomeForm() {

        soundUtils=new SoundUtils();
        httpHelper=new HttpHelper();
        orderDefaultListModel = new DefaultListModel();
        //ordersList= new Order[0];
//        System.out.println("Items In Order  :" + ordersList.length);
//        for (int i =0; i<ordersList.length;i++){
//            // orderItemList[i]=new OrderItem(1,"1",1,1);
//            ordersList[i]=new Order();
//            orderDefaultListModel.addElement(ordersList[i]);
//        }
        ordersJList= new JList<Order>(orderDefaultListModel);

//        ordersJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//        ordersJList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        ordersJList.setVisibleRowCount(1);
//        ordersJList.setCellRenderer(new MyCellRenderer());

        scrollPane = new JScrollPane(ordersJList);
        //scrollPane.setPreferredSize(new Dimension(250, 150));
        frame.setContentPane(WelcomePanel);
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        JLabel label1 = new JLabel();
        label1.setText("Pending Orders List");
        JLabel label2 = new JLabel();
        label2.setText("Delivered Orders List");

        jp1.add(label1);
        jp1.add(ordersJList);
        jp2.add(label2);

        tabbedPane1.addTab("<html><h2 style='padding:3px; background-color:#ba1610;color:white; '>Pending Orders</h2></html>", jp1);
        tabbedPane1.addTab("<html><h2 style='padding:3px; background-color:#ba1610;color:white'>Orders Done</h2></html>", jp2);

        frame.setSize(900, 700);
        frame.setTitle("Pizza Omore");
        frame.setLocationRelativeTo(null);

        chkOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                try{
//                    soundUtils.tone(700,1000,50);
//                }catch (Exception ex){
//
//                }

               // Toolkit.getDefaultToolkit().beep();
                //Check Pending Orders
                try{
                    ordersList=httpHelper.getPendingOrders("7");
                    if (ordersList.length>0){
                        System.out.println("Pending Order Count  :" + ordersList.length);
                        orderDefaultListModel.clear();

                        for (int i =0; i<ordersList.length;i++){
                            System.out.println("in Loop");
                                    // orderItemList[i]=new OrderItem(1,"1",1,1);
                                    //ordersList[i]=new Order();
                            orderDefaultListModel.addElement(ordersList[i]);
                        }
                        ordersJList= new JList<Order>(orderDefaultListModel);
                        jp1.add(ordersJList);
                       // scrollPane = new JScrollPane(ordersJList);
                    }
                }
                catch(Exception ex){
                    System.out.println("Exception Occurred While Fetching Pending Orders "+ ex);
                }





/***********************/
                //HTTP GET Call to get Data
//                httpHelper = new HttpHelper();
//                try {
//                    httpHelper.sendGet();
//
//                }catch (Exception ex){
//                    System.out.println("Exception :"+ ex.toString());
//
//                }

/***************************/

/****************/
                //Print Receipt
//                String data[][]={ {"101","Pizza","11","1"},
//                        {"102","Zinger","22","2"},
//                        {"103","Roll ","33","3"},
//                        {"104","Coca Cola","22","2"},
//                        {"105","Cheese","33","3"}};
//
//                String column[]={"id","name","price","qty"};
//
//                JTable jt=new JTable(data,column);
//               // jt.setBounds(30,40,200,300);
//
//                ps=new Printsupport();
//                Object printitem [][]=ps.getTableData(jt);
//                ps.setItems(printitem);
//
//                PrinterJob pj = PrinterJob.getPrinterJob();
//                pj.setPrintable(new Printsupport.MyPrintable(),ps.getPageFormat(pj));
//                try {
//                    pj.printBtn();
//
//                }
//                catch (PrinterException ex) {
//                    ex.printStackTrace();
//                }
          /**************/

            }
        });
        printBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                //Check Selected List Items & Print It
//                int selected[] = ordersJList.getSelectedIndices();
//                System.out.println("Selected Elements:  ");
//
//                for (int i = 0; i < selected.length; i++) {
//                    String element = (String) ordersJList.getModel().getElementAt(
//                            selected[i]);
//                    System.out.println("  " + element);
//                }

/****************/
                //Print Receipt
                String data[][]={ {"101","Pizza","11","1"},
                        {"102","Zinger","22","2"},
                        {"103","Roll ","33","3"},
                        {"104","Coca Cola","22","2"},
                        {"105","Cheese","33","3"}};

                String column[]={"id","name","price","qty"};

                JTable jt=new JTable(data,column);
               // jt.setBounds(30,40,200,300);

                ps=new Printsupport();
                Object printitem [][]=ps.getTableData(jt);
                ps.setItems(printitem);

                PrinterJob pj = PrinterJob.getPrinterJob();
                pj.setPrintable(new Printsupport.MyPrintable(),ps.getPageFormat(pj));
                try {
                    pj.print();

                }
                catch (PrinterException ex) {
                    ex.printStackTrace();
                }
                /**************/


            }
        });
        SettingBtn.addActionListener(new ActionListener() {
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


        WelcomeForm welcomeForm= new WelcomeForm();
        welcomeForm.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeForm.frame.setVisible(true);
    }
}
