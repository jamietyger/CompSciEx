import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;


public class Hashan {

	HashMap table;
	int size =0;
	public Hashan(){
		
		table = new HashMap<String,String>();
	}
	
	public void put(String key){
		String nkey = SortLetters(key);
		
		if(table.containsKey(nkey)==false){
		table.put(nkey,key);
		
		}
		else if(table.get(nkey).toString().contains(key)){
			
		}
		else{

			 String value = (table.get(nkey).toString())+" "+key+" "; //edit
             
			table.put(nkey,value);
			size++;
			
		}
	}
	
	
	public String get(String key){
		return (table.get(SortLetters(key)).toString());
		
	}
	public String SortLetters(String original)
	    {
	        char[] letters = original.toCharArray();
	        Arrays.sort(letters);
	        return  String.valueOf(letters);
	    }
	
	public void findList(){
		
			Set<String> keys = table.keySet();
			int maxValue = Integer.MIN_VALUE;
			String maxList = null;
	        for(String key: keys){
	        	if(key.equals("")){
	        		  continue;
	        		 }
	        	if(table.get(key).toString().equals("")){
	        		  continue;
	        		 }
	        	
	        	if(wordcount(table.get(key).toString()) > maxValue) {
	                maxValue =wordcount(table.get(key).toString());
	                maxList=table.get(key).toString();
		
		}
	        
	        }
	    System.out.println(maxList);
	   
		
	}
	 static int wordcount(String s)
	    {
		 int c=0;
	        char ch[]= new char[s.length()];     
	        for(int i=0;i<s.length();i++)
	        {
	            ch[i]= s.charAt(i);
	            if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )
	            c++;
	        }
	        return c;
	    }
	
public static void main(String [] args)throws FileNotFoundException, IOException{
		
		Hashan test = new Hashan();

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
        

      System.out.println("Number of anagrams:");
      System.out.println(test.size);
      System.out.println("Longest list:");
      test.findList();
    
       
	}
	
}
