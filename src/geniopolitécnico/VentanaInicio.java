/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geniopolitécnico;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
        ImageView pensamiento =new ImageView( new Image("/recursos/pensamiento2.png"));
        pensamiento.setFitWidth(400);
        pensamiento.setFitHeight(100);  
        pensamiento.setLayoutX(410);
        pensamiento.setLayoutY(110);
        Button iniciar= new Button("Iniciar Prediccion");
        iniciar.setLayoutX(540);
        iniciar.setLayoutY(240);
        styleButton(iniciar);
        TranslateTransition transition = new TranslateTransition();        
        transition.setDuration(Duration.seconds(1.5));
        transition.setToY(50);
        transition.setAutoReverse(true);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setNode(iniciar);
        transition.play();
        iniciar.setOnMouseClicked((e)->{
            root.getChildren().clear();
            VentanaPensamiento vp= new VentanaPensamiento();
            root.getChildren().add(vp.getRoot());
            
        });
    
        root.getChildren().addAll(fondo,pensamiento,iniciar);
    }
      
    public static void styleButton(Button btn){
        btn.setMinHeight(25);
        btn.setMinWidth(85);
        btn.getStyleClass().add("myButton");
    }

    public Pane getRoot() {
        return root;
    }
    
}
