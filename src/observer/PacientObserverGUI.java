package observer;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import domain.Symptom;
import domain.Covid19Pacient;

public class PacientObserverGUI extends JFrame implements Observer {

    private JPanel contentPane;
    private final JLabel symptomLabel = new JLabel("");

    /**
     * Create the frame.
     * @param obs Subskripzioa egingo dugun Observable objektua.
     */
    public PacientObserverGUI(Observable obs) {
        setTitle("Pacient symptoms");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(650, 100, 200, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        symptomLabel.setBounds(19, 38, 389, 199);
        contentPane.add(symptomLabel);
        symptomLabel.setText("Still no symptoms");
        this.setVisible(true);
        
        // Subskripzioa egiten dugu Observable objektuan
        obs.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Covid19Pacient) {
            Covid19Pacient pacient = (Covid19Pacient) o;
            StringBuilder s = new StringBuilder("<html> Pacient: <b>");
            s.append(pacient.getName()).append("</b><br>");
            s.append("Covid impact: <b>").append(pacient.covidImpact()).append("</b><br><br>");
            s.append("_____________________<br>Symptoms:<br>");
            
            // Sintomak iteratu
            Iterator<Symptom> symptomIterator = pacient.getSymptoms().iterator();
            while (symptomIterator.hasNext()) {
                Symptom symptom = symptomIterator.next();
                s.append(" - ").append(symptom.toString()).append(", ")
                 .append(pacient.getWeight(symptom)).append("<br>");
            }
            s.append("</html>");
            
            // HTML testua etiketara gehitu
            symptomLabel.setText(s.toString());
        }
    }
}
