package factory;

import domain.Covid19Pacient;
import domain.Medicament;
import domain.Symptom;

public class Main {
    public static void main(String[] args) {
        Covid19Pacient p1 = new Covid19Pacient("aitor", 35);
        new PacientSymptomGUI(p1);

        Medicament m = new Medicament("Ibuprofeno");
        new MedicalGUI(m);

        Symptom symptom1 = SymptomFactory.createSymptom("mareos");
        System.out.println("Síntoma creado: " + (symptom1 != null ? symptom1.getName() : "no existe"));

        Symptom symptom2 = SymptomFactory.createSymptom("mareos");
        System.out.println("Síntomas idénticos: " + (symptom1 == symptom2));
    }
}


