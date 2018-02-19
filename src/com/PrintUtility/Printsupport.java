package com.PrintUtility;

/**
 * Created by DELL on 1/23/2018.
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author All Open source developers
 * @version 1.0.0.0
 * @since 2014/12/22
 */
/*This Printsupport java class was implemented to get printout.
* This class was specially designed to print a Jtable content to a paper.
* Specially this class formated to print 7cm width paper.
* Generally for pos thermel printer.
* Illustration of basic invoice is in this code.
 */

public class Printsupport  {

    static JTable itemsTable;
    public static  int total_item_count=0;
    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss a";
    public  static String title[] = new String[] {"Qty","Item Description","Price"};
    public String customerName;
    public String customerAddress;
    public String customerCity;
    public String customerPostCode;
    public String customerPhoneNo;


    public  void setItems(Object[][] printitem, String name, String address, String city, String postCode, String phoneNo){
        //Setting Print Data
        Object data[][]=printitem;
        this.customerName=name;
        this.customerAddress=address;
        this.customerCity=city;
        this.customerPostCode=postCode;
        this.customerPhoneNo=phoneNo;

        DefaultTableModel model = new DefaultTableModel();
        //assume jtable has 4 columns.
        model.addColumn(title[0]);
        model.addColumn(title[1]);
        model.addColumn(title[2]);
       // model.addColumn(title[3]);


        int rowcount=printitem.length;

        addtomodel(model, data, rowcount);


        itemsTable = new JTable(model);
    }

    public static void addtomodel(DefaultTableModel model,Object [][]data,int rowcount){
        int count=0;
        while(count < rowcount){
            model.addRow(data[count]);
            count++;
        }
        if(model.getRowCount()!=rowcount)
            addtomodel(model, data, rowcount);

        System.out.println("Check Passed.");
    }

    public Object[][] getTableData (JTable table) {
        int itemcount=table.getRowCount();
        System.out.println("Order Item Count:"+itemcount);

        TableModel dtm = table.getModel();
        //DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        System.out.println("After Parse");
        int nRow = dtm.getRowCount(), nCol =dtm.getColumnCount();
        Object[][] tableData = new Object[nRow][nCol];
        if(itemcount==nRow)                                        //check is there any data loss.
        {
            for (int i = 0 ; i < nRow ; i++){
                for (int j = 0 ; j < nCol ; j++){
                    tableData[i][j] = dtm.getValueAt(i,j);           //pass data into object array.
                }}
            if(tableData.length!=itemcount){                      //check for data losses in object array
                getTableData(table);                                  //recursively call method back to collect data
            }
            System.out.println("Data check passed");
        }
        else{
            //collecting data again because of data loss.
            getTableData(table);
        }
        return tableData;                                       //return object array with data.
    }

    public static PageFormat getPageFormat(PrinterJob pj){
        PageFormat pf = pj.defaultPage();
        Paper paper = pf.getPaper();

        double middleHeight =total_item_count*1.0;  //dynamic----->change with the row count of jtable
        double headerHeight = 5.0;                  //fixed----->but can be mod
        double footerHeight = 5.0;                  //fixed----->but can be mod

        double width = convert_CM_To_PPI(7);      //printer know only point per inch.default value is 72ppi
        double height = convert_CM_To_PPI(headerHeight+middleHeight+footerHeight);
        paper.setSize(width, height);
        paper.setImageableArea(
                convert_CM_To_PPI(0.25),
                convert_CM_To_PPI(0.5),
                width - convert_CM_To_PPI(0.35),
                height - convert_CM_To_PPI(1));   //define boarder size    after that print area width is about 180 points

        pf.setOrientation(PageFormat.PORTRAIT);           //select orientation portrait or landscape but for this time portrait
        pf.setPaper(paper);

        return pf;
    }


    protected static double convert_CM_To_PPI(double cm) {
        return toPPI(cm * 0.393600787);
    }

    protected static double toPPI(double inch) {
        return inch * 72d;
    }

