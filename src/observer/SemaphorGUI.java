package observer;

import java.awt.Color;
import java.awt.Frame;
import observer.Covid19Pacient;
import javax.swing.JFrame;

public class SemaphorGUI extends JFrame implements Observer {
	/** stores the associated ConcreteSubject */

	private Covid19Pacient pacient;

	public SemaphorGUI(Covid19Pacient pacient) {
		this.pacient = pacient;
		pacient.addObserver(this);
		
		setSize(100, 100);
		setLocation(350, 10);
		Color c = Color.green;
		getContentPane().setBackground(c);
		repaint();
		
		setVisible(true);
	}

	@Override
	public void update() {
		actualizarColor();
	}

	private void actualizarColor() {
	    double impact = pacient.covidImpact();
	    System.out.println("Impacto actual: " + impact); // Depurar

	    Color color;
	    if (impact < 5) {
	        color = Color.green;
	    } else if (impact < 10) {
	        color = Color.yellow;
	    } else {
	        color = Color.red;
	    }

	    getContentPane().setBackground(color);
	    repaint();
	}



}
