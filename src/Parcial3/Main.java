/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial3;

import Clase3.LinkedList;


/**
 *
 * @author Neil
 */
public class Main {
    
    public static String allStar(String str){
        
      if (str.equals("") || str.length() == 1){     //si la str solo tiene un elemento va a regresar solo ese elemento
          return str;
      } 
      else{
          return str.charAt(0) + "*" + allStar(str.substring(1));   // si no regresa el primer caracter + * + string por los demas caracteres
      }
    }
    
    public static String endX(String str){
        if (str.length() == 0){
            return str;
        }
        if (str.charAt(0) == 'x'){
            return endX(str.substring(1)) + "x";
        }
        else{
            return str.charAt(0) + endX(str.substring(1));
        }
    }
    
    public static LinkedList<Integer> intersect(LinkedList<Integer> list1, LinkedList<Integer> list2){
        LinkedList <Integer> Union= new LinkedList<>();
        
        for(int i = 0; i<list1.size() ;i++){    // recorro lista 1
            if(list2.contains(i)){      // si la lista 2 CONTIENE el elemento de la lista 1 
                Union.addFirst(i);      //se agrega ese elemento a la lista nueva 
                    
            }        
        }
    return Union; 
    }
    
    public static LinkedList<Integer> difference(LinkedList<Integer> list1, LinkedList<Integer> list2){
        LinkedList <Integer> Diferencia= new LinkedList<>();
        
        for(int i = 0; i<list1.size() ;i++){
            if(!list2.contains(i)){
                Diferencia.addFirst(i);
                    
            }        
        }
    return Diferencia; 
    }
    
    public static int shapeArea(int n){
        if(n == 1){
            return 1;
        }
        else{
            return shapeArea(n-1) + (4*(n-1));
        }
    }
             
   public static void main(String str){
    
    
    System.out.println(allStar("hello"));
    
    System.out.println(endX("a"));
    
    
    }
    
    

}