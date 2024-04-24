package fedotova_pica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class metodes {
	static String file = "aktiviePas.txt";
	public static Object jaunsPasutijums(ArrayList<Object> picas1) {
		String[] picas = {"pica1", "pica2", "pica3", "pica4", "pica5", "pica6"};
		String[] dzerieni = {"CocaCola", "Fanta", "Pepsi"};
		String[] jane = {"Jā", "Nē"};
		String[] diam = {"30", "40", "50"};
		String izvele, pic, dzer;
		boolean siers, pipari;
		double cena = 0;
		int d;
		
		pic = (String)JOptionPane.showInputDialog(null, "Kadu picu tu gribi?", "Pica", JOptionPane.QUESTION_MESSAGE, null, picas, picas[0]);
			switch(pic) {
			case "pica1":
				cena = 5.50;
				break;
			
			case "pica2":
			case "pica3":
				cena = 6.99;
				break;
			
			case "pica4":
				cena = 7.20;
				break;
			
			case "pica5":
				cena = 7.50;
				break;
			
			case "pica6":
				cena = 4.75;
				break;
			}
		d  = (int)JOptionPane.showInputDialog(null, "Izvelies picas diametru", "Pica", JOptionPane.QUESTION_MESSAGE, null, diam, diam[0]);
			if(d == 40) cena += 0.50;
			else if(d == 50) cena ++;
			
		dzer = (String)JOptionPane.showInputDialog(null, "Kadu dzerienu tu gribi?", "Dzeriens", JOptionPane.QUESTION_MESSAGE, null, dzerieni, dzerieni[0]);
			cena += 1.50;
			
		izvele = (String)JOptionPane.showInputDialog(null, "Vai tu gribi papildu sieru?", "Siers", JOptionPane.QUESTION_MESSAGE, null, jane, jane[0]);
			if(izvele.equals("Jā")){
				siers = true;
				cena += 0.50;
			}else siers = false;
			
		izvele = (String)JOptionPane.showInputDialog(null, "Vai tu gribi papildus piparus?", "Siers", JOptionPane.QUESTION_MESSAGE, null, jane, jane[0]);
			if(izvele.equals("Jā")) {
				pipari = true;
				cena += 0.10;
			}else pipari = false;
			
		pasutijums jaunsPas = new pasutijums(pic, dzer, siers, pipari, cena, d, true);
			
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
	    	writer.write(((pasutijums)jaunsPas).izvadit());
	        writer.newLine();        
	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(null, "Kļūda", "", JOptionPane.ERROR_MESSAGE);
	    }
	        
			return jaunsPas;
	}
	
}
