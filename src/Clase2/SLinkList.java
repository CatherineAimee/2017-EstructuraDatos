/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase2;

import java.util.NoSuchElementException;

/**
 *
 * @author Neil
 */
public class SLinkList <E> {
    
    private SNode <E> top;
    private int size;
    
    
    public SLinkList(){
        top = new SNode <E>();
        size = 0;
    }
    
    public void addFirst(E e){
        SNode<E> newNode = new SNode <E>(e);
        newNode.next = top.next;
        top.next = newNode;
        size++;
    }
    
    public void addLast(E e){
       SNode<E> newNode =  new SNode<E>(e);
       
       SNode<E> current = top;
       while(current.next != null)
           current = current.next;
       
       current.next = newNode;
       size++;
    }
    

    public E removeFirst(){
        if(top.next == null){
            throw new NoSuchElementException();
        }
        SNode<E> nodeToRemove=top.next;
        top.next = nodeToRemove.next;
        nodeToRemove.next = null;
        size--;
        return nodeToRemove.value;
    } 
    
    public E removeLast(){
        if(top.next == null){
            throw new NoSuchElementException();
        }
        SNode<E> current = top;
        while(current.next.next != null)
           current = current.next;
        
        SNode<E> nodeToRemove = current.next;
        current.next = null;
        size--;
        return nodeToRemove.value;  
    }
        
    public E getFirst() {
		if(top.next == null) {
                    throw new NoSuchElementException();
		}	
        return top.next.value;
    }
    
    public E getLast(){
        if(top.next == null){
            throw new NoSuchElementException();
        }
        SNode<E> current = top;
        while(current.next != null)
           current = current.next;
        return current.value;
    }
    
    public int indexOf(Object o){
        int index = 0;
        if(o == null){          //este if es para preguntar si hay null y estoy buscando null
            for(SNode<E> x = top.next; x != null; x = x.next){
                if(x.value == null)
                    return index;
                index++; 
            }   
        }
            
        else{                   //este else es para cuando está buscando un valor
            for(SNode<E> x = top.next;x != null; x= x.next){
                if(o.equals(x.value))
                    return index;
                index++;
            }   
        }
        return -1;  
    }
    
    public void clear() {
		top.next = null;
		size = 0;
	}
    
    public int Size(){
        return size;
    }
    
    public boolean isEmpty(){
        return Size() == 0;
    }
    
    public String toString() {
		if(top.next == null)
			return "[]";
		
		SNode<E> current = top.next;
		String returnValue = "[" + current.value;
		while(current.next != null) {
			current = current.next;
			returnValue += ", " + current.value;
		}
		
		returnValue += "]";
		return returnValue;
    }
                        
}
