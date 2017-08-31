/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fns;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author southgate
 */
public class FNS {


    public static void main(String [] args)throws FileNotFoundException, IOException{

		FNS test = new FNS();
        HashSet array = new HashSet();

		File file = new File("/export/home/notes/ds/ulysses.text");
        BufferedReader bufferedReader = null;
        bufferedReader = new BufferedReader(new FileReader(file));
        String inputLine = null;

        try {
            while ((inputLine = bufferedReader.readLine()) != null) {
            String[] words = inputLine.split("\\W+");

                for (int counter = 0; counter < words.length; counter++) {
                    String key = words[counter].toLowerCase(); // remove .toLowerCase for Case Sensitive result.
                    key.replaceAll("([a-z]+)[?:!.,;_-]*", "$1");
                    if(!key.equals("")){

                        if(key.matches("[a-zA-Z]+"))
                            array.add(key);
                 }
            }
            }


	} catch (IOException error) {
        System.out.println("Invalid File");
    }

      
        for(int i =0; i< array.size();i++){
            System.out.println(array.toArray()[i]);
        }


	}
}
