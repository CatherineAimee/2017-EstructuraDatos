/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursion;

/**
 *
 * @author Neil
 */
public class Main {
    public int bunnyEars(int bunnies) {
        if(bunnies == 0){
          return 0;
        }
        if(bunnies == 1){
          return 2;
        }
        if(bunnies==2){
          return 4;
        }
        else{
          return bunnyEars(bunnies -1) + 2;
        }
    }
    public int fibonacci(int n) {
        if(n == 0){
          return 0;
        }
        if(n==1){
          return 1;
        }
        if(n == 2){
          return 1;
        }
        else{
          return fibonacci(n-1) + fibonacci(n-2);
        }
    }
    
    public int bunnyEars2(int bunnies) {
        if(bunnies == 0){
          return 0;
        }
        else{
          if (bunnies%2 == 0){
            return bunnyEars2(bunnies - 1) + 3;
          }
          else{
            return bunnyEars2(bunnies -1) + 2;
          }
        }
     }
    
    public int triangle(int rows) {
        if(rows == 0){
          return 0;
        }
        else{
          return triangle(rows - 1) + rows;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
