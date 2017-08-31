


import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
public class tryhashll {
    public static final int INITALCAPACITY = 16;
    private int M; //size of table
    private int N; //number of pairs
    private LinkedList[] keys;


    private float alpha = 0.75f;
    static Scanner reader;
    static DecimalFormat df = new DecimalFormat("#.0000");




    public tryhashll(){
        this(INITALCAPACITY);
    }

    public tryhashll(int capacity){
        M = capacity;
        keys = new LinkedList[M];


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
   	 for(int i =0 ; i<keys.length;i++){
   		 if(keys[i]==null){
   			 len= 0;
   		 }
   		 else if(keys[i].size()>len){
   			 len= keys[i].size();
   		 }
   	 }
   	 return len;
    }

    public void put(String key){
    	if(longestArray()>=10){
            resize(2*M);
        }

        int i = hash(key);
        if(i>M){
            i =(i+1)%M;
        }

      if(keys[i]==null){
    	  keys[i]= new LinkedList();
      }
      
           keys[i].add(key);
         
    
       
      
        N++;
        }
public String get(String key){
	   int i = hash(key);
 if(i>M){
     i =(i+1)%M;
 }
if(keys[i].contains(key)==true){
	   keys[i].remove(key);
	   
}
return null;
    }





public void resize(int capacity){
    tryhashll temp = new tryhashll(capacity);
    for (int i = 0; i < keys.length; i++) {
       temp.keys[i]=this.keys[i];
    }
    keys = temp.keys;
    M = temp.M;
}

public String remove(String key){
	   int i = hash(key);
    if(i>M){
        i =(i+1)%M;
    }
if(keys[i].contains(key)==true){
	   keys[i].remove(key);
	   return key;
}
return null;
	
}


public void RunI(){
	long [] count = new long[3];
	int num=0;
	for(int i =0 ;i<3;i++){
	tryhashll hashT = new tryhashll();




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
	long [] count = new long[3];
	int num=0;
	for(int i =0 ;i<3;i++){
	tryhashll hashT = new tryhashll();




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
	long [] count = new long[3];
	int num=0;
	for(int i =0 ;i<3;i++){
	tryhashll hashT = new tryhashll();




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
    	tryhashll test = new tryhashll();
    	test.RunI();
        test.RunL();
        test.RunD();

}

	
}




