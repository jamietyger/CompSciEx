


import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author southgate
 */
public class tryhasha {
    public static final int INITALCAPACITY = 16;
    private int M; //size of table
    private int N; //number of pairs
    private String[][] keys;


    private float alpha = 0.75f;
    static Scanner reader;
    static DecimalFormat df = new DecimalFormat("#.0000");




    public tryhasha(){
        this(INITALCAPACITY);
    }

    public tryhasha(int capacity){
        M = capacity;
        setKeys(new String[M][0]);


    }

    public int size(){
        return N;
    }

   public void setload(float newa){
	   alpha = newa;
   }
    public boolean isEmpty(){
        return size()==0;
    }


    private int hash(String k){
        int x = Integer.parseInt(k);
        return Math.abs(((1562381*x)+8394223) % (M -1));
    }

 public int longestArray(){
	 int len = 0;
	 for(int i =0 ; i<getKeys().length;i++){
		 if(getKeys()[i].length>len){
			 len= getKeys()[i].length;
		 }
	 }
	 return len;
 }
    public void put(String key){

       // if(longestArray()>=10){
          //  resize(2*M);
        //}

        int i = hash(key);
        if(i>M){
            i =(i+1)%M;
        }

       int len=getKeys()[i].length;
       if(len==0){
           getKeys()[i]= new String[1];
           getKeys()[i][0]= (key);
       }
       else{
           String[] temp  = new String[len+1];
           System.arraycopy(getKeys()[i], 0, temp, 0, getKeys()[i].length);
           temp[len]=(key);
           getKeys()[i]=temp;

       }
       

        N++;
        }
public int get(String key){

    int i = hash(key);
        if(i>M){
            i =(i+1)%M;
        }
    if(useLoop(getKeys()[i],(key))==true){
        return Integer.parseInt(key);
    }


 return -1;
    }

public String remove(String key){
	   int i = hash(key);
       if(i>M){
           i =(i+1)%M;
       }
   if(useLoop(getKeys()[i],key)==true){
	   List<String> list = new ArrayList<String>(Arrays.asList(getKeys()[i]));
	   list.remove(key);
	   getKeys()[i] = list.toArray(new String[0]);
	   return key;
   }
return null;
	
}

public void resize(int capacity){
    tryhasha temp = new tryhasha(capacity);
    for (int i = 0; i < getKeys().length; i++) {
        System.arraycopy(getKeys()[i], 0, temp.getKeys()[i], 0, getKeys()[i].length);
    }
    setKeys(temp.getKeys());
    M = temp.M;
}

public boolean useLoop(String[] keys, String key) {
	for(String s: keys){
		if(s.equals(key))
			return true;
	}
	return false;
}
public void RunI(){
	long [] count = new long[5];
	int num=0;
	for(int i =0 ;i<5;i++){
	tryhasha hashT = new tryhasha();




	 //hashT.setload(load);


		long start = System.currentTimeMillis();
		long finish = System.currentTimeMillis();







			  try{
					Scanner reader = new Scanner(new FileReader("/export/home/second/southgate/southgate,jamie/14practical/primes.txt"));
					while(reader.hasNextLine()){
						String lines = reader.nextLine();
						hashT.put(lines);

				}
					num = hashT.N;

			  }
				catch(Exception e){
					System.out.println(e.toString());
					}











		finish = System.currentTimeMillis();



		count[i]=(finish-start);
	}

	 	long sum = 0;
	    long average;

	    for(int i=0; i < count.length; i++){
	        sum = sum + count[i];
	    }
	    average = (long)sum/count.length;
	    System.out.println("INSERT");
	    System.out.println("n="+num+"     "+"M="+this.M+"    "+df.format(average)+" s.");	
}


public void RunL(){
	long [] count = new long[5];
	int num=0;
	for(int i =0 ;i<5;i++){
	tryhasha hashT = new tryhasha();




	 //hashT.setload(load);


		







			  try{
					Scanner reader = new Scanner(new FileReader("/export/home/second/southgate/southgate,jamie/14practical/primes.txt"));
					while(reader.hasNextLine()){
						String lines = reader.nextLine();
						hashT.put(lines);

				}
					num = hashT.N;

			  }
				catch(Exception e){
					System.out.println(e.toString());
					}



			  long start = System.currentTimeMillis();
				long finish = System.currentTimeMillis();

				try{
					Scanner reader = new Scanner(new FileReader("/export/home/second/southgate/southgate,jamie/14practical/primes.txt"));
					while(reader.hasNextLine()){
						String lines = reader.nextLine();
						hashT.get(lines);

				}
					num = hashT.N;

			  }
				catch(Exception e){
					System.out.println(e.toString());
					}





		finish = System.currentTimeMillis();



		count[i]=(finish-start);
	}

	 	long sum = 0;
	    long average;

	    for(int i=0; i < count.length; i++){
	        sum = sum + count[i];
	    }
	    average = (long)sum/count.length;
	    System.out.println("Lookup");
	    System.out.println("n="+num+"     "+"M="+this.M+"    "+df.format(average)+" s.");	
}



public void RunD(){
	long [] count = new long[5];
	int num=0;
	for(int i =0 ;i<5;i++){
	tryhasha hashT = new tryhasha();




	 //hashT.setload(load);


		







			  try{
					Scanner reader = new Scanner(new FileReader("/export/home/second/southgate/southgate,jamie/14practical/primes.txt"));
					while(reader.hasNextLine()){
						String lines = reader.nextLine();
						hashT.put(lines);

				}
					num = hashT.N;

			  }
				catch(Exception e){
					System.out.println(e.toString());
					}



			  long start = System.currentTimeMillis();
				long finish = System.currentTimeMillis();

				try{
					Scanner reader = new Scanner(new FileReader("/export/home/second/southgate/southgate,jamie/14practical/primes.txt"));
					while(reader.hasNextLine()){
						String lines = reader.nextLine();
						hashT.remove(lines);

				}
					num = hashT.N;

			  }
				catch(Exception e){
					System.out.println(e.toString());
					}





		finish = System.currentTimeMillis();



		count[i]=(finish-start);
	}

	 	long sum = 0;
	    long average;

	    for(int i=0; i < count.length; i++){
	        sum = sum + count[i];
	    }
	    average = (long)sum/count.length;
	    System.out.println("Delete");
	    System.out.println("n="+num+"     "+"M="+this.M+"    "+df.format(average)+" s.");	
}



    public static void main(String args[]){
    	tryhasha test = new tryhasha();
       test.RunI();
       test.RunL();
       test.RunD();
       
       
       
       
       
       

}

	public String[][] getKeys() {
		return keys;
	}

	public void setKeys(String[][] keys) {
		this.keys = keys;
	}
}




