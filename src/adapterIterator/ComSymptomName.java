package adapterIterator;

import java.util.Comparator;
import domain.Symptom;

public class ComSymptomName implements Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {
        return ((Symptom) o1).getName().compareTo(((Symptom) o2).getName());
    }
}
