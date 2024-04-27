package fedotova_picca;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JSlider;

public class metodes {
	
	static int i = 1, d = 30;
	
	public static Queue<Object> jaunsPasutijums(Queue<Object> picas1) {
		String[] picas = {"pica1", "pica2", "pica3", "pica4", "pica5", "pica6"};
		String[] dzerieni = {"CocaCola", "Fanta", "Pepsi"};
		String pic, dzer;
		boolean siers, pipari;
		double cena = 0;
		String diam;
		int izvel;
		
		pic = (String)JOptionPane.showInputDialog(null, "Kadu picu tu gribi?", "Pica", JOptionPane.QUESTION_MESSAGE, null, picas, picas[0]);
			switch(pic) {
			case "pica1":
				cena = 3.50;
				break;

			case "pica2":
			case "pica3":
				cena = 4.99;
				break;

			case "pica4":
				cena = 5.20;
				break;

			case "pica5":
				cena = 5.50;
				break;

			case "pica6":
				cena = 4.75;
				break;
			}

	    JSlider slider = slider();
	    slider.setValue(d);
	        
	        
	    int option = JOptionPane.showConfirmDialog(null, new Object[]{"Izvelies picas diametru: ", slider}, "Diametrs", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	    if (option == JOptionPane.OK_OPTION)
	        d = slider.getValue(); 
	    diam = String.valueOf(d); 
	    if(diam.equals("40")) 
	    	cena += 0.50;
		else if(diam.equals("50")) 
			cena ++;

		dzer = (String)JOptionPane.showInputDialog(null, "Kadu dzerienu tu gribi?", "Dzeriens", JOptionPane.QUESTION_MESSAGE, null, dzerieni, dzerieni[0]);
			cena += 1.50;

		izvel = JOptionPane.showOptionDialog( null, "Vai tu gribi papildu sieru?", "Siers", JOptionPane.YES_NO_OPTION,
	        		 JOptionPane.QUESTION_MESSAGE, null, new String[]{"Jā", "Nē"}, "Nē");
			if(izvel == JOptionPane.YES_OPTION){
				siers = true;
				cena += 0.50;
			}else siers = false;

		izvel = JOptionPane.showOptionDialog( null, "Vai tu gribi papildus piparus?", "Pipari", JOptionPane.YES_NO_OPTION,
	        	 JOptionPane.QUESTION_MESSAGE, null, new String[]{"Jā", "Nē"}, "Nē");
			if(izvel == JOptionPane.YES_OPTION) {
				pipari = true;
				cena += 0.10;
			}else pipari = false;
		
		izvel = JOptionPane.showOptionDialog( null, "Nogādāt pasūtījumu mājās?", "Piegade", JOptionPane.YES_NO_OPTION,
	        	 JOptionPane.QUESTION_MESSAGE, null, new String[]{"Jā", "Nē"}, "Nē");
		if(izvel == JOptionPane.YES_OPTION) {
			picas1.add(piegade(pic, dzer, siers, pipari, cena, diam));
		}else if(izvel == JOptionPane.NO_OPTION){
			pasutijums jaunsPas = new pasutijums(pic, dzer, siers, pipari, cena, diam, i, false);
			i++;
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
	
	static Object piegade(String pic, String dzer, boolean siers, boolean pipari, double cena, String diam) {
		Pattern vardsPat = Pattern.compile("^[a-zA-Z]+_[a-zA-Z]+$");
		Pattern adresePat = Pattern.compile("^[\\p{L}\\d\\s.-]+$");
		Matcher adreseMatc, vardsMatc;
		String adrese, vards, telNr;
		
		do {
			vards = (String)JOptionPane.showInputDialog(null, "Ievadi vārdu un uzvārdu", "Piegade", JOptionPane.QUESTION_MESSAGE);
			vardsMatc = vardsPat.matcher(vards);
		}while(!vardsMatc.matches());
		do {
			adrese = (String)JOptionPane.showInputDialog(null, "Ievadi adrese", "Piegade", JOptionPane.QUESTION_MESSAGE);
			adreseMatc = adresePat.matcher(adrese);
		}while(!adreseMatc.matches());
		do {
			telNr = (String)JOptionPane.showInputDialog(null, "Ievadi tel. numuru", "Piegade", JOptionPane.QUESTION_MESSAGE);
		}while(telNr.length()!=8);
		
		cena += 2.40;
		
		piegadeP jaunaPiegade = new piegadeP(pic, dzer, siers, pipari, cena, diam, i, true, vards, adrese, telNr);
		failiem.rakstitFaila(jaunaPiegade, "piegade.txt");
		i++;
		return jaunaPiegade;
	}
	
    private static JSlider slider() {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 30, 50, 30);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        return slider;
    }
    
	}

