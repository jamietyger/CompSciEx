/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author southgate
 */
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class MergeHeap
{
    private static int[] a;
    private static int n;
    private static int left;
    private static int right;
    private static int largest;


    public static void buildheap(int []a){
        n=a.length-1;
        for(int i=n/2;i>=0;i--){
            heapify(a,i);
        }
    }

    public static void heapify(int[] a, int i){
        left=2*i;
        right=2*i+1;
        if(left <= n && a[left] > a[i]){
            largest=left;
        }
        else{
            largest=i;
        }

        if(right <= n && a[right] > a[largest]){
            largest=right;
        }
        if(largest!=i){
            swap(i,largest);
            heapify(a, largest);
        }
    }

    public static void swap(int i, int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
        }

    public static int[] sort(int []a0){
        a=a0;
        buildheap(a);

        for(int i=n;i>0;i--){
            swap(0, i);
            n=n-1;
            heapify(a, 0);
        }
        return a;
    }

   public static int[] mergeSort(int array[])  {
    if(array.length > 1)     {
        int elementsInA = array.length/2;
        int elementsInB = array.length - elementsInA;
        int arrA[] = new int[elementsInA];
        int arrB[] = new int[elementsInB];

        for(int i = 0; i < elementsInA; i++)
            arrA[i] = array[i];

        for(int i = elementsInA; i < elementsInA + elementsInB; i++)
            arrB[i - elementsInA] = array[i];

        arrA = mergeSort(arrA);
        arrB = mergeSort(arrB);

        int sortedX[] = new int[array.length];
        sortedX= merge(arrA,arrB);

        return sortedX;
        }
    else{
        return array;
        }
    }

    public static int[] merge(int arr1[],int arr2[]){
            int i = 0, j = 0, k = 0;
            int [] AB = new int[arr1.length+arr2.length];

            while(arr1.length != j && arr2.length != k) {
            if(arr1[j] <= arr2[k]) {
                AB[i] = arr1[j];
                i++;
                j++;
            } else {
                AB[i] = arr2[k];
                i++;
                k++;
            }
        }

        while(arr1.length != j) {
            AB[i] = arr1[j];
            i++;
            j++;
        }
        while(arr2.length != k) {
            AB[i] = arr2[k];
            i++;
            k++;
        }

        return AB;
    }

    public static boolean checker(int [] a, int [] b){
    for(int i=0;i<a.length;i++){
            if(a[i]!=b[i]){
            System.out.println("Not the same");
            return false;
            }
            }
            return true;
    }


public static void run(){
Scanner reader = null;
try{
reader = new Scanner(new File("/export/home/notes/ds/fourlines.text"));
}
catch(Exception e){
System.out.println("Error");
}
while(reader.hasNextLine()){
String lines = reader.nextLine();
String [] parts = lines.split(" ");
int[] result = new int[parts.length];
for (int n = 0; n < parts.length; ++n)
{
 result[n] = Integer.parseInt(parts[n]);
}
int [] HSort = sort(result);
int [] Msort = new int[result.length];
       Msort = mergeSort(result);

       if(checker(HSort,Msort)==true){

           String answer1 ="";
           answer1 = Arrays.toString(HSort).replace(",", " ").replace("[", "").replace("]", "");
           System.out.println(answer1);

           String answer2 ="";
           answer2 = Arrays.toString(Msort).replace(",", " ").replace("[", "").replace("]", "");
           System.out.println(answer2);


       }
       else{
           System.out.println("Error");
           }
}
}
    public static void main(String[] args) {
       run();
    }
}
