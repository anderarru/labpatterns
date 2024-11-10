package observer;

import java.awt.Color;
import java.awt.Frame;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import domain.Covid19Pacient;


public class SemaphorGUI extends JFrame implements java.util.Observer {
	/** stores the associated ConcreteSubject */
	public SemaphorGUI(Covid19Pacient pacient) {
        pacient.addObserver(this);  // Register this GUI as an observer
        setSize(100, 100);
        setLocation(350, 10);
        setVisible(true);
    }
	
	public void update(Observable	o,	Object	arg)	{
		Covid19Pacient	p=(Covid19Pacient)o;
		Color c;
		double current=p.covidImpact();
		if (current<5)	c=Color.green;
		else if (current<10)	c=Color.yellow;
		else if (current =>10) c=Color.red;
		else c = Color.white;
		getContentPane().setBackground(c);
		repaint();
		}
}     

