package dad.calculadoracompleja;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class Calculadora extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// ui
		
		ComboBox<String> operadorCombo = new ComboBox<>();
		operadorCombo.getItems().addAll("+","-","*","/");
		VBox cajaComboBox = new VBox(10, operadorCombo);
		cajaComboBox.setAlignment(Pos.CENTER);
		
		

		TextField num1Real = new TextField();
		num1Real.setPrefColumnCount(4);
		TextField num1Imaginario = new TextField();
		num1Imaginario.setPrefColumnCount(4);
		HBox operando1 = new HBox(5, num1Real, new Label("+"), num1Imaginario, new Label("i"));
		
		
		
		TextField num2Real = new TextField();
		num2Real.setPrefColumnCount(4);
		TextField num2Imaginario = new TextField();
		num2Imaginario.setPrefColumnCount(4);
		HBox operando2 = new HBox(5, num2Real, new Label("+"), num2Imaginario, new Label("i"));
	
		
		TextField resultadoReal = new TextField();
		resultadoReal.setPrefColumnCount(4);
		TextField resultadoImaginario = new TextField();
		resultadoImaginario.setPrefColumnCount(4);
		HBox resultadoOperandos = new HBox(5, resultadoReal, new Label("+"), resultadoImaginario, new Label("i"));
		
		
		VBox cajaOperaciones = new VBox(5, operando1, operando2, new Separator(), resultadoOperandos);
		cajaOperaciones.setAlignment(Pos.CENTER);
		
		
		
		HBox root = new HBox(5, cajaComboBox, cajaOperaciones);
		root.setAlignment(Pos.CENTER);
		
		
		Scene scene = new Scene(root, 320, 200);
		
		primaryStage.setTitle("Calculadora de números complejos");
		primaryStage.setScene(scene);
		primaryStage.show();
		
			
			
		// bindings
		
		DoubleProperty a = new SimpleDoubleProperty();	
		DoubleProperty b = new SimpleDoubleProperty();
		DoubleProperty c = new SimpleDoubleProperty();	
		DoubleProperty d = new SimpleDoubleProperty();
		DoubleProperty resultReal = new SimpleDoubleProperty();	
		DoubleProperty resultImaginario = new SimpleDoubleProperty();
		
		num1Real.textProperty().bindBidirectional(a, new NumberStringConverter());
		num1Imaginario.textProperty().bindBidirectional(b, new NumberStringConverter());
		num2Real.textProperty().bindBidirectional(c, new NumberStringConverter());
		num2Imaginario.textProperty().bindBidirectional(d, new NumberStringConverter());
		resultadoReal.textProperty().bind(resultReal.asString());
		resultadoImaginario.textProperty().bind(resultImaginario.asString());
		
		
		// listener
		
		operadorCombo.getSelectionModel().selectedItemProperty().addListener((o, ov, nv) -> {
			
			switch(nv) {
			case "+":
				resultReal.bind(a.add(c));
				resultImaginario.bind(b.add(d));
				break;
			case "-":
				resultReal.bind(a.subtract(c));
				resultImaginario.bind(b.subtract(d));
				break;
			case "*":
				resultReal.bind(a.multiply(c).subtract(b.multiply(d)));
				resultImaginario.bind(a.multiply(d).add(b.multiply(c)));
				break;
			case "/":
				resultReal.bind(a.multiply(c).add(b.multiply(d))
						.divide(c.multiply(c).add(d.multiply(d))));
				resultImaginario.bind(b.multiply(c).subtract(a.multiply(d))
						.divide(c.multiply(c).add(d.multiply(d))));
			}
		});
		
		operadorCombo.getSelectionModel().selectFirst();
		
	}

}
