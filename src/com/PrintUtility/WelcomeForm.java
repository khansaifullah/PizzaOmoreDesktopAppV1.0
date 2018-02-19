package com.PrintUtility;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.*;
import java.io.InputStream;

/**
 * Created by DELL on 1/23/2018.
 */
//ac043ce7ab3374eb4ed58354a6b2c3de
public class WelcomeForm extends JFrame {

    private JButton chkOrder;
    private JPanel WelcomePanel;
    private JPanel orderDetailsPanel;
    private JTabbedPane tabbedPane1;
    private JScrollPane scrollPane;
    private JButton printBtn;
    private JButton SettingBtn;
    private JLabel loadingLabel;
    JFrame frame = new JFrame("Pizza Omore");
    public HttpHelper httpHelper;
    public  Printsupport ps;
    JList pendingOrdersJList;
    DefaultListModel<Order> orderDefaultListModel;
    Order [] ordersList;
    SoundUtils soundUtils;

    public WelcomeForm() {
        loadingLabel.setVisible(true);
       // tabbedPane1.add(loadingLabel);
        soundUtils=new SoundUtils();
        httpHelper=new HttpHelper();
        orderDefaultListModel = new DefaultListModel();
        pendingOrdersJList= new JList<Order>(orderDefaultListModel);
        pendingOrdersJList.setFont(new Font("Sans Serif", Font.BOLD, 17));
        pendingOrdersJList.setFixedCellHeight(50);
        pendingOrdersJList.setFixedCellWidth(1200);

        new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Worken hard or hardly worken...
                try {
                    ordersList = httpHelper.getPendingOrders("7");
                    if (ordersList.length > 0) {
                        System.out.println("Pending Order Count  :" + ordersList.length);
                        orderDefaultListModel.clear();


                        for (int i = 0; i < ordersList.length; i++) {
                            System.out.println("in Loop");
                            orderDefaultListModel.addElement(ordersList[i]);
                            //ListCellRenderer renderer = pendingOrdersJList.getCellRenderer();
                            // pendingOrdersJList = getSelectedList();
                            pendingOrdersJList.setCellRenderer(new OrdersCellRenderer());
                        }
                        // pendingOrdersJList= new JList<Order>(orderDefaultListModel);
                        // jp1.add(pendingOrdersJList);
                        // scrollPane = new JScrollPane(ordersJList);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Please Check Your Internet Connection! ");
                    System.out.println("Exception Occurred While Fetching Pending Orders " + ex);
                }


                //Thread.sleep(1000);
                return null;
            }

            @Override
            protected void done() {
                loadingLabel.setVisible(false);
            }
        }.execute();


        frame.setContentPane(WelcomePanel);
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        JLabel label1 = new JLabel();
        //label1.setText("Pending Orders List");
        JLabel label2 = new JLabel();
        label2.setText("In Process Orders List");

        //jp1.add(new JLabel("Name", JLabel.CENTER));
        //jp1.add(new JLabel("Time",JLabel.LEFT));
        jp1.add(loadingLabel);

        // constructs the table
//        String[] columnNames = new String[] {"Title", "Author", "Publisher", "Published Date", "Pages", "Rating"};
//        String[][] rowData = new String[][] {
//                {"Effective Java", "Joshua Bloch", "Addision-Wesley", "May 08th 2008", "346", "5"},
//                {"Thinking in Java", "Bruce Eckel", "Prentice Hall", "Feb 26th 2006", "1150", "4"},
//                {"Head First Java", "Kathy Sierra & Bert Bates", "O'Reilly Media", "Feb 09th 2005", "688", "4.5"},
//        };
//
//        JTable table = new JTable(rowData, columnNames);
//        table.getTableHeader().setDefaultRenderer(new SimpleHeaderRenderer());
//
//

        jp1.add(pendingOrdersJList);
        //jp1.setPreferredSize(new Dimension(500, 50));
        jp2.add(label2);

        tabbedPane1.addTab("<html><h2 style='padding:3px; color:#ba1610; '>Pending Orders</h2></html>", jp1);
        tabbedPane1.addTab("<html><h2 style='padding:3px; color:#ba1610'>In Process</h2></html>", jp2);
       // reader=new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("config1.txt")));

        try{
            InputStream is = getClass().getClassLoader().getResourceAsStream("PizaomoreIcon.png");
            ImageIO.read(is);
            //reader=new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("config1.txt")));
            //getClass().getResource();
            frame.setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon.png")));
            //frame.setIconImage(Toolkit.getDefaultToolkit().getImage());
            } catch(Exception ex){
            System.out.println("Exception While Loading Icon Image " + ex);
        }

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

