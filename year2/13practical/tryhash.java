import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author southgate
 */
public class tryhash {
    public static final int INITALCAPACITY = 50;
    private int M; //size of table
    private int N; //number of pairs
    private String[] keys;
    private int[] data;
    private float alpha = 0.75f;
    static Scanner reader;
    static DecimalFormat df = new DecimalFormat("#.0000");




    public tryhash(){
        this(INITALCAPACITY);
    }

    public tryhash(int capacity){
        M = capacity;
        keys = new String[M];
        data = new int[M];

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

    public void resize(int capacity){
        tryhash temp = new tryhash(capacity);
        for(int i =0; i<M;i++){
            if(keys[i]!=null){
                temp.put(keys[i],data[i]);
            }
        }
        keys = temp.keys;
        data = temp.data;
        M = temp.M;
    }

    public void put(String key, int val){

           if(N>=alpha*M){
               resize(2*M);
           }
        int i;
        for(i = hash(key); keys[i]!=null;i=(i+1)%M){
            if(keys[i].equals(key)){
                data[i]=val;
                return;
            }
            }
        keys[i]=key;
        data[i]=val;
        N++;
        }
public int get(String key){
    for(int i = hash(key); keys[i]!=null;i =(i+1)%M){
        if(keys[i].equals(key))
            return data[i];

    }
 return -1;
}

public void Run(float load){
	long [] count = new long[5];
	for(int i =0 ;i<5;i++){ 
	tryhash hashT = new tryhash();
	 

		
		
	 hashT.setload(load);
		
		
		long start = System.currentTimeMillis();
		long finish = System.currentTimeMillis();
		  
		  
		  
		  
		 
			  
			  
			  try{
					Scanner reader = new Scanner(new FileReader("/export/home/second/southgate/southgate,jamie/13practical/primes.txt"));
					while(reader.hasNextLine()){
						String lines = reader.nextLine();
						hashT.put(lines, 1);
					
				}
				
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
	   
	 System.out.println("HASH="+ load+"    n="+this.INITALCAPACITY+"     "+df.format(average)+" s.");	  
}


    public static void main(String args[]){
    	tryhash hashTest = new tryhash();
    	hashTest.Run(0.75f);
    	hashTest.Run(0.80f);
    	hashTest.Run(0.85f);
    	hashTest.Run(0.90f);
    	hashTest.Run(0.95f);
}
}
 
 
 

