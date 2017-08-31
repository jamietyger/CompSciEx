import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;


public class tryhashj {
	private int M; //size of table
    private int N; //number of pairs
    static Scanner reader;
    static DecimalFormat df = new DecimalFormat("#.0000");
private HashMap table;	
	
public tryhashj(){
	table = new HashMap();
	
}

public void put(String key){
	table.put(key.hashCode(), key);
	N++;
}

public String get(String key){
	return table.get(key.hashCode()).toString();
	
}
	
public void remove(String key){
	table.remove(key.hashCode());

}

public void RunI(){
	long [] count = new long[3];
	int num=0;
	for(int i =0 ;i<3;i++){
	tryhashj hashT = new tryhashj();




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
	tryhashj hashT = new tryhashj();




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
	tryhashj hashT = new tryhashj();




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



public static void main(String []args){
	
	
	tryhashj test = new tryhashj();
	test.RunI();
    test.RunL();
    test.RunD();
}



}
