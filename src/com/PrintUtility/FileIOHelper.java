package com.PrintUtility;

import java.io.*;
import java.net.URL;

/**
 * Created by DELL on 1/31/2018.
 */
public class FileIOHelper {
    //    public  void writeUsingOutputStream(String data) {
//        OutputStream os = null;
//        try {
//            //final String dir = System.getProperty("user.dir");
//            os = new FileOutputStream(new File("config.txt"));
//
//            os.write(data.getBytes(), 0, data.length());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally{
//            try {
//                os.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    public  void writeData(String data) throws IOException {

        System.out.println("Writing data in file :"+data);
       // FileOutputStream fos= new FileOutputStream(getClass().("config1.txt"));
        String filePath= System.getProperty("user.dir")+"\\src\\com\\PrintUtility\\config1.txt";
        System.out.println("filePath: "+ filePath);
        File fout = new File(filePath);
        FileOutputStream fos = new FileOutputStream(fout, true);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        bw.write(data);
        bw.newLine();
        bw.close();
    }



    public static void readData(String data) throws IOException {
        BufferedReader reader = null;
    try{
        File file = new File("config.txt");
        reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
    catch(IOException e){
        e.printStackTrace();
    }
    finally{
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


    public  Boolean chkIfConfigured() throws IOException {
        BufferedReader reader = null;
        File file;
        try {

            //ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            //URL url = classLoader.getResource("com/PrintUtility/config1.txt");

         //   file = new File(url.toURI().getPath());

            // file = new File("config.txt");
            reader=new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("config1.txt")));
            //reader = new BufferedReader(new FileReader(file));
            String line=reader.readLine();

            if (line!=null){
                if (line.equals("Auto")||line.equals("Manual")){
                    System.out.println("line: "+line+ " Exists");
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                System.out.println( "Empty/Unconfigured :"+ line);
                return false;
            }
//             if ((line!=null)&&(line!="")) {
//                 System.out.println("line: "+line+ " Exists");
//                 return true;
//            }
//            else {
//                 System.out.println( "Empty/Unconfigured");
//                 return false;
//             }
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
