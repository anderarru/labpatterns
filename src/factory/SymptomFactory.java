package factory;

import domain.DigestiveSymptom;
import domain.NeuroMuscularSymptom;
import domain.RespiratorySymptom;
import domain.Symptom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymptomFactory {

	private static SymptomFactory instance;
    private static Map<String, Symptom> symptomRegistry;

    private SymptomFactory() {
        symptomRegistry = new HashMap<>();
    }

    public static SymptomFactory getInstance() {
        if (instance == null) {
            instance = new SymptomFactory();
        }
        return instance;
    }
   
        
    public static Symptom createSymptom(String symptomName) {
    	
    	
    	
    	if (symptomRegistry.containsKey(symptomName)) {
            return symptomRegistry.get(symptomName);
        }
    	
    	 List<String> impact5 = Arrays.asList("fiebre", "tos seca", "astenia", "expectoracion");
    	 List<Double> index5 = Arrays.asList(87.9, 67.7, 38.1, 33.4);
    	 List<String> impact3 = Arrays.asList("disnea", "dolor de garganta", "cefalea", "mialgia", "escalofrios");
    	 List<Double> index3 = Arrays.asList(18.6, 13.9, 13.6, 14.8, 11.4);
    	 List<String> impact1 = Arrays.asList("nauseas", "vómitos", "congestión nasal", "diarrea", "hemoptisis", "congestion conjuntival");
    	 List<Double> index1 = Arrays.asList(5.0, 4.8, 3.7, 0.9, 0.8);


    	 List<String> digestiveSymptom = Arrays.asList("nauseas", "vómitos", "diarrea");
    	 List<String> neuroMuscularSymptom = Arrays.asList("fiebre", "astenia", "cefalea", "mialgia", "escalofrios");
    	 List<String> respiratorySymptom = Arrays.asList("tos seca", "expectoracion", "disnea", "dolor de garganta", "congestión nasal", "hemoptisis", "congestion conjuntival");

    	
    	int impact = 0;
        double index = 0;

   
        if (impact5.contains(symptomName)) {
            impact = 5;
            index = index5.get(impact5.indexOf(symptomName));
        } else if (impact3.contains(symptomName)) {
            impact = 3;
            index = index3.get(impact3.indexOf(symptomName));
        } else if (impact1.contains(symptomName)) {
            impact = 1;
            index = index1.get(impact1.indexOf(symptomName));
        }

        Symptom s = null;
        if (impact != 0) {
            if (digestiveSymptom.contains(symptomName)) {
                s = new DigestiveSymptom(symptomName, (int) index, impact);
            }
            if (neuroMuscularSymptom.contains(symptomName)) {
                s = new NeuroMuscularSymptom(symptomName, (int) index, impact);
            }
            if (respiratorySymptom.contains(symptomName)) {
                s = new RespiratorySymptom(symptomName, (int) index, impact);
            }
        }

        if (s != null) {
            symptomRegistry.put(symptomName, s);
        }
        
        return s;
    }
    
}
