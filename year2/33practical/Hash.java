import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;


public class Hash {

	HashMap table;

	
	
	public Hash(){
		
		table = new HashMap<String,Integer>();
		
	
		
	}
	
	public void put(String key){
		
		if(table.containsKey(key)==false){
		table.put(key, 1);
		
		}
		else{

			 int value = Integer.parseInt(table.get(key).toString());
             value++;
			table.put(key,value);
			
		}
	}
	
	
	public int get(String key){
		return Integer.parseInt(table.get(key).toString());
		
	}
	
	public void max(){
        System.out.println("Number of Words:");
		System.out.println(table.size());
        System.out.println("Most Popular Words");
		for(int i =0;i<10;i++){
		Set<String> keys = table.keySet();
		int maxValue = Integer.MIN_VALUE;
		String maxWord = null;
        for(String key: keys){
        	if(key.equals("")){
        		  continue;
        		 }
        	if(key.equals("s")){
      		  continue;
      		 }
            if(key.equals("_")){
      		  continue;
      		 }
        	 if(Integer.parseInt(table.get(key).toString()) > maxValue) {
                maxValue =Integer.parseInt(table.get(key).toString());
                maxWord=key;
	
	}
        
        }
    System.out.println(maxWord);
    System.out.println(maxValue);
    table.remove(maxWord);
   
	}
		
	}
		
	
	public static void main(String [] args)throws FileNotFoundException, IOException{
		
		Hash test = new Hash();

		File file = new File("/export/home/notes/ds/ulysses.text");
        BufferedReader bufferedReader = null;
        bufferedReader = new BufferedReader(new FileReader(file));
        String inputLine = null;
 
        try {
            while ((inputLine = bufferedReader.readLine()) != null) {
            String[] words = inputLine.split("\\W+");
 
                for (int counter = 0; counter < words.length; counter++) {
                    String key = words[counter].toLowerCase(); // remove .toLowerCase for Case Sensitive result.
                    key.replaceAll("([a-z]+)[?:!.,;_]*", "$1");
                    test.put(key);
                 }
            }
		
	} catch (IOException error) {
        System.out.println("Invalid File");  
    }
        

        
        test.max();
       
	}
	
	
}
