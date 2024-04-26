package fedotova_pica;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;

public class picerija {

	public static void main(String[] args) {
		Queue<Object> picas = new LinkedList<Object>();
		String[] darbibas = {"Jauns pircejs", "Apkalpojiet klientu", "Aktivie pasutijumi", "Pabeigti pasutijumi", "Apturet"};
		String izvele;
			
		do {
			izvele = (String)JOptionPane.showInputDialog(null, "Darbibas", "Pica", JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			if(izvele == null) izvele = "Apturet";
				
			switch(izvele) {
			case "Jauns pircejs":
				Object sut = metodes.jaunsPasutijums(picas);
				picas.add(sut);
				break;
				
			case "Apkalpojiet klientu":
				Object pirc = picas.peek();
				((pasutijums)pirc).setAktivs(false);
				picas.remove();
				JOptionPane.showMessageDialog(null, "Kliens tiek apkalpots!", "Picerija", JOptionPane.INFORMATION_MESSAGE);
				break;
					
			case "Aktivie pasutijumi":
				metodes.lasitFailu(1);
				break;
					
			case "Pabeigti pasutijumi":
				metodes.lasitFailu(0);
				break;
					
			case "Apturet":
				JOptionPane.showMessageDialog(null, "Paldies par speli!");
				break;
			}
		}while(!izvele.equals("Apturet"));
	}

}
