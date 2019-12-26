/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geniopolitécnico;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class TestJuego  extends Application{
@Override
    public void start(Stage primaryStage) {
       VentanaInicio vi= new VentanaInicio();          
      
       
        Scene scene = new Scene(vi.getRoot(), 800, 500);
        scene.getStylesheets().add("recursos/Estilos.css");                
        primaryStage.setTitle("Genio Politecnico");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static void styleButton(Button btn){
        btn.setMinHeight(25);
        btn.setMinWidth(85);
        btn.getStyleClass().add("myButton");
    }
    
}
