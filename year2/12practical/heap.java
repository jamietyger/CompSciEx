/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package heaps;

import java.util.Arrays;

/**
 *
 * @author southgate
 */
public class heap {
  
private int[] A;
    

public heap(){
    
}

public heap(int input[]){
   A = input;
            
}

    
    public void buildHeapBottomUp(int[] in){
      
     int size = in.length;
     
  				
	for(int i=size/2-1; i>=0; i--) 		
	{
   		heapify(i);				

	}

  
       
      
        
    }
    
    public void buildHeapTopDown(int[] in){
          int left, right, max, tmp;	
          int parent =0;
          right = 2*parent+2;
          left = 2*parent +1;
        int[] heap = new int[in.length];
        while(right<in.length){
        
        for(int i=0;i<in.length;i++){
          
            
            if (A[parent]<A[left]){
                
                tmp = A[parent];
                A[parent] = A[left];
                A[left] = tmp;
            }
            else if(A[parent]<A[right]){
              
                
                tmp = A[parent];
                A[parent] = A[right];
                A[right] = tmp;
            }
            else{
                parent++;
                right = 2*parent+2;
                left = 2*parent +1;
                if (right > A.length){
                    right = left;
                }
            }
                    
                
            }
        }
        
        
    }

public void heapify(int i){
    int left, right, max, tmp;			
    int size  = A.length;

	left = 2 * i + 1;  			
	right = 2 * i + 2;       			

  	if(left < size && A[left] > A[i])		
     		max = left;             	
  	else
  	   	max = i;

  	if(right < size && A[right] > A[max])
     		max = right;           		

  	if(max != i)	 			
  	{
      		tmp = A[i];      		
      		A[i] = A[max];
      		A[max] = tmp;
      		heapify(max); 			

     	}

   }
   

    
    
    public static void main(String[] args){
      
        int[] heap1 = {12,3,5,7,10,11,23};
        int [] heap2 = {6,18,17,2,1,9,14,12,3,5,7,10,11,23,15};
        int [] heap3 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int [] heap4 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};        
        
        heap test = new heap(heap1);
        test.buildHeapBottomUp(heap1);
        System.out.println(Arrays.toString(test.A));
        heap test2 = new heap(heap2);
        test2.buildHeapBottomUp(heap2);
        System.out.println(Arrays.toString(test2.A));
        heap test3 = new heap(heap3);
        test3.buildHeapBottomUp(heap3);
        System.out.println(Arrays.toString(test3.A));
         heap test4 = new heap(heap4);
        test4.buildHeapBottomUp(heap4);
        System.out.println(Arrays.toString(test4.A));
    }

}
