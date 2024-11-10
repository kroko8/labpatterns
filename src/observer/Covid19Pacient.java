package observer;

import domain.Symptom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Covid19Pacient {
    private String name;
    private int age;
    private Map<Symptom, Integer> symptoms = new HashMap<>();
    private List<Observer> observers = new ArrayList<>();

    public Covid19Pacient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Set<Symptom> getSymptoms() {
        return symptoms.keySet();
    }

    public void addSymptom(Symptom symptom, Integer weight) {
        symptoms.put(symptom, weight);
        notifyObservers();
    }

    public Symptom removeSymptomByName(String symptomName) {
        Symptom symptom = getSymptomByName(symptomName);
        if (symptom != null) {
            symptoms.remove(symptom);
            notifyObservers(); 
        }
        return symptom;
    }


    public Symptom getSymptomByName(String symptomName) {
        for (Symptom symptom : symptoms.keySet()) {
            if (symptom.getName().equals(symptomName)) {
                return symptom;
            }
        }
        return null;
    }

    public double covidImpact() {
        double impact = 0;
        for (Symptom symptom : symptoms.keySet()) {
            impact += symptom.getSeverityIndex() * symptoms.get(symptom);
        }
        return symptoms.isEmpty() ? 0 : impact / symptoms.size();
    }


    // Métodos para agregar y notificar observadores
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
