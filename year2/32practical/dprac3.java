

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.

package dprac3;

/**
 *
 * @author southgate
 */

import java.util.*;
public class dprac3 {
    int v = - 1;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int N = 21;
        int a[] = shuffle(N);
        int k = (int)(21/3);
        int b[] = new int[a.length];
        for(int i = 0; i < a.length; i++){
            b[i] = a[i];
        }
        median(a);
        System.out.println(Arrays.toString(a).replace(",", " ").replace("[", "").replace("]", "")+" "+k+" "+findkth(a,k));
        partmedian(b);
    }

    public static void median(int []a){
        int b[] = new int[a.length];
        for(int i = 0; i < a.length; i++){
            b[i] = a[i];
        }
         qsort(b,0,a.length-1);


           int median;
        if((b.length%2)==0){
           median = (b[b.length/2]+b[(b.length+1)/2])/2;
        }
   // even
        else{
             median = b[b.length/2];
        }
   // odd



         System.out.println(Arrays.toString(a).replace(",", " ").replace("[", "").replace("]", "")+" "+ median);



    }
    public static int [] shuffle(int N){
        int [] no = new int[N+1];
        for(int k =0;k<no.length;k++){
            no[k]=k+1;
    }
        for(int i=0;i<no.length;i++){
            int j= i+ (int)(Math.random()*N)-i;
            swap(no,i,j);
        }
        return no;
    }
    public static void qsort(int [] a, int low, int high){
       
        int p = partition(a,low,high);
        if(low<p-1){
            qsort(a,low,p-1);
        }
        if(high>p){
            qsort(a,p,high);
        }


  }

public static void swap(int [] a, int b,int c){
    int temp = a[b];
    a[b]=a[c];
    a[c]=temp;

}



public static int findkth(int [] a,int k){
    int low =0;
    int high =a.length -1;
    k=k-1;
    while(low<high){
        int i = partitionIndx(a,low,high);
        if(i==k){
            return a[i];
        }
        else if(i<k){

            low =i+1;
            
        }
        else {
            high = i-1;

        }}
       
    return a[k];
}

public static int partition(int [] a, int front, int back){
    
        int pivotIndx = Math.abs((front + back)/2);
        int pivot = a[pivotIndx];
        
        int i = front;
        int j = back;

        while(i<=j){
            while(i<back && a[i]<pivot){
                i++;
            }
            while(j>=front && a[j]>pivot){
                j--;
            }
            if(i<=j){
                swap(a,i,j);
                i++;
                j--;
            }
        }
       
    
        return i;
   
}

public static int partitionIndx(int [] a, int front, int back){

        int i = front+1;
        int j=back;
        int pivot = a[front];



        while(front<back){
            while(a[i]<=pivot){
                i++;
            }
            while(a[j]>pivot){
                j--;
            }
            if(i<j){
                swap(a,i,j);
            }
            else
                break;
        }
        swap(a,front,j);
       return j;
    

}

public static void partmedian(int []a){
  int c[] = new int[a.length];
        for(int i = 0; i < a.length; i++){
            c[i] = a[i];
        }
 int m1 =findkth(a,a.length/2);
 int m2 = findkth(a,(a.length+2)/2);
 System.out.println(Arrays.toString(c).replace(",", " ").replace("[", "").replace("]", "")+" "+ m1+" "+m2);

}
}