                try {
                    ordersList = httpHelper.getPendingOrders("7");
                    if (ordersList.length > 0) {
                        System.out.println("Pending Order Count  :" + ordersList.length);
                        orderDefaultListModel.clear();


                        for (int i = 0; i < ordersList.length; i++) {
                            System.out.println("in Loop");
                            orderDefaultListModel.addElement(ordersList[i]);
                            //ListCellRenderer renderer = pendingOrdersJList.getCellRenderer();
                            // pendingOrdersJList = getSelectedList();
                            pendingOrdersJList.setCellRenderer(new OrdersCellRenderer());
                        }
                        // pendingOrdersJList= new JList<Order>(orderDefaultListModel);
                        // jp1.add(pendingOrdersJList);
                        // scrollPane = new JScrollPane(ordersJList);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Please Check Your Internet Connection! ");
                    System.out.println("Exception Occurred While Fetching Pending Orders " + ex);
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


               // Check Selected List Items & Print It
                int selected[] = pendingOrdersJList.getSelectedIndices();
                String dataToPrint[][];
                System.out.println("Selected Elements:  "+selected.length);

                for (int i = 0; i < selected.length; i++) {

                    Order order = (Order) pendingOrdersJList.getModel().getElementAt(selected[i]);
                    System.out.println(" Customer Name: " + order.getCustomer_name());
                    OrderItem[] orderItems = order.getItems();
                    if (order!=null){
                        dataToPrint=new String[orderItems.length][3];
                        for (int j = 0; j < orderItems.length; j++) {
                            System.out.println("  " + orderItems[j].getItem_name() + " " + orderItems[j].getItem_price() + " " + orderItems[j].getQty());
                            dataToPrint[j][0]=orderItems[j].getQty()+"";
                            dataToPrint[j][1]=orderItems[j].getItem_name();
                            dataToPrint[j][2]=orderItems[j].getItem_price()+"";
                        }
                    }
                    else {

                        System.out.print("No order Item Found");
                        dataToPrint=new String[0][0];

                    }

                    /****************/
                    //Print Receipt
                    //Dummy Data for printing
//                    String data[][] = {{"1", "Pizza", "11"},
//                            {"12", "Zinger", "22"},
//                            {"13", "Roll ", "33"},
//                            {"14", "Coca Cola", "22"},
//                            {"15", "Cheese", "33"}};


                    String column[] = {"Qty", "Item Description", "Price"};

                    JTable jt = new JTable(dataToPrint, column);
                    // jt.setBounds(30,40,200,300);

                    Book book = new Book();//java.awt.print.Book
                    ps = new Printsupport();
                    Object printitem[][] = ps.getTableData(jt);
                    // Set Items Attribute printitem , customerName,  address,  city,  postCode,  phoneNo
                    ps.setItems(printitem, order.getCustomer_name(), order.getAddress(), order.getCity(), order.getPost_code(), order.getCustomer_number());

                    //1st finsihes before page ends
                    PrinterJob pj = PrinterJob.getPrinterJob();
                     pj.setPrintable(new Printsupport.MyPrintable(), ps.getPageFormat(pj));

                    // 2nd same as first but Tried to join pages
                    //book.append(new Printsupport.MyPrintable(), ps.getPageFormat(pj));
                    //pj.setPageable(book);

                    //3rd Joins pages but change position of print
//                    PageFormat pf = pj.defaultPage();
//                    Paper paper = pf.getPaper();
//                    pf.setPaper(paper);
//                    pj.setPrintable(new Printsupport.MyPrintable(), pf);


                    try {
                        pj.print();

                    } catch (PrinterException ex) {
                        ex.printStackTrace();
                    }
                    /**************/
                }
            }
        });
        SettingBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                frame.remove(WelcomePanel);
//                orderDetailsPanel=new JPanel();
//                orderDetailsPanel.setLayout(new BorderLayout());
//                orderDetailsPanel.add(new Button("Some Button"));
//                frame.add(orderDetailsPanel);

//                takeInputs form = new takeInputs();
//                form.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                form.frame.setVisible(true);
//                frame.setVisible(false);
            }
        });

        pendingOrdersJList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    OrderDetails orderDetails= new OrderDetails();
                    orderDetails.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    orderDetails.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    orderDetails.frame.setVisible(true);
                    frame.setVisible(false);

                }
            }
        });
    }

    public static void main(String[] args) {


        WelcomeForm welcomeForm= new WelcomeForm();
        welcomeForm.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeForm.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        welcomeForm.frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
