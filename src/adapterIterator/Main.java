package adapterIterator;

import java.util.Comparator;
import java.util.Iterator;

import domain.Covid19Pacient;
import domain.Symptom;
import adapter.Sorting;
public class Main {
    public static void main(String[] args) {

    	
        Covid19Pacient patient = new Covid19Pacient("Javi", 35);
        patient.addSymptom(new Symptom("Sukarra", 3, 5), 2);
        patient.addSymptom(new Symptom("Eztula", 2, 4), 3);
        patient.addSymptom(new Symptom("Buruko mina", 1, 3), 1);
        patient.addSymptom(new Symptom("Fatiga", 2, 2), 2);
        patient.addSymptom(new Symptom("Diarrea", 1, 1), 1);

        Covid19PacientAdapter adapter = new Covid19PacientAdapter(patient);

        Comparator<Object> byName = new ComSymptomName();
        Comparator<Object> bySeverity = new ComSeverity();


        System.out.println("Sintomak izenarekiko ordenatuta:");
        Iterator<Object> nameSorted = Sorting.sortedIterator(adapter, byName);
        while (nameSorted.hasNext()) {
            System.out.println(nameSorted.next());
        }

        System.out.println("\nSintomak serverity index-arekiko ordenatuta:");
        Iterator<Object> severitySorted = Sorting.sortedIterator(adapter, bySeverity);
        while (severitySorted.hasNext()) {
            System.out.println(severitySorted.next());
        }
    }
}
