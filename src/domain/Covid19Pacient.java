package domain;

import factory.SymptomFactory;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Covid19Pacient {
    private String name;
    private int age;
    private Map<Symptom, Integer> symptoms = new HashMap<>();

    public Covid19Pacient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight(Symptom symptom) {
        return symptoms.get(symptom);
    }

    public Set<Symptom> getSymptoms() {
        return symptoms.keySet();
    }

    public Symptom getSymptomByName(String symptomName) {
        Iterator<Symptom> iterator = getSymptoms().iterator();
        while (iterator.hasNext()) {
            Symptom symptom = iterator.next();
            if (symptom != null && symptom.getName().equals(symptomName)) {
                return symptom;
            }
        }
        return null;
    }

    public void addSymptom(Symptom symptom, Integer weight) {
        symptoms.put(symptom, weight);
    }

    public Symptom addSymptomByName(String symptomName, Integer weight) {
        Symptom symptom = getSymptomByName(symptomName);
        if (symptom == null) {
            symptom = SymptomFactory.createSymptom(symptomName); 
            if (symptom != null) {
                symptoms.put(symptom, weight);
            }
        }
        return symptom;
    }

    public Symptom removeSymptomByName(String symptomName) {
        Symptom symptom = getSymptomByName(symptomName);
        if (symptom != null) {
            symptoms.remove(symptom);
        }
        return symptom;
    }

    public double covidImpact() {
        double affection = 0;
        double increment = 0;
        double impact = 0;

        // Calcular afectación
        for (Symptom symptom : symptoms.keySet()) {
            if (symptom != null) {
                affection += symptom.getSeverityIndex() * symptoms.get(symptom);
            }
        }
        affection /= symptoms.size();

        // Calcular incremento
        if (getAge() > 65) {
            increment = affection * 0.5;
        }

        // Calcular impacto
        impact = affection + increment;
        return impact;
    }

    public Iterator<Symptom> iterator() {
        return symptoms.keySet().iterator();
    }
}
