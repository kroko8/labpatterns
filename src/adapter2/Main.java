package adapter2;

import domain.Covid19Pacient;

public class Main {

	public static void main(String[] args) {
		
		//Paciente 1
		
		Covid19Pacient pacient=new Covid19Pacient("aitor", 35);
		
		pacient.addSymptomByName("disnea", 2);
		pacient.addSymptomByName("cefalea", 1);
		pacient.addSymptomByName("astenia", 3);
		
		ShowPacientTableGUI gui=new ShowPacientTableGUI(pacient);
		gui.setPreferredSize(
			      new java.awt.Dimension(300, 200));
		gui.setVisible(true);
		
		//Paciente 2
		
		Covid19Pacient pacient2 = new Covid19Pacient("Maria", 42);
        pacient2.addSymptomByName("fiebre", 3);
        pacient2.addSymptomByName("tos seca", 2);
		
        ShowPacientTableGUI gui2 = new ShowPacientTableGUI(pacient2);
        gui2.setPreferredSize(new java.awt.Dimension(300, 200));
        gui2.setVisible(true);


	}

}
