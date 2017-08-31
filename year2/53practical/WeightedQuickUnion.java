
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author southgate
 */
public class WeightedQuickUnion {

    private int []id;
    private int[]sz;
    private int count;

    public WeightedQuickUnion(){
    }
    public WeightedQuickUnion(int N){
    count = N;
    id = new int[N];
    sz = new int[N];


    for(int i=0;i<N;i++){
        id[i]=i;
        sz[i]=1;
    }

    }
    //find the root
    public int root(int p){
        int i =p;
        while(i!=id[i]){
            i=id[i];
        }
        return i;
    }

public int count(){
    return count;
}


    public boolean connected(int p,int q){
        return root(p)==root(q);
    }

    public void union(int p,int q){
        int proot = root(p);
        int qroot = root(q);
        if(proot==qroot){
            return;
        }
        if(sz[proot]<sz[qroot]){
            id[proot] =qroot;
            sz[qroot]+=sz[proot];
        }
        else{
            id[qroot] =proot;
            sz[proot]+=sz[qroot];
        }
        count--;
    }

    public void HugeUF(){

   Scanner br;///export/home/notes/ds/airlineroutes.dot"

            try {
                String sCurrentLine;
                String [] information = new String[2];
                br = new Scanner(new File("/export/home/notes/ds/hugeUF.data"));
                sCurrentLine = br.nextLine();
                int nodenum = Integer.parseInt(sCurrentLine);
                WeightedQuickUnion graph = new WeightedQuickUnion(nodenum);


                while(br.hasNextLine()){
                    sCurrentLine = br.nextLine();
                    information=sCurrentLine.split(" ");
                    graph.union(Integer.parseInt(information[0]), Integer.parseInt(information[1]));
                }

                System.out.println("HUGE: "+graph.count());

            } catch (FileNotFoundException ex) {
                Logger.getLogger(WeightedQuickUnion.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public void smallUF(){

   Scanner br;///export/home/notes/ds/airlineroutes.dot"

            try {
                String sCurrentLine;
                String [] information = new String[2];
                br = new Scanner(new File("/export/home/notes/ds/smallUF.data"));
                sCurrentLine = br.nextLine();
                int nodenum = Integer.parseInt(sCurrentLine);
                WeightedQuickUnion graph = new WeightedQuickUnion(nodenum);


                while(br.hasNextLine()){
                    sCurrentLine = br.nextLine();
                    information=sCurrentLine.split(" ");
                    graph.union(Integer.parseInt(information[0]), Integer.parseInt(information[1]));
                }

                System.out.println("SMALL: "+graph.count());

            } catch (FileNotFoundException ex) {
                Logger.getLogger(WeightedQuickUnion.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public void largeUF(){

   Scanner br;///export/home/notes/ds/airlineroutes.dot"

            try {
                String sCurrentLine;
                String [] information = new String[2];
                br = new Scanner(new File("/export/home/notes/ds/largeUF.data"));
                sCurrentLine = br.nextLine();
                int nodenum = Integer.parseInt(sCurrentLine);
                WeightedQuickUnion graph = new WeightedQuickUnion(nodenum);


                while(br.hasNextLine()){
                    sCurrentLine = br.nextLine();
                    information=sCurrentLine.split(" ");
                    graph.union(Integer.parseInt(information[0]), Integer.parseInt(information[1]));
                }

                System.out.println("LARGE: "+graph.count());

            } catch (FileNotFoundException ex) {
                Logger.getLogger(WeightedQuickUnion.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public static void main(String [] args) throws IOException{

            WeightedQuickUnion test = new WeightedQuickUnion();
            test.smallUF();
            test.largeUF();
            test.HugeUF();





    }





    }



