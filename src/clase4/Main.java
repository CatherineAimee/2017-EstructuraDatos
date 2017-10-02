/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase4;

/**
 *
 * @author Neil
 */
public class Main {
    public static void main(String[]args){
        int[] inputArray={1,2,3,4,5};
        
        Stack<Integer> iStack = new Stack<Integer>();
        
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
                
                
        }
        
        public int LinearSearch(Data Values[],Data Target){
            for(int i=0; i<Values.lenght;i++)
                if(Values[i] == Target)
                    return i;
            
                if(Values[i] > Target)
                    return -1;
                i++;
            
                
        
           
    }



        
        

        
        
                
        
	}
		
		
           
        
        
        
    
    

