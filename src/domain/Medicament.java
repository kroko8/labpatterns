package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import factory.SymptomFactory;


public class Medicament {
    private String name;
    private List<Symptom> symptoms = new ArrayList<>();

    public Medicament(String name) {
        this.name = name;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Symptom addSymptomByName(String symptomName) {
        Symptom symptom = getSymptomByName(symptomName);
        if (symptom == null) {
            symptom = SymptomFactory.createSymptom(symptomName); 
            if (symptom != null) {
                symptoms.add(symptom);
            }
        }
        return symptom;
    }
	public void removeSymptom(Symptom s){
		symptoms.remove(s);

	}
	public Iterator<Symptom> getSymptoms() {
		return symptoms.iterator();
	}
	public Symptom getSymptomByName(String symptomName) {
		Iterator<Symptom> i= symptoms.iterator();
		Symptom s=null;
		while (i.hasNext()) {
			s=i.next();
			if (s!=null && s.getName().compareTo(symptomName)==0) return s;
		}
		return null;	
	}
	public Symptom removeSymptomByName(String symptomName) {
		Symptom s=getSymptomByName(symptomName);
		if (s!=null)removeSymptom(s);
		return s;
	}
	}
