/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geniopolitécnico;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 *
 * @author PC
 */
public class VentanaInicio {
    private Pane root;
    
    public VentanaInicio(){
         crearItems();
    }
    
    public void crearItems(){
        
        root= new Pane();
        
        
        ImageView fondo =new ImageView( new Image("/recursos/fondogenio2.gif"));
        fondo.setFitWidth(800);
        fondo.setFitHeight(500);                               
        Label titulo= new Label("GENIO POLITECNICO");
        titulo.setTextFill(Color.WHITE);
        titulo.setFont(VentanaPensamiento.cargarFuente(45));       
        Button iniciar= new Button("Iniciar Prediccion");
        titulo.setLayoutX(500);
        titulo.setLayoutY(200);
        iniciar.setLayoutX(540);
        iniciar.setLayoutY(250);
        styleButtonOk(iniciar);        
        iniciar.setOnMouseClicked((e)->{
            root.getChildren().clear();
            VentanaPensamiento vp= new VentanaPensamiento();
            root.getChildren().add(vp.getRoot());
            
        });
    
        root.getChildren().addAll(fondo,titulo,iniciar);
    }
      
    public static void styleButton(Button btn){
        btn.setMinHeight(25);
        btn.setMinWidth(85);
        btn.getStyleClass().add("myButton");
    }
    
    public static void styleButtonSi(Button btn){
        btn.setMinHeight(25);
        btn.setMinWidth(85);
        btn.getStyleClass().add("myButtonSi");
    }
    
    public static void styleButtonNo(Button btn){
        btn.setMinHeight(25);
        btn.setMinWidth(85);
        btn.getStyleClass().add("myButtonNo");
    }
    
    public static void styleButtonOk(Button btn){
        btn.setMinHeight(25);
        btn.setMinWidth(85);
        btn.getStyleClass().add("myButtonOk");
    }

    public Pane getRoot() {
        return root;
    }
    
}
