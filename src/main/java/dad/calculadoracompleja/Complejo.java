package dad.calculadoracompleja;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

// Se deberá rear un bean JavaFX de nombre "Complejo" con las propiedades "real" e "imaginario" de tipo "Double":"DoubleProperty".

public class Complejo {
	
	private DoubleProperty real = new SimpleDoubleProperty();
	private DoubleProperty imaginario = new SimpleDoubleProperty();
	
	
	// valor
	public void setReal (double real) {
		this.real.set(real);
	}
	
	public double getReal() {
		return real.get();
	}
	
	//propiedad
	public DoubleProperty realProperty() {
		return real;
	}
	
	public void setImaginario (double imaginario) {
		this.imaginario.set(imaginario);
	}
	
	public double getImaginario() {
		return imaginario.get();
	}
	
	public DoubleProperty imaginarioProperty() {
		return imaginario;
	}
	
	public void sumar(Complejo x, Complejo y) {
		real.bind(x.realProperty().add(y.realProperty()));
		imaginario.bind(x.imaginarioProperty().add(y.imaginarioProperty()));
	}

	public void restar(Complejo x, Complejo y) {
		real.bind(x.realProperty().subtract(y.realProperty()));
		imaginario.bind(x.imaginarioProperty().subtract(y.imaginarioProperty()));
	}
	
	public void multiplicar(Complejo x, Complejo y) {
		real.bind(x.realProperty().multiply(y.realProperty()).subtract(x.imaginarioProperty().multiply(y.imaginarioProperty())));
		imaginario.bind(x.realProperty().multiply(y.imaginarioProperty()).add(x.imaginarioProperty().multiply(y.realProperty())));
	}
	
	public void dividir(Complejo x, Complejo y) {
		real.bind(x.realProperty().multiply(y.realProperty()).add(x.imaginarioProperty().multiply(y.imaginarioProperty()))
				.divide(y.realProperty().multiply(y.realProperty()).add(y.imaginarioProperty().multiply(y.imaginarioProperty()))));
		imaginario.bind(x.imaginarioProperty().multiply(y.realProperty()).subtract(x.realProperty().multiply(y.imaginarioProperty()))
				.divide(y.realProperty().multiply(y.realProperty()).add(y.imaginarioProperty().multiply(y.imaginarioProperty()))));
	}
}
