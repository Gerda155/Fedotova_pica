package fedotova_picca;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;

public class picerija {

	public static void main(String[] args) {
		Queue<Object> picasAkt = new LinkedList<Object>();
		ArrayList<Object> picasPab = new ArrayList<Object>();
		String[] darbibas = {"Jauns pircejs", "Apkalpojiet klientu", "Aktivie pasutijumi", "Pabeigti pasutijumi", "Apturet"};
		String izvele;

		do {
			izvele = (String)JOptionPane.showInputDialog(null, "Darbibas", "Pica", JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			if(izvele == null) izvele = "Apturet";

			switch(izvele) {
			case "Jauns pircejs":
				Object sut = metodes.jaunsPasutijums(picasAkt);
				picasAkt.add(sut);
				break;

			case "Apkalpojiet klientu":
				if(picasAkt != null) {
					Object pirc = picasAkt.peek();
					picasPab.add(pirc);
					metodes.rakstitFaila(pirc, "pabeigti.txt");
					picasAkt.remove();
					metodes.parrakstit();
					JOptionPane.showMessageDialog(null, "Kliens tiek apkalpots!", "Picerija", JOptionPane.INFORMATION_MESSAGE);
				}else 
					JOptionPane.showMessageDialog(null, "Klientu vēl nav", "Picerija", JOptionPane.ERROR_MESSAGE);
				break;

			case "Aktivie pasutijumi":
				if(picasAkt != null) 
					metodes.lasitFailu("pasutijumi.txt");
				else 
					JOptionPane.showMessageDialog(null, "Klientu vēl nav", "Picerija", JOptionPane.ERROR_MESSAGE);
					
				break;

			case "Pabeigti pasutijumi":
				if(picasPab != null) 
					metodes.lasitFailu("pabeigti.txt");
				else
					JOptionPane.showMessageDialog(null, "Pabeigtu pasūtījumu vēl nav", "Picerija", JOptionPane.ERROR_MESSAGE);
				break;

			case "Apturet":
				JOptionPane.showMessageDialog(null, "Paldies par speli!");
				metodes.clearFail("pabeigti.txt");
				metodes.clearFail("pasutijumi.txt");
				break;
			}
		}while(!izvele.equals("Apturet"));
	}

}
