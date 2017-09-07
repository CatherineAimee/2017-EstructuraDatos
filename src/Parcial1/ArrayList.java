/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial1;

/**
 *
 * @author Neil
 */
public class ArrayList<E> implements List<E> {
	public Object[] top;
	private int size;
	private int initialCapacity = 5;
	private int extraCapacity = 5;
	
	/**
	 * Creates a new ArrayList instance with the default initial capacity.
	 */
	public ArrayList() {
		top = new Object[initialCapacity];
		size = 0;
	}
	
	/**
	 * Increases the capacity of this ArrayList instance so that it 
	 * can hold at least extraCapacity elements more.
	 * This method allocates a new array with greater capacity than the
	 * current one (top.length + extraCapacity) and copies all elements
	 * from top to the newly allocated array. The reference top is then
	 * updated to point to the new array. 
	 * @param extraCapacity increase the capacity of this ArrayList by this amount
	 */
	private void reserveExtraCapacity(int extraCapacity) {
            Object[] newObject = new Object [top.length+extraCapacity];    //se crea un nuevo arreglo de la capacidad actual + extracapacity

            for(int i =0; i<=newObject.length;i++){         //se recorre el todo el arreglo 
                newObject[i] = top[i];                      // se va a copiar cada elemento de top al nuevo objecto    
            }
            top=newObject;
	}
	
	/**
	 * Increases the capacity of this list if its size equals the length of the array
	 * where the data is stored. This method calls reserveExtraCapacity when (size() >= top.length).
	 * reserveExtraCapacity is called using the instance variable extraCapacity.
	 */
	private void ensureCapacity() {         //va a asegurar que nunca se quede sin espacio
            if(size()>=top.length)                  // si el tamaño ocupado es mayor o igual al tamaño normal
                reserveExtraCapacity(extraCapacity);           // se crea nuevo objeto + extraCapacity
	}
	
	/**
	 * Shifts elements in the array (top) to the right, starting at the given position.
	 * @param index the position in which the shift will begin
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
	 */
	private void shiftContentsRight(int index) {
            if( index < 0 || index > size() )       //arroja una excepcion se el indice es mayor al tamaño
                throw new IndexOutOfBoundsException();
            
            ensureCapacity();           // comprobamos que haya espacio para recorrer a la derecha
                   
            for(int i=size-1; i>=index;i--) //se recorre la lista desde el final
                top[i+1] = top[i];          //se actualiza el valor de la derecha al valor actual
    
        }

	@Override
        
	public void addFirst(E e) {
            shiftContentsRight(0);
            top[0] = e;   
            size++;
	}

	@Override
	public void addLast(E e) {
            ensureCapacity();       //aseguramos capacidad    
            top[size()+1]=e;
            size++;
	}

	@Override
	public void add(int index, E element) {
	}

	@Override
	public E getFirst() {
		return null;
	}

	
	@Override
	public E getLast() {
		return null;
	}

	
	@Override
	public E get(int index) {
		return null;
	}

	@Override
	public E set(int index, E element) {
		return null;
	}

	@Override
	public void clear() {
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	public String toString() {
		return null;
	}
}
