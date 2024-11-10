package adapterIterator;

import java.util.Comparator;
import domain.Symptom;

public class ComSeverity implements Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {
    	return Integer.compare(((Symptom) o1).getSeverityIndex(),((Symptom) o2).getSeverityIndex());
    }
}
