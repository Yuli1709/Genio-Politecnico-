/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geniopolitécnico;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author PC
 */
public class VentanaPensamiento {
    private Pane root;
    
    public VentanaPensamiento(){
        root= new Pane();
         ImageView fondo =new ImageView( new Image("/recursos/stage.jpg"));
        fondo.setFitWidth(800);
        fondo.setFitHeight(500);    
        ImageView genio =new ImageView( new Image("/recursos/genioPregunta.png"));
        genio.setFitWidth(278);
        genio.setFitHeight(438);    
        genio.setLayoutX(40);
        genio.setLayoutY(30);
        root.getChildren().addAll(fondo,genio);
        
    }

    public Pane getRoot() {
        return root;
    }
    
    
}
