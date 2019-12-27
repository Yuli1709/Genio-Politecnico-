
package geniopolitécnico;

import Estructuras.BinaryTree;
import Estructuras.Node;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author PC
 */
public class GenioPolitécnico {

    /**
     * @return lista lde dos elementos: identificador (#P O#R) y la información
     */
    public static List<String[]> cargarDatos(){
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
        return lista;
    } 
    
    public static void Adivinar(Node n){
        if(n.getRight()!=null&&n.getLeft()!=null){
            Scanner sc= new Scanner(System.in);
            String respuesta= new String();
            System.out.println(n.getData());
            respuesta= sc.nextLine();
            if(respuesta.equals("si"))Adivinar(n.getLeft());
            else Adivinar(n.getRight());
                            
        }
        else{
            Scanner sc= new Scanner(System.in);
            String pregunta= new String();
            String respuesta= new String();
            String animal= new String();
            System.out.println("¿"+n.getData()+"?");
            respuesta= sc.nextLine();
            if(respuesta.equals("si")) System.out.println("Yay he adivinado!");
            else{
                System.out.println("Oh:( Ayudame a mejorar mi predicción\n¿Que animal estabas pensando?");
                /*animal = sc.nextLine();
                System.out.println("Escribe una pregunta que me permita diferenciar entre un "+n.getData() +" y un"+animal);
                pregunta = sc.nextLine();                */
            }
        }
    }
    
    
        
    public static void main(String[] args){        
        List<String[]> listDatos=cargarDatos();
        BinaryTree bt= new BinaryTree();
        bt.cargarDatosArbol(listDatos);
        Adivinar(bt.getRoot());
        
        }
        
       
        
        
    }
    

