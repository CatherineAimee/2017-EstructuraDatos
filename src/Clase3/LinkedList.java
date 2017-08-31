/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase3;

import Clase2.SNode;
import java.util.NoSuchElementException;
import practica02.List;

/**
 *
 * @author Neil
 */
public class LinkedList<E> implements List {
    private Node<E> header;
    private int size;
    
    public LinkedList(){
        header = new Node<E> ();
        size = 0;
    }
   
    private Node<E> node(int index){ //Va a regresar el nodo en el indice especificado, el paramatetro es el indice del nodo que queremos y arroja @IndexOutOfBounceException si el indice es out of range
        if(index < 0 || index >= size()){
            throw new IndexOutOfBounceException();
        }
        
        if(index < (size >> 1)){
            //significa que el elemento está en la primera mitad de y se recorre del inicio hacia adelante
            Node<E> x= header.next;
            for(int i=0; i< index; i++)
                x = x.next;
            return x;
        }
        else{
            //significa que el elemento está en la segunda mitad y se recorre del final hacia atrás
            Node<E> x= header.prev;
            for(int i= size -1; i>index; i--)
                x = x.prev;
            return x;
            
        }
        return null;
    
        
    }
    
    public void addFirst(E e){
        Node<E> newElement = new Node<E>(e);
        
        Node<E> firstElement = header.next;
        newElement.next = firstElement;
        firstElement.prev = newElement;
        
        newElement.prev = header;
        header.next = newElement;
        
        size++;    
    }
    
        public void add(int index, E element){
        if(index < 0 || index > size()){
            throw new IndexOutBoundsException();
        }
        
        Node<E> newNode = new Node<E>(element);
        Node<E> current = node(index);
        Node<E> previousNode = current.prev;
        
        newNode.prev = previousNode;
        previousNode.next = newNode;
        
        newNode.next = current;
        current.prev= newNode;
    }
    
    

	@Override
	public E removeFirst() {
		if(header.next == null){
            throw new NoSuchElementException();
        }
        Node<E> nodeToRemove=header.next;
        header.next = nodeToRemove.next;
        nodeToRemove.next = null;
        size--;
        return nodeToRemove.value;
        } 

	@Override
	public E removeLast() {
		if(header.next == null){
            throw new NoSuchElementException();
        }
        Node<E> current = header;
        while(current.next.next != null)
           current = current.next;
        
        Node<E> nodeToRemove = current.next;
        current.next = null;
        size--;
        return nodeToRemove.value;  
        }

	@Override
	public E remove(int index) {
		if(index < 0 || index >= size())
                throw new IndexOutOfBoundsException();     
            
            Node<E> current = header;     //
            for(int i=0; i < index; i++)
                current = current.next;
            
            Node<E> removed = current.next;
            current.next = current.next.next;
            
            return removed.value;   
	}


	@Override
	public boolean remove(Object o) {
            int index = indexOf(o);
            if(index >= 0 && index < size)
                
            return true;
	}

	@Override
	public E getFirst() {
		if(header.next == null) {
                    throw new NoSuchElementException();
		}	
        return header.next.value;
        }

	@Override
	public E getLast() {
            if(header.next == null){
            throw new NoSuchElementException();
        }
        Node<E> current = header;
        while(current.next != null)
           current = current.next;
        return current.value;
    
	}

	@Override
	public E get(int index) {
            Node<E> current = header;                     
            for(int i=0; i < index; i++)            
                current = current.next; 
            return current.next.value;
	}

	@Override
	public E set(int index, E element) {
            if(index < 0 || index > size()) {
                    throw new IndexOutOfBoundsException();
                }
                Node<E> newNode = new Node<E>(element);
                Node<E> current = node(index);
                Node<E> nextNode = current.next;
                Node<E> prevNode = current.prev;
                
                newNode.next = nextNode;
                nextNode.prev = newNode;
                
                newNode.prev = prevNode;
                prevNode.next = newNode;
                
		return current.value;
	}

	@Override
	public boolean contains(E e) {
            Node<E> current = header.next;
		while(current != header) {
			if(current.value == e)
				return true;
			current = current.next;
		}	
		return false;
        }


	@Override
	public int indexOf(Object o) {
		int index = 0;
		
		if(o == null) {
			for(Node<E> x = header.next; x != header; x = x.next) {
				if(x.value == null)
					return index;
				index++;
			}
		}
		else {
			for(Node<E> x = header.next; x != header; x = x.next) {
				if(o.equals(x.value))
					return index;
				index++;
			}
		}
                return -1;
	}

	@Override
	public void clear() {
		header.next = header;
                size = 0;	
	}


	@Override
	public int size() {
            return size;
	}

	@Override
	public boolean isEmpty() {
		if(header.next == header){
                    return true;
                }
                return false;
	}

	@Override
	public Object[] toArray() {
            Object[] returnArray = new Object[size];
		
            int i = 0;
		for(Node<E> x = header.next; x.next != header; x = x.next)
			returnArray[i++] = x.value;
		
		return returnArray;
        }
	
	
	@Override
	public String toString() {
            if (header.next == header) {
            return "[]";
        }

        Node<E> current = header.next;
        String returnValue = "[" + current.value;
        while (current.next != header) {
            current = current.next;
            returnValue += ", " + current.value;
        }

        returnValue += "]";
        return returnValue;
    }

    
    
    
}
