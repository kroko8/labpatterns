package adapter;

import domain.Covid19Pacient;
import domain.Symptom;
import domain.Covid19Pacient;
import domain.Symptom;

import java.util.ArrayList;
import java.util.List;

public class Covid19PacientInvertedIteratorAdapter implements InvertedIterator {
	private List<Symptom> symptoms;
	private int position;

	public Covid19PacientInvertedIteratorAdapter(Covid19Pacient pacient) {

		this.symptoms = new ArrayList<>(pacient.getSymptoms());
		this.position = symptoms.size() - 1;
	}

	@Override
	public void goLast() {
		position = symptoms.size() - 1;
	}

	@Override
	public boolean hasPrevious() {
		return position >= 0;
	}

	@Override
	public Object previous() {
		Symptom symptom = symptoms.get(position);
		position--;
		return symptom;
	}
}
