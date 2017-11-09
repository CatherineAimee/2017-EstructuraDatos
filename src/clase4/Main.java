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
            
        public static void MakeHeap(int values[]){  //convierte un arreglo a una representación Heap
            for(int i =0; i< values.length; i++){
                int index = i;
                while(index != 0){
                    int parent = (index -1)/2;
                    
                    if((values[index]) <= values[parent]){
                    break;
                    }
                    
                    int temp = values[index];
                    values[index] = values[parent];
                    values[parent] = temp;
                    
                    index = parent;
                }
            }   
        }
        
        public static int removeTopItem(int values[], int count){       //quita el elemento raíz y lo reacomoda
            int result = values[0];
            
            values[0] = values[count - 1];      //el valor raiz ahora es lo que estaba en el ultimo nodo
            
            int index = 0;
            while(true){
                int child1 = 2 * index +1;
                int child2 = 2 * index +2;
                
                if(child2 >= count){
                    child2 = index;
                }
                
                if(values[index] >= values[child1] && values[index] >= values[child2]){
                    break;
                }
                
                int swapChild = child1;
                if(values[child2] > values[child1]){
                    swapChild = child2;
                }
                
                int temp = values[index];
                values[index] = values[swapChild];
                values[swapChild] = temp;
                
                index = swapChild;    
            }
            return result;  
        }
        
        public static void Quicksort(int values[], int start, int end){
            // If the list has no more than one element, it’s sorted.
            if(start >= end){       //caso base
                return;
            }
            // Use the first item as the dividing item.         
            int divider = values[start];
            
            // Move items < divider to the front of the array and  items >= divider to the end of the array.
            Stack<Integer> before= new Stack<Integer>();        //creamos dos pilas en la primera van los más chiquicos de divider
            Stack<Integer> after= new Stack<Integer>();         //en la segunda los más grandes
            
            for(int i= start + 1; i<= end; i++){        //se recorre el arreglo
                if(values[i] < divider){            //si el valor es más pequeño que divider 
                    before.push(values[i]);         //se va a la primera pila
                }
                else{
                    after.push(values[i]);          //si no se va a la segunda pila
                }
            }
            
            int i = start;
            while(!before.empty()){
                values[i++] = before.pop();   
            }
            
            int middle = i;
            values[middle] = divider;
            while(after.empty()){
                values[i++]= after.pop();
            }

            
            //Recursively sort the two halves 
            Quicksort(values,start,middle - 1);
            Quicksort(values,middle + 1,end);
        }
        
   
    public static void main(String[]args){
        int[] inputArray={10,4,1,240,1024,23,21,3048,0,8000,1000};
        
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
        
     
      System.out.println(Arrays.toString(inputArray));
      

    } 
    
    
}
		
		
           
        
        
        
    
    

