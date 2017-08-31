/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author southgate
 */
public class AirlineRoutes {

    public AirlineRoutes(){
            String [] information = new String[3];
             try {
            BufferedReader br = new BufferedReader(new FileReader("/export/home/notes/ds/airlineroutes.dot"));


      String sCurrentLine;
      sCurrentLine = br.readLine();
      sCurrentLine = br.readLine();
      sCurrentLine = br.readLine();
      sCurrentLine = br.readLine();
      sCurrentLine = br.readLine();
      sCurrentLine = br.readLine();
      sCurrentLine = br.readLine();
      sCurrentLine = br.readLine();
      sCurrentLine = br.readLine();
      sCurrentLine = br.readLine();
      sCurrentLine = br.readLine();
      sCurrentLine = br.readLine();
      sCurrentLine = br.readLine();
      
      sCurrentLine=sCurrentLine.replaceAll("\\s","").replaceAll("\\[", "").replaceAll("\\]","").replaceAll("label", "").replaceAll("--", " ").replaceAll("=", " ").replaceAll(";", "");
      System.out.println(sCurrentLine);
      
      
      
      
      
      }

    catch (IOException e) {
        e.printStackTrace();
    }
    }
     
            
            public static void main(String [] args){
                AirlineRoutes test = new AirlineRoutes();
      
            }
    








}
