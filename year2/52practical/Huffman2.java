


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Huffman2 {
String text = "";
String bin ="";
String noise ="";
int[] freq = new int[68000];
String[] symbolTable = new String[68000];;  
Heap heap;
double[] means = new double[30];
int l=0;
String safe ="";


char[] compare1 = new char[10000];
char[] compare2 = new char[10000];
	
public Huffman2(){
	
}



public void encrypt(String input) throws IOException{
   for(int i=0;i<1;i++){
	text = input;
	
	getFreq(text);
	
	  createHeap(freq);
	  heap = createTree(heap);
	  generateCode(heap.getMin(), "");
	  outputTable();
	  System.out.println();
	  outputHuff();
	System.out.println();
	
	try {
		String output = new Scanner(new File("/export/home/second/southgate/southgate,jamie/52practical/BIN.text")).useDelimiter("\\Z").next();
		bin = output;
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 noise();
    compare1 =decrypt(bin);
    System.out.println();
    
   
    compare2=decrypt(noise);
    compare();
    average(means);
   }
   
}

public void average(double[] means2) {  
	double sum = 0; 

	

	// Calculate everything that can be done in the first pass. 
	for (int i = 0; i < means.length; i++) { 
	sum = sum + means[i]; // sum 
	} 

	double average = sum / l; 
	
	System.out.println("PERCENTAGE RECOVERED: "+means[l-1]);
	
	
}

public void stand(){
	// For the Standard deviation, must loop over the numbers again 
		double runningDeltaSquared = 0; 
		double sum=0;
		double standardDeviation = 0; 
		
		for (int i = 0; i < l; i++) { 
			sum = sum + means[i]; // sum 
			} 

			double average = sum / l; 
			
			System.out.println("AVG "+ average);
		for (int i = 0; i < l; i++) { 
		double DeltaSquared = Math.pow(average - means[i], 2); 
		runningDeltaSquared = runningDeltaSquared + DeltaSquared; 
		} 
		// Calculate the standard deviation 
		standardDeviation = Math.sqrt(runningDeltaSquared / l); 
		System.out.println("STAND DEV "+ standardDeviation);
}

public void compare(){
	int count =0;
	for(int i=0;i<compare2.length;i++){
		if(compare1[i]!=compare2[i]){
			count++;
		}
		
		
	}
    int numel =0;
    for(int i=0;i<compare1.length;i++){
        if(compare1[i]!='\u0000'){
            numel++;
        }
    }

    
	double  a= (double)(numel);
	double c  = (double)count;
	double ans = ((c/a)*100);
	
	
means[l]=(100-ans);
l++;
	
}
public char[] decrypt(String input){
return generateText(heap.getMin(),input);
}
private void createHeap(int[] freq) {
    heap = new Heap(68000);
    for(int i = 0; i < freq.length; ++i) {
            if(freq[i] != 0) {
                    Node node = new Node(freq[i], i);
                    node.setToLeaf();
                    heap.insert(node);
            }
    }
    
}

private Heap createTree(Heap heap) {
    int n = heap.getSize();
    for(int i = 0; i < n-1; i++) {
            Node z = new Node();
            z.setLeft(heap.delMin());
            z.setRight(heap.delMin());
            z.setFreq(z.getLeft().getFreq() + z.getRight().getFreq());
            heap.insert(z);
    }
    return heap;
}

private void generateCode(Node node, String code) {             
    if(node != null) {                      
            if(node.isLeaf())
                    symbolTable[node.getKey()] = code;
            else {
                    generateCode(node.getLeft(), code + "0");
                    generateCode(node.getRight(), code + "1");
            }
    }
}
private char[] generateText(Node node, String code) {
	
	char[] out = new char[code.length()];
	int y=0;
      int length = code.length();
      int num =0;
      for(int i =0;num<code.length();i++){
      Node curr = node;
        while(curr.isLeaf()==false && num<length){
             if(code.charAt(num)=='0'){
            	 	curr = curr.getLeft();
            	 	num++;
            
            
            
            
        }
             else{
            	 
            
        	
           curr = curr.getRight();
           num++;
        
        }
        }
       
           out[y]=(char)(curr.getKey());
           y++;
            

           
        }

    return out;
}


public void outputTable(){
	for(int i=0;i<symbolTable.length;i++){
		if(symbolTable[i]!=null){
			System.out.println((char)i+" "+symbolTable[i]);
		}
	}
}

public void outputHuff(){
	
	for(int i=0;i<text.length();i++){
        bin+=symbolTable[(int)text.charAt(i)];
		//System.out.print(symbolTable[(int)text.charAt(i)]);
	}
	safe = bin;
	writing();
}

public void writing() {
    try {
//What ever the file path is.
        File statText = new File("/export/home/second/southgate/southgate,jamie/52practical/BIN.text");
        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is);    
        Writer w = new BufferedWriter(osw);
        w.write(bin);
        w.close();
    } catch (IOException e) {
        System.err.println("Problem writing to the file statsTest.txt");
    }
}



public void getFreq(String input){
    
    for(int i =0;i<input.length();i++){
        freq[(int)input.charAt(i)]++;
    }
   
}

public void noise() throws IOException{
	
	

int i=0;
char arrnoise[] = new char[10000]; 

FileInputStream in;
try {
	in = new FileInputStream("/export/home/second/southgate/southgate,jamie/52practical/BIN.text");
	
	while (i<10000 & in.read()!=-1) { 
		int r = in.read();
		char c = (char) r;
		arrnoise[i]= c;
		i++;
	}
	
	for(char str: arrnoise)
        bin=bin+str;
	
	Random r = new Random();
	
	int Low = 10;
	int High = 101;
	int R = r.nextInt(High-Low) + Low;

	for(int j=0;j<arrnoise.length;j++){
    	if(j%1000==0){ 
    	for(int k =0;k<0;k++){
    		if(j+k>arrnoise.length){
    			break;
    		}
    		else if(arrnoise[j+k]=='0'){
    			arrnoise[j+k]='1';
    		}
    			else if (arrnoise[j+k]=='1'){
    			arrnoise[j+k]='0';
    			}
    	}
    	}
    }
    
    for(char str: arrnoise)
        noise=noise+str;
    
   
   
	
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
    
    
    
}
	
public static void main(String [] args){
	Huffman2 test = new Huffman2();
	

	try {
		String output = new Scanner(new File("/export/home/second/southgate/southgate,jamie/52practical/thecatlonger.text")).useDelimiter("\\Z").next();
		test.encrypt(output);
		
	
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}
	
  
    





}
