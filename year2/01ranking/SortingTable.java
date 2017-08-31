import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class SortingTable {

	private Function [] nums = new Function[27];
	 static private Comparator<Function> ascanswer;
	

	    // We initialize static variables inside a static block.
	    static {
	         ascanswer= new Comparator<Function>(){
	            @Override
	            public int compare(Function b1, Function b2){
	                return compareD(b1.getAns(), b2.getAns());
	            }
	        };
	    }

	       
	
	
	
	public SortingTable(){
	
		try{
			int counter =0;
			Scanner reader = new Scanner(new FileReader("/export/home/second/southgate/southgate,jamie/01ranking/rankingdata.txt"));
			while(reader.hasNextLine()){
				String lines = reader.nextLine();
				Function eq = new Function(lines);
				eq.solve(5);
				nums[counter]=eq;
				counter++;
		}
		
	  }
		catch(Exception e){
			System.out.println(e.toString());
			}
	  
		
		
		
		System.out.println("Import Success!");
		System.out.println();
		System.out.println("Smallest to Biggest");
		
		
		 Arrays.sort(nums, ascanswer);		
		
		 for(int i =0;i<nums.length;i++){
			 System.out.println(nums[i].getEq());
		 }
	
	
		
		
	}
	
	public static int compareD(double x, double y) {
	    return x < y ? -1
	         : x > y ? 1
	         : 0;
	}
	
	
	public static void main(String [] args){
	
		
		SortingTable table = new SortingTable();
		
		
		
		
		
	}
	
	
	
}