    public static String now() {
    //get current date and time as a String output
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime());

    }

    public static class MyPrintable implements Printable {
        @Override
        public int print(Graphics graphics, PageFormat pageFormat,
                         int pageIndex) throws PrinterException {
            int result = NO_SUCH_PAGE;
            if (pageIndex == 0) {
                Graphics2D g2d = (Graphics2D) graphics;

                double width = pageFormat.getImageableWidth();
                double height = pageFormat.getImageableHeight();
                g2d.translate((int) pageFormat.getImageableX(),(int) pageFormat.getImageableY());
                Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{2}, 0);

                g2d.setStroke(dashed);

                //Font font = new Font("Monospaced",Font.PLAIN,7);
                Font font = new Font("Arial",Font.BOLD,15) ;                  //changed font size For Pizza Omore Heading
                g2d.setFont(font);


                try {
	        	/*
                         * Draw Image*
                           assume that printing reciept has logo on top
                         * that logo com.PrintUtility.image is in .gif format .png also support
                         * com.PrintUtility.image resolution is width 100px and height 50px
                         * com.PrintUtility.image located in root--->com.PrintUtility.image folder
                         */
                    int x=100 ;                                        //print start at 100 on x axies
                    int y=10;                                          //print start at 10 on y axies
                    int imagewidth=100;
                    int imageheight=50;
                   // BufferedImage read = ImageIO.read(getClass().getResource("com.PrintUtility.image/logo.png"));

                    //g2d.drawImage(new BufferedImage(1,1,1) ,x,y,imagewidth,imageheight,null);         //draw com.PrintUtility.image

                    //g2d.drawImage(read,x,y,imagewidth,imageheight,null);         //draw com.PrintUtility.image
                   // g2d.drawLine(10, y+60, 180, y+60);                          //draw line
                    // IF Buffered Image is used Then use IOException
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try{
	        /*Draw Header*/
                    int y=20;
                    int nextLine=10;
                    //int y=80
                    g2d.drawString("PIZZA OMORE", 30,y);
                    font = new Font("Arial",Font.PLAIN,10); // Change Font
                    g2d.setFont(font);
                    g2d.drawString("Branch Name", 50,y+10);     //shift a line by adding 10 to y value
                    //g2d.drawString("03333443665", 40,y);
                   // g2d.drawString("Branch Name", 50,y+10);                 //shift a line by adding 10 to y value
                   // g2d.drawString(now(), 10, y+20);                                //print date
                    g2d.drawString("tel:03347773337", 40, y + 20);
                    g2d.drawLine(10, y + 30, 180, y + 30);
                    font = new Font("Arial",Font.BOLD,12); // Change Font
                    g2d.setFont(font);
                    g2d.drawString("Delivery", 50, y + 40);
                    font = new Font("Arial",Font.BOLD,11); // Change Font
                    g2d.setFont(font);
                    g2d.drawString("Due 09-Feb At ASAP 18:00", 20, y + 50);
                    g2d.drawString("Order Number: 0010", 20, y + 60);
                    font = new Font("Arial",Font.PLAIN,10); // Change Font
                    g2d.setFont(font);
                    g2d.drawLine(10, y + 70, 180, y + 70);
                    g2d.drawString("Notes:", 10, y + 80);
                    font = new Font("Arial",Font.BOLD,10); // Change Font
                    g2d.setFont(font);
                    g2d.drawString("Some Notice Here...", 10, y + 90);
                    g2d.drawString("Continued...", 10, y + 100);
                    //g2d.drawString("Continued...", 10, y + 110);
                    font = new Font("Arial",Font.PLAIN,10); // Change Font
                    g2d.setFont(font);
                    g2d.drawLine(10, y + 120, 180, y + 120);

                    //g2d.drawString("Order No.: 00001", 10, y+30);
                   // g2d.drawLine(10, y + 60, 180, y + 60);
                   // g2d.drawString("Delivery Address", 40,y);
	              /*Draw Colums*/
                   // g2d.drawLine(10, y + 40, 180, y + 40);

                    y=y+100;
                    g2d.drawString(title[0], 10 ,y+50);
                    g2d.drawString(title[1], 50 ,y+50);
                    g2d.drawString(title[2], 150 ,y+50);
                   // g2d.drawString(title[3], 150 ,y+50);
                    //g2d.drawLine(10, y+60, 180, y+60);

                    int cH = 0;
                    TableModel mod = itemsTable.getModel();

                    for(int i = 0;i < mod.getRowCount() ; i++){
	                	/*Assume that all parameters are in string data type for this situation
                                 * All other premetive data types are accepted.
                                */
                        String quantity = mod.getValueAt(i, 0).toString();
                        String itemname = mod.getValueAt(i, 1).toString();
                        String price = mod.getValueAt(i, 2).toString();
                        //String quantity = mod.getValueAt(i, 3).toString();

                        cH = (y+70) + (10*i);                             //shifting drawing line

                        g2d.drawString(quantity, 10, cH);
                        g2d.drawString(itemname,50, cH);
                        g2d.drawString(price , 150, cH);
                      //  g2d.drawString(quantity , 150, cH);

                    }

                    g2d.drawLine(10, cH+10, 180, cH + 10);
                    font = new Font("Arial",Font.BOLD,13) ;                  //changed font size
                    g2d.setFont(font);
                    g2d.drawString("ORDER NOT PAID", 40, cH + 30);
                    font = new Font("Arial",Font.PLAIN,10); // Change Font
                    g2d.setFont(font);
                    g2d.drawLine(10, cH + 40, 180, cH + 40);
                    g2d.drawString("Customer Details :", 0, cH + 50);

                    //end of the reciept
                }
                catch(Exception r){
                    r.printStackTrace();
                }

                result = PAGE_EXISTS;
            }
            return result;
        }
    }

}
/*
 ################# THIS IS HOW TO USE THIS CLASS #######################

 Printsupport ps=new Printsupport();
 Object printitem [][]=ps.getTableData(jTable);
 ps.setItems(printitem);

 PrinterJob pj = PrinterJob.getPrinterJob();
 pj.setPrintable(new MyPrintable(),ps.getPageFormat(pj));
       try {
            pj.print();

            }
        catch (PrinterException ex) {
                ex.printStackTrace();
            }
 ################## JOIN TO SHARE KNOWLADGE ###########################

 */
