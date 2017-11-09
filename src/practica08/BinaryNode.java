/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica08;

import Practica07FP.Queue;
import clase4.Stack;

/**
 *
 * @author Neil
 */
public class BinaryNode {
    public int value;
    
    public BinaryNode leftChild;
    public BinaryNode rightChild;
    
    public BinaryNode(int value){
        this.value = value;
        leftChild = null;
        rightChild = null;
    }
    
    public void preorderTraversal(){
        preorder(this);
    }  
    
    public void preorder(BinaryNode node){
        System.out.print(node.value);
        
        if(node.leftChild != null ){
            preorder(node.leftChild);    
        }
        if(node.rightChild!= null){
            preorder(node.rightChild);
        }
    }
    
    public void inorderTraversal(){
        inorder(this);    
    }
    
    public void inorder(BinaryNode node){
        if(node.leftChild != null){
            inorder(node.leftChild);
        }
        System.out.print(node.value);
        
        if(node.rightChild != null){
            inorder(node.rightChild);
        }
    }
    
    public void postorderTraversal(){
        postorder(this);       
    }
    
    public void postorder(BinaryNode node){
        if(node.leftChild != null){
            postorder(node.leftChild);
        }
        
        if(node.rightChild != null){
            postorder(node.rightChild);
        }
        
        System.out.print(node.value);
    }
    
    
    public void depthFirstTraversal(BinaryNode node){
        
        Queue<BinaryNode> q;q = new Queue<BinaryNode>();        
        q.offer(node);
       
        while(!q.isEmpty()){
            
            if(q.element().leftChild != null){
                q.offer(q.element().leftChild);              
            }
            
            if(q.element().rightChild != null){
                q.offer(q.element().rightChild);              
            }
            System.out.print(q.remove());
        }      
    }
}
