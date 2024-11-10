package adapterIterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adapter.InvertedIterator;
import domain.Covid19Pacient;
import domain.Symptom;

public class Covid19PacientAdapter implements InvertedIterator {
	private List<Symptom> symptoms;
    private int currentIndex;

    public Covid19PacientAdapter(Covid19Pacient pacient) {
    	this.symptoms = new ArrayList<>(pacient.getSymptoms());
        this.currentIndex = symptoms.size() - 1;
    }

    @Override
    public Object previous() {
        if (hasPrevious()) {
            return symptoms.get(currentIndex--);
        }
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return currentIndex >= 0;
    }

    @Override
    public void goLast() {
        currentIndex = symptoms.size() - 1;
    }
}

