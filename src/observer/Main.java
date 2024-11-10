package observer;

import domain.Covid19Pacient;

/*
 //Lehenengo prototipoa
public class Main {
    public static void main(String args[]) {
 
        Covid19Pacient pacient1 = new Covid19Pacient("Aitor", 35);
        new PacientObserverGUI(pacient1);
        new PacientSymptomGUI(pacient1);

        
        Covid19Pacient pacient2 = new Covid19Pacient("Miren", 40);
        new PacientObserverGUI(pacient2);
        new PacientSymptomGUI(pacient2);
    }
}
*/

public class Main {
    public static void main(String args[]) {
        // Lehenengo pazientea eta bere interfazeak
        Covid19Pacient pacient1 = new Covid19Pacient("Aitor", 35);
        new PacientObserverGUI(pacient1);
        new PacientSymptomGUI(pacient1);
        new PacientThermometerGUI(pacient1);
        new SemaphorGUI(pacient1);

        // Bigarren pazientea eta bere interfazeak
        Covid19Pacient pacient2 = new Covid19Pacient("Miren", 40);
        new PacientObserverGUI(pacient2);
        new PacientSymptomGUI(pacient2);
        new PacientThermometerGUI(pacient2);
        new SemaphorGUI(pacient2);
        
     // Bigarren pazientea eta bere interfazeak
        Covid19Pacient pacient3 = new Covid19Pacient("Jon", 30);
        new PacientObserverGUI(pacient3);
        new PacientSymptomGUI(pacient3);
        new PacientThermometerGUI(pacient3);
        new SemaphorGUI(pacient3);
    }
}

