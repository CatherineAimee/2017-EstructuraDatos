/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase2;

/**
 *
 * @author Neil
 */
public class IntegerLinkList {
    
    public IntergerNode top = null;
    
    public IntegerLinkList(){
        top = new IntergerNode();      
    }
    
    public void addFirst(int element){
        IntergerNode newNode = new IntergerNode(element); //segundo constructor que crea nodo con elemento y que apunta a null
        newNode.next = top.next;
        top.next = newNode;  //cuando creas un nuevo nodo le dices que apunte a lo que sea que apunta top y despues que top apunte al nuevo nodo    
    }
    
    public void addLast(int element){
        IntergerNode newNode = new IntergerNode(element);
        
        IntergerNode current = top;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }
    
    public String toString(){
        if(top.next ==null)
            return"[ ]";
        
        IntergerNode current = top.next;
        String returnValue = "[" + current.value;       //solo hay un elemento en la lista
        
        while(current.next != null){
            current = current.next;
            returnValue += ", " + current.value;
        }
        returnValue += "]"; 
        return returnValue;
    }
    
    
    
    
    
}
