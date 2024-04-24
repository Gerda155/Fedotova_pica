package fedotova_pica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class picerija {

	public static void main(String[] args) {
		ArrayList<Object> picas = new ArrayList<Object>();
		String[] darbibas = {"Jauns pircejs", "Aktivie pasutijumi", "Pabeigti pasutijumi", "Apturet"};
		String izvele;
			
		do {
			izvele = (String)JOptionPane.showInputDialog(null, "Darbibas", "Pica", JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			if(izvele == null) izvele = "Apturet";
				
			switch(izvele) {
			case "Jauns pircejs":
				Object sut = metodes.jaunsPasutijums(picas);
				picas.add(sut);
				break;
					
			case "Aktivie pasutijumi":
				metodes.aktiviePas();
				break;
					
			case "Pabeigti pasutijumi":
				break;
					
			case "Apturet":
				JOptionPane.showMessageDialog(null, "Paldies par speli!");
				break;
			}
		}while(!izvele.equals("Apturet"));
	}

}
