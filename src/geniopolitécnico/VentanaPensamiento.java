/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geniopolitécnico;

import Estructuras.BinaryTree;
import Estructuras.Node;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author PC
 */
public class VentanaPensamiento {
    private Pane root;  
    private StackPane onrootyes;
    private StackPane onrootno;
    private Pane decision;
    private BinaryTree arbol;
    private Font f = cargarFuente();
    
    Label pregunta;
    
    
    public VentanaPensamiento(){
        
        
        List<String[]> listDatos=GenioPolitécnico.cargarDatos();
        arbol= new BinaryTree();
        arbol.cargarDatosArbol(listDatos);        
        root= new Pane();
        ImageView fondo =new ImageView( new Image("/recursos/stage.jpg"));
        Pane contenedorPregunta = new Pane();
        ImageView imvpregunta =new ImageView( new Image("/recursos/preguntaImagen.png"));
        imvpregunta.setFitWidth(600);
        imvpregunta.setFitHeight(170); 
        contenedorPregunta.setLayoutX(200);
        contenedorPregunta.setLayoutY(0);
        pregunta= new Label();
        pregunta.setFont(f);
        pregunta.setLayoutX(50);
        pregunta.setLayoutY(50);
        contenedorPregunta.getChildren().addAll(imvpregunta,pregunta);      
        fondo.setFitWidth(800);
        fondo.setFitHeight(500);    
        ImageView genio =new ImageView( new Image("/recursos/genioPregunta.png"));
        genio.setFitWidth(278);
        genio.setFitHeight(400);    
        genio.setLayoutX(40);
        genio.setLayoutY(70);
        decision = sectorDecision();
        decision.setLayoutX(400);
        decision.setLayoutY(150);
        
        root.getChildren().addAll(fondo,genio,contenedorPregunta,decision);
        Adivinar(arbol.getRoot());
        
        
    }
    
    public Pane sectorDecision(){
        VBox pane= new VBox();
        pane.setSpacing(20);
        onrootyes= new StackPane();
        onrootno = new StackPane();        
        ImageView yesimage =new ImageView( new Image("/recursos/yesimage.png"));
        ImageView noimage =new ImageView( new Image("/recursos/noimage.png"));
        ImageView yesimagePressed =new ImageView( new Image("/recursos/yespressed.png"));
        ImageView noimagePressed =new ImageView( new Image("/recursos/nopressed.png"));
        yesimage.setFitWidth(200);
        yesimage.setFitHeight(100); 
        yesimagePressed.setFitWidth(200);
        yesimagePressed.setFitHeight(100); 
        noimage.setFitWidth(200);
        noimage.setFitHeight(100); 
        noimagePressed.setFitWidth(200);
        noimagePressed.setFitHeight(100);
        
        onrootyes.getChildren().add(yesimage);
        
        onrootyes.setOnMouseEntered((e)->{
            onrootyes.getChildren().clear();
            onrootyes.getChildren().add(yesimagePressed);
        });
        onrootyes.setOnMouseExited((e)->{
            onrootyes.getChildren().clear();
            onrootyes.getChildren().add(yesimage);
        });
        
        onrootno.getChildren().add(noimage);
        onrootno.setOnMouseEntered((e)->{
            onrootno.getChildren().clear();
            onrootno.getChildren().add(noimagePressed);
        });
        onrootno.setOnMouseExited((e)->{
            onrootno.getChildren().clear();
            onrootno.getChildren().add(noimage);
        });
       
        pane.getChildren().addAll(onrootyes,onrootno);
        return pane;
    }
    
     public void Adivinar(Node<String> n){
        if(n.getRight()!=null&&n.getLeft()!=null){            
            pregunta.setText(n.getData());
            onrootyes.setOnMouseClicked((e)->{
                Adivinar(n.getLeft());
            });
            onrootno.setOnMouseClicked((e)->{
                Adivinar(n.getRight());
            });
                            
        }
        else{
            pregunta.setText("He adivinado: "+"¿"+n.getData()+"?"); 
            onrootyes.setOnMouseClicked((e)->{
                decision.getChildren().clear();
            });
            onrootno.setOnMouseClicked((e)->{
                decision.getChildren().clear();
            });
            }
        
    }
     
     public Font cargarFuente(){
         Font f= null;
        try {
             f = Font.loadFont(new FileInputStream(new File("src/recursos/Minecraft.ttf")), 24);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VentanaPensamiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
     }

    public Pane getRoot() {
        return root;
    }
    
    
}
