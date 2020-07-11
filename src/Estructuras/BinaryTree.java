package Estructuras;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CltControl
 */
public class BinaryTree<E> {
    private Node<E> root;
        
    public BinaryTree(){
        root=null;
    }
    
    public boolean isEmpty(){
        return root==null;
    }
    
     
    public boolean add(E child, E parent){
        Node<E> nch= new Node<>(child);
        if(child==null) return false;
        else if(parent == null && isEmpty())
            root= nch;
        else if(parent!=null){
            if(searchNode(child)==null){
                Node<E> np= searchNode(parent);
                if(np==null||(np.getLeft())!=null&&np.getRight()!=null)
                    return false;    
                if(np.getRight()==null) np.setRight(nch) ;
                else np.setLeft(nch);
            }
            return true;
        }
        return false;
    }
    
    private Node<E> searchNode(E data){
        return searchNode(data, root);
    }
    
    private Node<E> searchNode(E data, Node<E> n){
        if(n==null){
            return n;
        }else if(n.getData().equals(data)) return n;
        else{
            Node<E> l=searchNode(data,n.getLeft());
            return (l!=null)? l: searchNode(data,n.getRight());
            
        }
    }
    
    
       
    
    public void GuardarArbol(){
        try(BufferedWriter bw=new BufferedWriter(new FileWriter("src/recursos/datos-1.txt"))){
            escribirPosOrden(bw);
            
        }catch(IOException ex){
            System.out.println("No se pudo crear el archivo de clientes");
        }
    }
    
    public  void escribirPosOrden(BufferedWriter bw){
        escribirPosOrden(root,bw);
    }
    private void escribirPosOrden(Node<E> n,BufferedWriter bw){
        if(n!=null){
            escribirPosOrden(n.getLeft(),bw);
            escribirPosOrden(n.getRight(),bw);
            if(n.getLeft()==null||n.getRight()==null){
            try {
                bw.write("#R "+(String) n.getData());
                bw.newLine();
            } catch (IOException ex) {
                System.out.println("No se pudo crear el archivo del arbol");
            }
                
            }else{
                
                try {
                bw.write("#P "+(String) n.getData());
                bw.newLine();
            } catch (IOException ex) {
                System.out.println("No se pudo crear el archivo del arbol");
            }
                
            }
            System.out.println(n.getData());
            
        }
    }
    
    
    public int height(){
        return height(root);
    }
    
    private int height(Node<E> n){
        if(n==null) return 0;
        return 1+Math.max(height(n.getLeft()), height(n.getRight()));
    }
    
    public int totalNodos(){
        return totalNodos(root);
    }
    
    private int totalNodos(Node<E> n){
        if (n==null) return 0;
        return 1 + totalNodos(n.getLeft())+ totalNodos(n.getRight());
    }
    
    public int contarHojas(){
        return contarHojas(root);
    }
    
    private int contarHojas(Node<E> n){
        if(n==null) return 0;
        else if(n.getLeft()==null && n.getRight()==null) return 1;
        return contarHojas(n.getLeft())+ contarHojas(n.getRight());
    }
    
    public boolean isFull(){
        return isFull(root);
    }
    
    private boolean isFull(Node<E> n){
        if(n==null) return true;
        //decir que n tiene 2 hijos no es suficiente para decir que el arbol está lleno
        else if((n.getLeft()==null||n.getRight()!=null)||(n.getLeft()!=null||n.getRight()==null)) return false;
        else return (isFull(n.getLeft()) && isFull(n.getRight())&& (height(n.getLeft())== height(n.getRight())));
    }
    
    //recorrido de árboles: por anchura y por profundidad
    //Anchura: por nivel a nivel, se puede hacer con una cola.
    //Profundidad: preorden, enorden, postorden
 
    public void posOrden(){
        posOrden(root);
    }
    private void posOrden(Node<E> n){
        if(n!=null){
            posOrden(n.getLeft());
            posOrden(n.getRight());
            System.out.println(n.getData());
        }
    }
    
    public void preOrden(){
        preOrden(root);
    }
    private void preOrden(Node<E> n){
        if(n!=null){
            System.out.println(n.getData());
            preOrden(n.getLeft());
            preOrden(n.getRight());
            
        }
    }
    
    public void enOrden(){
        enOrden(root);
    }
    private void enOrden(Node<E> n){
        if(n!=null){
            enOrden(n.getLeft());
            System.out.println(n.getData());            
            enOrden(n.getRight());            
        }
    }

    public Node<E> getRoot() {
        return root;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.root);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==null || !(obj instanceof BinaryTree)) 
           return false;
        BinaryTree<E> other = (BinaryTree<E>) obj;
        Node<E> q=other.root;
        Node<E> p=this.root;
        if(q.getData().equals(p.getData()))
            return true;
        else if (p.getLeft() == null || p.getLeft().equals(q.getLeft())) {
            return false;
        }
        else if (p.getRight() == null || p.getRight().equals(q.getRight())) {
            return false;        
        }
        return true;
    }
    

    public void cargarDatosArbol(){
        List<String[]> lista = new ArrayList<>();
        try(BufferedReader br= new BufferedReader(new FileReader("src/recursos/datos-1.txt"))){
            String linea;
            while((linea=br.readLine())!=null){
                String[] datos=linea.split(" ");
                String string= new String();
                for (int i=1;i<datos.length;i++){   
                    if(i==datos.length-1)string=string+datos[i];
                    else{
                        string=string+datos[i]+" ";
                    }
                    
                    
                }
                String[] lint= new String[2];
                lint[0]=datos[0];
                lint[1]=string;             
                lista.add(lint);
            }
        }
        catch(IOException ex){
            System.err.println("No se pudo leer el archivo de clientes");
        }
        
        
        
        Stack<Node> pila= new Stack();
        for (String[] s: lista){                    
            if (s[0].equals("#R")){
                Node<String> nResp= new Node(s[1]);
                pila.add(nResp);
            }else{
                Node<String> nPreg= new Node(s[1]);
                Node n= pila.pop();
                Node n2= pila.pop();
                nPreg.setRight(n);
                nPreg.setLeft(n2);
                pila.add(nPreg);                
            }
               
        }
        Node raiz= pila.pop();
        this.root=raiz;
        
    }

        
}
