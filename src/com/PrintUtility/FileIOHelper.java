package com.PrintUtility;

import java.io.*;

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
    public static void writeData(String data) throws IOException {

        System.out.println("Writing data in file :"+data);
        File fout = new File("config.txt");
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


    public static Boolean chkIfConfigured() throws IOException {
        BufferedReader reader = null;
        try {
            File file = new File("config.txt");
            reader = new BufferedReader(new FileReader(file));
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
        catch(IOException e){
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
