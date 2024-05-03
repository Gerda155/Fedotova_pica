package Fedotova_pica;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

public class metodes {
	
	static int i = 1, d = 30;
	static String merce = null, pica = null, izv = null;
	
	public static Queue<Object> jaunsPasutijums(Queue<Object> picas1) {
		String[] dzerieni = {"CocaCola", "Fanta", "Pepsi"};
		String dzer;
		boolean siers, kFri;
		double cena = 0;
		String diam;
		int izvel;
		
		do {
			pica = picaNos();
		}while(pica==null);
		if(pica.equals("Diavola"))
			cena += 4.50;
		else if(pica.equals("Peperoni"))
			cena += 3.00;
		else if(pica.equals("Hawaii"))
			cena += 4.00;

	    JSlider slider = slider();
	    slider.setValue(d);
	        
	        
	    int option = JOptionPane.showConfirmDialog(null, new Object[]{"Picas diametrs: "+"\n40cm - cena + 0.50\n50cm - cena + 1.00", slider}, "Diametrs", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	    if (option == JOptionPane.OK_OPTION)
	        d = slider.getValue(); 
	    diam = String.valueOf(d); 
	    if(diam.equals("40")) 
	    	cena += 0.50;
		else if(diam.equals("50")) 
			cena ++;

		dzer = (String)JOptionPane.showInputDialog(null, "Dzēriena izvēle", "Dzēriens, cena + 1.50", JOptionPane.QUESTION_MESSAGE, null, dzerieni, dzerieni[0]);
			cena += 1.50;

		izvel = JOptionPane.showOptionDialog( null, "Vai pievienot papildu sieru?", "Siers, cena + 0.50", JOptionPane.YES_NO_OPTION,
	        		 JOptionPane.QUESTION_MESSAGE, null, new String[]{"Jā", "Nē"}, "Nē");
			if(izvel == JOptionPane.YES_OPTION){
				siers = true;
				cena += 0.50;
			}else siers = false;
			
		izvel = JOptionPane.showOptionDialog( null, "Vai pievienot fr kartupeļus?", "Frī, cena + 1.00", JOptionPane.YES_NO_OPTION,
	        	JOptionPane.QUESTION_MESSAGE, null, new String[]{"Jā", "Nē"}, "Nē");
		if(izvel == JOptionPane.YES_OPTION){
			kFri = true;
			cena ++;
		}else kFri = false;
		
		merce = merces();
		cena+=0.25;
		
		izvel = JOptionPane.showOptionDialog( null, "Nogādāt pasūtījumu mājās?", "Piegāde, cena + 2.40", JOptionPane.YES_NO_OPTION,
	        	 JOptionPane.QUESTION_MESSAGE, null, new String[]{"Jā", "Nē"}, "Nē");
		if(izvel == JOptionPane.YES_OPTION) {
			picas1.add(piegade(pica, dzer, siers, merce, cena, diam, kFri));
			pica = null;
		}else if(izvel == JOptionPane.NO_OPTION){
			pasutijums jaunsPas = new pasutijums(pica, dzer, siers, merce, cena, diam, i, false, kFri);
			i++;
			pica = null;
			failiem.rakstitFaila(jaunsPas, "pasutijumi.txt");
			picas1.add(jaunsPas);
		}
		return picas1;
	}
	
	static String Laiks() {
        Date time = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH : mm");
        String laiks = format.format(time);
        return laiks;
	}
	
	static Object piegade(String pic, String dzer, boolean siers, String merce, double cena, String diam, boolean kFri) {
		Pattern vardsPat = Pattern.compile("^[a-zA-Z]+$");
		Pattern adresePat = Pattern.compile("^[\\p{L}\\d\\s.-]+$");
		Matcher adreseMatc, vardsMatc;
		String adrese, vards, telNr;
		
		do {
			vards = (String)JOptionPane.showInputDialog(null, "Ievadi vārdu", "Piegāde, cena + 2.40", JOptionPane.QUESTION_MESSAGE);
			vardsMatc = vardsPat.matcher(vards);
		}while(!vardsMatc.matches());
		do {
			adrese = (String)JOptionPane.showInputDialog(null, "Ievadi adrese \"ielas nos. māja-dzīvoklis", "Piegāde", JOptionPane.QUESTION_MESSAGE);
			adreseMatc = adresePat.matcher(adrese);
		}while(!adreseMatc.matches());
		do {
			telNr = (String)JOptionPane.showInputDialog(null, "Ievadi tel. numuru +371", "Piegāde, cena + 2.40", JOptionPane.QUESTION_MESSAGE);
		}while(telNr.length()!=8);
		
		cena += 2.40;
		
		piegadeP jaunaPiegade = new piegadeP(pic, dzer, siers, merce, cena, diam, i, true, kFri, vards, adrese, telNr);
		failiem.rakstitFaila(jaunaPiegade, "piegade.txt");
		i++;
		return jaunaPiegade;
	}
	
    static JSlider slider() {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 30, 50, 30);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        return slider;
    }
    
    static String merces() {
        ImageIcon merce1 = new ImageIcon(".//atteli//merceC.jpg");
        ImageIcon merce2 = new ImageIcon(".//atteli//merceB.jpg");
        ImageIcon merce3 = new ImageIcon(".//atteli//merceK.jpg");
        JPanel panel2 = new JPanel(new GridLayout(3, 2));
        
        AtteliPogas2(panel2, merce1, "Ķiploku majonēze");
        AtteliPogas2(panel2, merce2, "Barbekju mērce");
        AtteliPogas2(panel2, merce3, "Ķiploku majonēze");
        
        do {
        	JOptionPane.showConfirmDialog(null, panel2, "Merces izvēle", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        }while(merce == null);
        return merce;
    }
    
    static void AtteliPogas2(JPanel panel, ImageIcon icon, String option) {
        JRadioButton radioPogas2 = new JRadioButton(option);
        radioPogas2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                merce = option;
            }
        });
        panel.add(new JLabel(icon));
        panel.add(radioPogas2);
        
    }
    
    
    static void skana(String nosaukums) throws MalformedURLException,
	UnsupportedAudioFileException, IOException, LineUnavailableException{
		File f = new File(".//skana//"+nosaukums);
		AudioInputStream ais = AudioSystem.getAudioInputStream(f.toURI().toURL());
		Clip c = AudioSystem.getClip();
		c.open(ais);
		c.start();
	}
    
    static String picaNos() {
        ImageIcon pica1 = new ImageIcon(".//atteli//pica_diavola.jpg");
        ImageIcon pica2 = new ImageIcon(".//atteli//pica_hawai.jpg");
        ImageIcon pica3 = new ImageIcon(".//atteli//pica_peperoni.jpg");
        JPanel panel = new JPanel(new GridLayout(3, 2));
        
        AtteliPogas(panel, pica1, "Diavola, cena: 4.50");
        AtteliPogas(panel, pica2, "Hawaii, cena: 4.00");
        AtteliPogas(panel, pica3, "Peperoni, cena: 3.00");
        
        do {
        	JOptionPane.showConfirmDialog(null, panel, "Picas izvēle", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        }while(pica == null);
        return pica;
    }
    
    static void AtteliPogas(JPanel panel, ImageIcon icon, String option) {
        JRadioButton radioPogas = new JRadioButton(option);
        radioPogas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pica = option;
            }
        });
        panel.add(new JLabel(icon));
        panel.add(radioPogas);
        
    }
    
	}


