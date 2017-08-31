/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author jlsouthgate
 */
public class Task {

    HashMap<String,String []> storage = new HashMap<String,String[]>();
    HashMap<String,String []> storageIndependence = new HashMap<String,String[]>();
    HashMap<String,Double> storageSA = new HashMap<String,Double>();
    HashMap<String,Double> storageAF = new HashMap<String,Double>();


    HashMap<String,String> storageHOS = new HashMap<String,String>();
    @SuppressWarnings("serial")
	HashMap<String,Double> headofStates = new HashMap<String,Double>(){
    	@Override
	    public Double get(Object key) {
	        if(! containsKey(key))
	            return 0.0;
	        return super.get(key);
	    }
  };




    @SuppressWarnings({ "serial", "rawtypes" })
	HashMap<String,HashMap> storageCountry = new HashMap<String,HashMap>(){
		 @SuppressWarnings("unchecked")
		@Override
		    public HashMap<String, Double> get(Object key) {
		        if(! containsKey(key)){
		        	HashMap<String, Double> test = new HashMap<String,Double>();
		            return test;
		        }
		        return super.get(key);
		    }
	 };


  @SuppressWarnings("serial")
HashMap<String,Double> storageTotalLangauge = new HashMap<String,Double>(){
	    @Override
	    public Double get(Object key) {
	        if(! containsKey(key))
	            return 0.0;
	        return super.get(key);
	    }
 };

 HashMap<String,Double> storageCountryLangauge = new HashMap<String,Double>();




   public static void main(String [] args){
       Task test = new Task();
       test.CapitalCitiesE("C:/Users/Jamie.home/Desktop/file.csv");
   }

