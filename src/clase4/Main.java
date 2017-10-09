/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase4;

import java.util.Arrays;

/**
 *
 * @author Neil
 */
public class Main {
    
    public int LinearSearch(int Values[],int Target){
            for(int i=0; i<Values.length;i++){
                if(Values[i] == Target)
                    return i;
            
                if(Values[i] > Target)
                    i++;
                    return -1;
            }
            return -1;
        }
        
        public int BinarySearch(int Values[], int Target){
            int min = 0;
            int max = (Values.length) -1;
            int mid = 0;
            
            while(min<= max)
                mid = (min + max)/2;
            
                if(Target < Values[mid])
                    max = mid -1;
                
                if(Target> Values[mid])
                    min = mid +1;
                
                else
                    return mid;
                
            return -1;
        }
        
        public static void Insertionsort(int values[]){
            
            
            int save = 0;     
            for (int i = 1; i<values.length;i++){
                for(int j=0; j<i ;j++){
                    if(j < i && values[j] > values[i]){
                        
                        save = values[i];
                        
                        shiftRight(values,j,i);
                        
                        values[j] = save;
                    } 
                }
            }
        }
        
        public static void shiftRight(int values[], int start,int end){
            //empieza desde j y termina en uno menor a i
            
            for(int i=end; i> start;i--) 
                values[i] = values[i-1];          
        }
        
        public static void Selectionsort( int values[]){
            int smallest;
            int ind;
            int x;
            
            for(int i=0; i < values.length;i++){
                smallest = values[i];
                ind = i;
                x = values[i];
                for(int j=i; j< values.length; j++){
                    
                    if(values[j] <= smallest){
                        smallest = values[j];
                        ind = j;
                    } 
                    
                }
                values[i] = smallest;
                values[ind] = x;   
            }
        }
        
        public static void Bubblesort(int values[]){
            Boolean notSorted = true;
            int temp;
            while(notSorted){
                //Assume we won´ find a pair to swap
                notSorted = false;
                
                for( int i = 1; i< values.length;i++){
                    if(values[i] < values[i-1]){
                        temp = values[i];
                        values[i] = values[i-1];
                        values[i-1] = temp;
                        
                        notSorted = true; 
                    }
                }
            }
        }
            
        
        
    public static void main(String[]args){
        int[] inputArray={4,5,1,2,3};
        
        /*Stack<Integer> iStack = new Stack<Integer>();
        
        for(int i=0; i<inputArray.length; i++)
           iStack.push(inputArray[i]);
        
        int[] outputArray = new int[inputArray.length];
		for(int i=0; i<inputArray.length; i++)
			outputArray[i] = iStack.pop();
		
		System.out.println(Arrays.toString(outputArray));
                
                
        int[] inputTren={3,2,1,3,2};
       
        Stack<Integer> InputTrack = new Stack<Integer>();
        
        for(int i=0; i<inputTren.length; i++)
           InputTrack.push(inputTren[i]);
                
        int[] HoldingTrack1 = new int[inputTren.length];
        
        int[] HoldingTrack2 = new int[inputTren.length];
        
        int[] OutputTrack = new int[inputTren.length];
        
        for(int i=0; i<inputTren.length; i++){
            if(inputTren.peek() ==3)
                HoldingTrack1.push(inputTren[i]);
                
                
        }*/
        
      
    
      
      Bubblesort(inputArray);
      System.out.println(Arrays.toString(inputArray));

    } 
    
    
}
		
		
           
        
        
        
    
    

