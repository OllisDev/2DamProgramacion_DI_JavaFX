package com.example.sesion2910;





import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculadora extends Application {

    @Override
    public void start(Stage stage) {

        Label label1 = new Label("Numero 1:");
        Label label2 = new Label("Numero 2:");
        Label label3 = new Label("Numero 3:");
        Label lblResultado = new Label("Resultado: ");
        
        TextField resultado = new TextField();
        Button sumar = new Button("Sumar");
        TextField numero1_text = new TextField();
        TextField numero2_text = new TextField();
        sumar.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(label1, 0, 0);
        grid.add(numero1_text, 1, 0);
        grid.add(label2, 0, 1);
        grid.add(numero2_text, 1, 1);
        grid.add(sumar, 0, 2,2,1);
        grid.add(lblResultado, 0, 3);
        grid.add(resultado, 1,3);

        sumar.setOnAction(e -> {
            try {
                double num1 = Double.parseDouble(numero1_text.getText());
                double num2 = Double.parseDouble(numero2_text.getText());
    
                double suma = num1 + num2;
    
                resultado.setText(String.valueOf(suma));
            } catch (Exception ex) {
                resultado.setText("Entrada no valida");
            }
           

        });
        

        Scene escena = new Scene(grid, 400, 250);
        stage.setTitle("Calculadora");
        stage.setScene(escena);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
