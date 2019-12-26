package Estructuras;

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
    
}
