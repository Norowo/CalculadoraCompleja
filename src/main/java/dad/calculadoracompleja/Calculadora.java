package dad.calculadoracompleja;

import javafx.application.Application;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculadora extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// ui
			HBox root;
			
			
			HBox operando1HBox;
			HBox operando2HBox;
			HBox resultadoHBox;
			
			ComboBox<String> operadorCombo = new ComboBox<>();
			operadorCombo.getItems().addAll("+","-","*","/");
			
			VBox seleccionOperacionVBox = new VBox(operadorCombo);
			
			TextField num1Real = new TextField();
			TextField num1Imaginario = new TextField();
			TextField num2Real = new TextField();
			TextField num2Imaginario = new TextField();
			TextField resultadoReal = new TextField();
			TextField resultadoImaginario = new TextField();
			
			VBox operacionesVBox = new VBox();
			
			root = new HBox(5, seleccionOperacionVBox, operacionesVBox);
			operacionesVBox.getC
			
			
		// bindings
		
		// listener
		
	}

}
