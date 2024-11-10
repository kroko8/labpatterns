package adapter2;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import domain.Covid19Pacient;
import domain.Symptom;

public class Covid19PacientTableModelAdapter extends AbstractTableModel {

	protected Covid19Pacient pacient;
	protected String[] columnNames = new String[] { "Symptom", "Weight" };
	protected List<Symptom> symptoms;

	public Covid19PacientTableModelAdapter(Covid19Pacient p) {
		this.pacient = p;
		this.symptoms = new ArrayList<>(p.getSymptoms());
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public int getRowCount() {
		return symptoms.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Symptom symptom = symptoms.get(row);
		switch (col) {
		case 0:
			return symptom.getName();
		case 1:
			return pacient.getWeight(symptom);
		default:
			return null;
		}
	}
}
