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
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.StageStyle;
import javafx.util.Duration;

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
    private Font f = cargarFuente(50);
    private Font f2 = cargarFuente(30);
    
    Label pregunta;
    
    
    public VentanaPensamiento(){
        
        
        //List<String[]> listDatos=GenioPolitécnico.cargarDatos();
        arbol= new BinaryTree();
        arbol.cargarDatosArbol();
        
        root= new Pane();
        ImageView fondo =new ImageView( new Image("/recursos/stage.jpg"));
        Pane contenedorPregunta = new Pane();
        ImageView imvpregunta =new ImageView( new Image("/recursos/preguntaImagen.png"));
        ImageView lampara =new ImageView( new Image("/recursos/lampara.png"));
        imvpregunta.setFitWidth(600);
        imvpregunta.setFitHeight(170); 
        contenedorPregunta.setLayoutX(200);
        contenedorPregunta.setLayoutY(0);
        pregunta= new Label();
        pregunta.setFont(f);       
        pregunta.setLayoutX(50);
        pregunta.setLayoutY(40);
        contenedorPregunta.getChildren().addAll(imvpregunta,pregunta);      
        fondo.setFitWidth(800);
        fondo.setFitHeight(500);    
        ImageView genio =new ImageView( new Image("/recursos/genioPregunta.png"));
        genio.setFitWidth(278);
        genio.setFitHeight(400);    
        genio.setLayoutX(40);
        genio.setLayoutY(60);
        lampara.setLayoutX(180);
        lampara.setLayoutY(420);
        lampara.setFitWidth(137);
        lampara.setFitHeight(77);
        TranslateTransition transition = new TranslateTransition();        
        transition.setDuration(Duration.seconds(1.5));
        transition.setToY(30);
        transition.setAutoReverse(true);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setNode(genio);        
        transition.play();        
        decision = sectorDecision();
        decision.setLayoutX(350);
        decision.setLayoutY(150);
        
        root.getChildren().addAll(fondo,genio,lampara,contenedorPregunta,decision);
        
        Adivinar(arbol.getRoot());
        
        
    }
    
    public Pane sectorDecision(){
        Pane paneprincipal = new Pane();
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
        paneprincipal.getChildren().addAll(pane);
        return paneprincipal;
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
            onrootyes.setOnMouseClicked((evento)->{
                decision.getChildren().clear();                 
                pregunta.setText("Genial! Lo volví a hacer"); 
                Pane jdenuevo= jugarDeNuevo();
                decision.getChildren().addAll(jdenuevo);
                
        });
            onrootno.setOnMouseClicked((e)->{ 
                decision.setLayoutY(0);
                ImageView fondofinal =new ImageView( new Image("/recursos/panefinal.png"));
                fondofinal.setFitWidth(400);
                fondofinal.setFitHeight(300);
                decision.getChildren().clear();
                decision.setStyle("-fx-background-color:aliceblue");
                pregunta.setLayoutY(15);
                pregunta.setText("Boo!\nAyudame a mejorar mi predicción");
                pregunta.setFont(cargarFuente(40));
                VBox continf = new VBox();
                Label linfo= new Label("En que animal estabas pensando ");                
                linfo.setFont(f2);
                TextField tx = new TextField();
                Button b= new Button("Ok");
                VentanaInicio.styleButtonOk(b);
                continf.getChildren().addAll(linfo,tx,b);
                continf.setLayoutY(90);
                continf.setLayoutX(30);
                continf.setSpacing(10);
                decision.getChildren().addAll(fondofinal,continf);
                TranslateTransition transition = new TranslateTransition();        
                transition.setDuration(Duration.seconds(1.5));
                transition.setToY(150);                                
                transition.setNode(decision);        
                transition.play();                  
                b.setOnMouseClicked((e2)->{ 
                    if(!tx.getText().isEmpty()){
                        String  nuevoanimal = tx.getText();                    
                    linfo.setText("Escribe una pregunta para \ndiferenciar entre ambos \nanimales: ");
                    tx.clear();                    
                    b.setOnMouseClicked((e3)->{                        
                        if(!tx.getText().isEmpty()){
                            String  preguntaS = tx.getText();
                            linfo.setText("¿Para este animal la respuesta \nes si o no? "); 
                        linfo.setLayoutY(90);
                        linfo.setLayoutX(20);
                        Button bsi= new Button("Si");
                        Button bno= new Button("No");
                        VentanaInicio.styleButtonSi(bsi);
                        VentanaInicio.styleButtonNo(bno);
                        VBox botones= new VBox();
                        botones.getChildren().addAll(bsi,bno);
                        botones.setLayoutX(100);
                        botones.setLayoutY(140);
                        botones.setSpacing(20);
                        decision.getChildren().clear();
                        decision.getChildren().addAll(fondofinal,linfo,botones);
                        bsi.setOnMouseClicked((e4)->{
                        n.Replace(preguntaS, nuevoanimal, true);
                        System.out.println(n.getData());
                        arbol.GuardarArbol();
                        decision.getChildren().clear();
                        Pane jdenuevo= jugarDeNuevo();
                        decision.getChildren().addAll(fondofinal,jdenuevo);
                        });                        
                        bno.setOnMouseClicked((e5)->{
                        n.Replace(preguntaS, nuevoanimal, false);
                        System.out.println(n.getData());
                        arbol.GuardarArbol();
                        decision.getChildren().clear();
                        Pane jdenuevo= jugarDeNuevo();
                        decision.getChildren().addAll(fondofinal,jdenuevo);
                        });
                        }else{
                            mensajeAlerta("LLENE LOS CAMPOS CORRECTAMENTE");
                        }
                    });
                    }else{
                        mensajeAlerta("LLENE LOS CAMPOS CORRECTAMENTE");
                    }
                });
            });
        }
     }
     
                       
     
                    
     
    public static Font cargarFuente(int num){
         Font f= null;
        try {
             f = Font.loadFont(new FileInputStream(new File("src/recursos/Coder's Crux.ttf")), num);     
        } catch (Exception ex) {
            System.out.println("no se pudo cargar");
        }
        return f;
     }
    
    public Pane jugarDeNuevo(){
        Pane jp= new Pane();
        ImageView replay =new ImageView( new Image("/recursos/replay.png"));
        replay.setFitHeight(142);
        replay.setFitWidth(210);
        replay.setLayoutY(70);  
        replay.setLayoutX(110);
        Button j= new Button("Jugar de nuevo");
        VentanaInicio.styleButtonOk(j); 
        j.setLayoutY(210);
        j.setLayoutX(130);
        jp.getChildren().addAll(replay,j);
        j.setOnMouseClicked((e5)->{
        root.getChildren().clear();
        arbol.GuardarArbol();
        VentanaPensamiento vp= new VentanaPensamiento();
        root.getChildren().add(vp.getRoot());
        });
        return jp;
    }

    public Pane getRoot() {
        return root;
    }
    
    public static void mensajeAlerta(String name){
        Alert alerta= new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Ventana de Alerta");
        alerta.setHeaderText(null);
        alerta.setContentText(name);
        alerta.initStyle(StageStyle.UTILITY);
        alerta.showAndWait();
    }
    
    
}
