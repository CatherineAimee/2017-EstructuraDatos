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
public class IntergerNode {
    public int value;
    public IntergerNode next;
    
    
    public IntergerNode (){         //para crear nodo centinela
        value = 0;
        next = null;
    }
    
    public IntergerNode(int value){
        this.value = value;
        next= null;
    }
    
    
    
}
