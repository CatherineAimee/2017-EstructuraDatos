/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica02;

import Clase2.SNode;
import java.util.NoSuchElementException;

/**
 *
 * @author Neil
 */
public class SLinkedList<E> implements List<E> {
	private SNode<E> top;
	private int size;
	
	public SLinkedList() {
		top = new SNode<E>();
		size = 0;
	}

	@Override
	public void addFirst(E e) {
            SNode<E> newNode = new SNode <E>(e);
            newNode.next = top.next;
            top.next = newNode;
            size++;	
	}

	@Override
	public void addLast(E e) {
            SNode<E> newNode =  new SNode<E>(e);
       
            SNode<E> current = top;
            while(current.next != null)
           current = current.next;
       
           current.next = newNode;
           size++;
	
	}

	@Override
	public void add(int index, E element) {
            SNode<E> newNode =  new SNode<E>(element);      //crea un nodo nuevo con elemento que resive
            SNode<E> current = top;                     //el actual es top
            for(int i=0; i < index; i++)            //recorre la lista hasta ANTES de llegar al indice que mando
                current = current.next;                 //cada que reccore la lista current se mueve 1 hacia adelante
            current.next = newNode;             //una vez que llega al indice que quiero al nodo que sigue agrego el que cree
	}

	@Override
	public E removeFirst() {
		if(top.next == null){
            throw new NoSuchElementException();
        }
        SNode<E> nodeToRemove=top.next;
        top.next = nodeToRemove.next;
        nodeToRemove.next = null;
        size--;
        return nodeToRemove.value;
        } 

	@Override
	public E removeLast() {
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

	@Override
	public E remove(int index) {
            
            if(index < 0 || index >= size())
                throw new IndexOutOfBoundsException();     
            
            SNode<E> current = top;     //
            for(int i=0; i < index; i++)
                current = current.next;
            
            SNode<E> removed = current.next;
            current.next = current.next.next;
            
            return removed.value;   
	}

	@Override
	public boolean remove(Object o) {
            int index = 0;
            for(SNode<E> x = top.next; x != null; x = x.next){
                if(o == x.value)
                    break;
                return true;
            
            
            
            }
        }

	@Override
	public E getFirst() {
		if(top.next == null) {
                    throw new NoSuchElementException();
		}	
        return top.next.value;
        }
	

	@Override
	public E getLast() {
            if(top.next == null){
            throw new NoSuchElementException();
        }
        SNode<E> current = top;
        while(current.next != null)
           current = current.next;
        return current.value;
    
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int indexOf(Object o) {
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

	@Override
	public void clear() {
            top.next = null;
		size = 0;
	}
        

	@Override
	public int size() {
            return size;
	}

	@Override
	public boolean isEmpty() {
            return size() == 0;
        }

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
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
