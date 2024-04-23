package fedotova_pica;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class picerija {

	public static void main(String[] args) {
		
			String[] darbibas = {"Jauns pircejs", "Aktivie pasutijumi", "Pabeigti pasutijumi", "Apturet"};
			ArrayList pica = new ArrayList();
			String izvele;
			
			do {
				izvele = (String)JOptionPane.showInputDialog(null, "Darbibas", "Pica", JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
				if(izvele == null) izvele = "Apturet";
				
				switch(izvele) {
				case "Jauns pircejs":
					
					break;
					
				case "Aktivie pasutijumi":
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
