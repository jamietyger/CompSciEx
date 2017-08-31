//dprac4
//Southgate, Jamie 3364309
import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;

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
public class dprac4 {
	static Scanner reader,readerT;
	static DecimalFormat df = new DecimalFormat("0.0000");


    /**
     * @param args the command line arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
    runBF();
    runRK();
    runBM();
    runKMP();
    }

//BRUTE FOCE
    public static int BruteForce(String text, String pattern){

  int  n = text.length();
  int m = pattern.length();

  for(int pos =0;pos<=n-m;pos++){     //go through all positions
      int j;
      for (j =0;j<m;j++)
          if(text.charAt(pos+j)!=pattern.charAt(j))  //check if the same
              break;


      if(j==m)
        return pos;

      }
      return -1;
  }

//RABIN KARP
public static int rabinkarp(String text, String pattern){

    int m = pattern.length();
    int n = text.length();

    int Pathash = pattern.hashCode();  //get hash

    for(int i =0;i<=n;i++){
        if(i+m+1<n+2){

            String sub = text.substring(i,i+m);   // hash of part
            int Subhash = sub.hashCode();

            if(Subhash==Pathash){
                int k =0;
                boolean d = true;   //if hash = true then do brute force check

                for(int j =i;j<i+m;j++){
                    if(text.charAt(j)==pattern.charAt(k)){
                        k++;
                    }
                    else{
                        d=false;
                        break;
                    }
                }
                if(d){
                   return i;
                }
            }

        }
    }
    return -1;

}

// BOYER MOORE

public static int boyermoore(String text, String pattern){

    int m = pattern.length();
    int n = text.length();

    if(m==0){
        return 0;
    }
    else if(n==0){
        return -1;
    }
    else if (m>n){
        return -1;
    }

    int s =256;
    int last [] = new int [s];
    int i,j;

  getLast(pattern,last);  //fill with position of last occurance

  i=j = m-1;
  do{
      if(pattern.charAt(j)==text.charAt(i)){  //if letter is the same
          if(j==0){
              return i;
          }
          else{
              i--;                //work backwards
              j--;
          }
      }
      else{
          i = i+m - Math.min(j, 1+last[text.charAt(i)]);   //move forward;
          j = m-1;
      }
  } while (i<n);
  return -1;

}

public static void getLast(String p, int[] lastInP){
    int j,m = p.length();

    for (j =0; j<lastInP.length;j++){  //fill with negative 1
        lastInP[j]=-1;
    }

    for (j=0;j<m;j++){
        lastInP[(int)(p.charAt(j))] = j;    //fill with position
    }
}

//KMP
public static int KMP(String text, String pattern){
     int m = pattern.length();
     int n = text.length();

      if(m==0){
        return 0;
    }
    else if(n==0){
        return -1;
    }
    else if (m>n){
        return -1;
    }

     int i,j, next[] = new int [m+1];

     buildNext(pattern,next);

     i=0;
     j=0;

     while(i<n){
         if(pattern.charAt(j)==text.charAt(i)){
             i++;
             j++;
         }
         else{
             j = next[j];

             if(j<0){
                 j=0;
                 i++;}
             }
         if(j==m){
             return i-m;
         }
     }
     return -1;
    }
public static void buildNext(String p, int [] next){
    int m = p.length();
    int i,j;

    next[0]=-2;
    next[1] = -1;

    for (i =2;i<m;i++){
        j = next[i-1]+1;
        while(j>=0 && p.charAt(i-1)!=p.charAt(j)){
            j = next[j]+1;
        }
        next[i]=j;
    }

    for (j=0;j<m;j++){
        next[j]++;
    }
}

public final static String readFile(String file) throws IOException {
    StringBuffer sb = new StringBuffer();

try {
    BufferedReader fileReader = new BufferedReader(new FileReader(new File (file)));
    String s;
    while ((s=fileReader.readLine())!=null) {
            sb.append(s);               //append line to string

    }

   return sb.toString();

 } catch (IOException e) {
        e.printStackTrace();
 }
    return "";
	}
public static void runBF() throws IOException{
	int counter =0;
	String text = readFile("/export/home/notes/ds/lesMiserables/text.txt");




	long start = System.currentTimeMillis();
	long finish = System.currentTimeMillis();







		  try{
				reader = new Scanner(new File("/export/home/notes/ds/lesMiserables/patterns.txt"));

			}
			catch(Exception e){
				System.out.println("Error");
				}


		while(reader.hasNextLine() && (finish - start <= 1000)){
			String lines = reader.nextLine();
			String [] line = lines.split(" ");

			for(int i=0;i<line.length;i++){
				if(BruteForce(text,line[i])!=-1){

					counter++;
				}
				}






	finish = System.currentTimeMillis();


}
	 System.out.println("BF "+ counter+" "+df.format((double)(finish-start)/1000.0)+" s.");


}

public static void runRK() throws IOException{
	int counter =0;
	String text = readFile("/export/home/notes/ds/lesMiserables/text.txt");




	long start = System.currentTimeMillis();
	long finish = System.currentTimeMillis();







		  try{
				reader = new Scanner(new File("/export/home/notes/ds/lesMiserables/patterns.txt"));

			}
			catch(Exception e){
				System.out.println("Error");
				}


		while(reader.hasNextLine() && (finish - start <= 1000)){
			String lines = reader.nextLine();
			String [] line = lines.split(" ");

			for(int i=0;i<line.length;i++){
				if(rabinkarp(text,line[i])!=-1){

					counter++;
				}
				}






	finish = System.currentTimeMillis();


}
	 System.out.println("RK "+ counter+" "+df.format((double)(finish-start)/1000.0)+" s.");


}




public static void runBM() throws IOException{
	int counter =0;
	String text = readFile("/export/home/notes/ds/lesMiserables/text.txt");




	long start = System.currentTimeMillis();
	long finish = System.currentTimeMillis();







		  try{
				reader = new Scanner(new File("/export/home/notes/ds/lesMiserables/patterns.txt"));

			}
			catch(Exception e){
				System.out.println("Error");
				}


		while(reader.hasNextLine() && (finish - start <= 1000)){
			String lines = reader.nextLine();
			String [] line = lines.split(" ");

			for(int i=0;i<line.length;i++){
				if(boyermoore(text,line[i])!=-1){

					counter++;
				}
				}






	finish = System.currentTimeMillis();


}
	 System.out.println("BM "+ counter+" "+df.format((double)(finish-start)/1000.0)+" s.");


}




public static void runKMP() throws IOException{
	int counter =0;
	String text = readFile("/export/home/notes/ds/lesMiserables/text.txt");
	



	long start = System.currentTimeMillis();
	long finish = System.currentTimeMillis();







		  try{
				reader = new Scanner(new File("/export/home/notes/ds/lesMiserables/patterns.txt"));

			}
			catch(Exception e){
				System.out.println("Error");
				}


		while(reader.hasNextLine() && (finish - start <= 1000)){
			String lines = reader.nextLine();
			String [] line = lines.split(" ");

			for(int i=0;i<line.length;i++){
				if(KMP(text,line[i])!=-1){

					counter++;
				}
				}

	finish = System.currentTimeMillis();


}
	 System.out.println("KMP "+ counter+" "+df.format((double)(finish-start)/1000.0)+" s.");


}



}
