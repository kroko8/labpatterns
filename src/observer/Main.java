package observer;

import observer.Covid19Pacient;


public class Main {
    public static void main(String[] args) {
    	
        observer.Covid19Pacient pacient = new observer.Covid19Pacient("Aitor", 35);

        new PacientObserverGUI(pacient);

        new PacientSymptomGUI(pacient);
        
        new SemaphorGUI(pacient);

    }
}