   @SuppressWarnings("unchecked")
public void CapitalCitiesE(String filename){

	   final long startTime = System.currentTimeMillis();

      BufferedReader br = null;
      String line = "";


    try {

        br = new BufferedReader(new FileReader(filename));
                br.readLine();
        while ((line = br.readLine()) != null) {


            String[] dataline = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

            			//if(dataline[12].equals("Tripoli")){
            				//System.out.println(Arrays.toString(dataline));
            			//}
                        storage.put(dataline[12].replace("\"", ""),dataline);
                        storageIndependence.put(dataline[2].replace("\"", ""),dataline);
                        storageSA.put(dataline[2].replace("\"", ""),Double.parseDouble(dataline[5]));
                        storageHOS.put(dataline[2].replace("\"", ""),(dataline[11].replace("\"", "")));

                        if(dataline[3].contains("Africa")){
                			storageAF.put(dataline[2].replace("\"", ""),Double.parseDouble(dataline[8]));

                            }






                    //Question 5

                        storageCountryLangauge = storageCountry.get(dataline[2].replace("\"", ""));


                        storageCountryLangauge.put(dataline[13].replace("\"", ""),Double.parseDouble(dataline[7])*Double.parseDouble(dataline[14]));


                        storageCountry.put(dataline[2].replace("\"", ""),storageCountryLangauge);


                                      }


        	Set<String> keysCountryHOS = storageHOS.keySet();

        	for(String i: keysCountryHOS)
        		{


            String head = storageHOS.get(i);
        	headofStates.put(head,headofStates.get(head)+1);


        		}


                      Set<String> keysCountry = storageCountry.keySet();

                      for(String i: keysCountry)
                      {
                      	HashMap<String,Double> Languages = storageCountry.get(i);
                      	Set<String> keysCountryLang = Languages.keySet();
                          for(String j: keysCountryLang){
                          	double test = (double) Languages.get(j);

                      	storageTotalLangauge.put(j,storageTotalLangauge.get(j)+test);


                       }

                      }









    } catch (Exception e) {
        System.out.println(e.toString());

   }
               int count =0;

               String list ="";
               Set<String> keys = storage.keySet();  //get all keys
               for(String i: keys)
               {

                   if (i.charAt(i.length() - 1)=='e'){
                       count++;
                       list = list + i+  "\n";
                   }

                }
               System.out.println("Question 1:");
               System.out.println(count);
               System.out.println();
               System.out.println("Question 2:");
               System.out.println(list);



             //QUESTION 3

               String listI="";
               int countI=0;


               Set<String> keysIn = storageIndependence.keySet();  //get all keys

               for(String i: keysIn)
               {

                   int year=0;

                   try
                   {
                       if(storageIndependence.get(i)[6] != "NULL")
                         year = Math.abs(Integer.parseInt(storageIndependence.get(i)[6]));
                   }
                   catch (NumberFormatException e)
                   {
                       year = 0;
                   }
                   if(year>=1950 && year<1971){
                	   countI++;
                   }
                   if(year>=1830 && year<1851){
                	   listI = listI + i+  "\n";
                   }
                }

               System.out.println("Question 3:");
               System.out.println(countI);
               System.out.println();
               System.out.println("Question 4:");
               System.out.println(listI);





               //QUESTION 5

             //BigInteger k = new BigDecimal(storageTotalLangauge.get("English")).toBigInteger();

               // System.out.println(k.toString());

                ValueComparator bvc =  new ValueComparator(storageTotalLangauge);
                TreeMap<String,Double> sorted_map = new TreeMap<String,Double>(bvc);
                sorted_map.putAll(storageTotalLangauge);

                int stop =0;
             System.out.println("Question 5:");
             for (Map.Entry<String, Double> entry : sorted_map.entrySet()) {
          	   if(stop==5){
          		   break;
          	   }
          	   stop++;
                 String key = entry.getKey();


                 System.out.println (key);

             }

             System.out.println();

             //QUESTION6

             ValueComparator bvcSA =  new ValueComparator(storageSA);
             TreeMap<String,Double> sorted_mapSA = new TreeMap<String,Double>(bvcSA);
             sorted_mapSA.putAll(storageSA);

             int stopSA =0;

          System.out.println("Question 6:");
          for (Map.Entry<String, Double> entry : sorted_mapSA.entrySet()) {
         	   if(stopSA==5){
         		   break;
         	   }
         	   stopSA++;
              String key = entry.getKey();


              System.out.println (key);
          }





  //QUESTION7

          ValueComparatorLow bvcAF =  new ValueComparatorLow(storageAF);
          TreeMap<String,Double> sorted_mapAF = new TreeMap<String,Double>(bvcAF);
          sorted_mapAF.putAll(storageAF);

          int stopAF =0;
          System.out.println();
       System.out.println("Question 7:");
       for (Map.Entry<String, Double> entry : sorted_mapAF.entrySet()) {
      	   if(stopAF==5){
      		   break;
      	   }
      	   stopAF++;
           String key = entry.getKey();

           System.out.println (key);
       }




       //QUESTION8


       ValueComparator bvcHOS =  new ValueComparator(headofStates);
       TreeMap<String,Double> sorted_mapHOS = new TreeMap<String,Double>(bvcHOS);
       sorted_mapHOS.putAll(headofStates);

       int stopHOS =0;
       System.out.println();
    System.out.println("Question 8:");
    for (Map.Entry<String, Double> entry : sorted_mapHOS.entrySet()) {
   	   if(stopHOS==1){
   		   break;
   	   }
   	   stopHOS++;
        String key = entry.getKey();
        //Double value = entry.getValue();

        System.out.println (key);
    }



    final long endTime = System.currentTimeMillis();
	int ans = (int) (((endTime - startTime) / 1000) % 60);

	System.out.println("Total execution time: " + ans );


}
}

class ValueComparator implements Comparator<String> {

    Map<String, Double> base;
    public ValueComparator(Map<String, Double> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with equals.
    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}

class ValueComparatorLow implements Comparator<String> {
    Map<String, Double> base;
    public ValueComparatorLow(Map<String, Double> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with equals.
    public int compare(String a, String b) {
        if (base.get(a) <= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}
