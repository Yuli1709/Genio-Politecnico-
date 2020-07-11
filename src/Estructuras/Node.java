package Estructuras;

import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CltControl
 * @param <E>
 */
public class Node<E> {
    private E data;
    private Node<E> left;
    private Node<E> right;
    
    public Node(E data){
        this.data=data;
        left=right=null;
    }

    public E getData() {
        return data;
    }

    public Node<E> getLeft() {
        return left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setData(E data) {
        this.data = data;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }
    
    public boolean Replace(E pregunta,E nuevoanimal,boolean izq){ 
        if(pregunta==null||nuevoanimal==null||this.data==null) return false;
            E temp=this.getData();
            this.setData(pregunta);
            Node<E> vn= new Node<>(temp);
            Node<E> nn= new Node<>(nuevoanimal);
            if(izq){
                this.setLeft(nn);
                this.setRight(vn);
            }
            else{
                this.setLeft(vn);
                this.setRight(nn);
            }                          
        return false;
    }

}
