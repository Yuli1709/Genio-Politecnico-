/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geniopolitécnico;

import Estructuras.BinaryTree;
import Estructuras.Node;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author PC
 */
public class GenioPolitécnico {

    /**
     * @return 
     */
    public static List<String[]> cargarDatos(){
        List<String[]> lista = new ArrayList<>();
        try(BufferedReader br= new BufferedReader(new FileReader("src/recursos/datos-1.txt"))){
            String linea;
            while((linea=br.readLine())!=null){
                String[] datos=linea.split(" ");
                lista.add(datos);
            }
        }
        catch(IOException ex){
            System.err.println("No se pudo leer el archivo de clientes");
        }
        return lista;
    }
    // este obteiene la lista de strings y lo separa en identificador (#P O#R) y la información
     public static List<String[]> darFormato(List<String[]> l){
         List<String[]> lista = new ArrayList<>();
         for(String[] s: l){
             String[] lint= new String[2];
             String string= new String();
             for (int i=1;i<s.length;i++){
                string=string+" "+s[i];
             }
             lint[0]=s[0];
             lint[1]=string;             
             lista.add(lint);
         }
         
         return lista;
     }
    
    
    public static void main(String[] args){
        Stack<Node> pila= new Stack(); 
        List<String[]> listDatos=cargarDatos();
        
        List<String[]> datos = darFormato(listDatos);
        
        for (String[] s: datos){                    
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
        
        Node<String> raiz= pila.pop();
        System.out.println(raiz.getData());
            
              
        
       
              
        
        
    }
    
}
