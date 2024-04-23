package fedotova_pica;

import javax.swing.JOptionPane;

public class picerija {

	public static void main(String[] args) {
		
			String[] darbibas = {"Jauns pircejs", "Aktivie pasutijumi", "Pabeigti pasutijumi", "Apturet"};
			String izvele;
			
			do {
				izvele = (String)JOptionPane.showInputDialog(null, "Darbibas", "Pica", JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
				
			}while(!izvele.equals("Apturet"));
	}

}
