package fedotova_picca;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;

public class picerija {

	public static void main(String[] args) {
		Queue<Object> picasAkt = new LinkedList<Object>();
		ArrayList<Object> picasPab = new ArrayList<Object>();
		String[] darbibas = {"Jauns klients", "Apkalpojiet klientu", "Aktivie pasūtūjumi", "Piegādes pasūtījumi", "Pabeigti pasūtījumi", "Apturet"};
		String izvele;

		do {
			izvele = (String)JOptionPane.showInputDialog(null, "Darbibas", "Pica", JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			if(izvele == null) izvele = "Apturet";

			switch(izvele) {
			case "Jauns klients":
				picasAkt = metodes.jaunsPasutijums(picasAkt);
				break;

			case "Apkalpojiet klientu":
				if(!picasAkt.isEmpty()) {
					Object pirc = picasAkt.peek();
					picasPab.add(pirc);
					if(((pasutijums)pirc).isPiegad()) 
						failiem.parrakstit("piegade.txt");
					else
						failiem.parrakstit("pasutijumi.txt");
					
					failiem.rakstitFaila(pirc, "pabeigti.txt");
					picasAkt.remove();
					JOptionPane.showMessageDialog(null, "Kliens tiek apkalpots!", "Picerija", JOptionPane.INFORMATION_MESSAGE);
				}else 
					JOptionPane.showMessageDialog(null, "Klientu vēl nav", "Picerija", JOptionPane.ERROR_MESSAGE);
				break;

			case "Aktivie pasūtūjumi":
				if(!picasAkt.isEmpty()) 
					failiem.lasitFailu("pasutijumi.txt");
				else 
					JOptionPane.showMessageDialog(null, "Klientu vēl nav", "Picerija", JOptionPane.ERROR_MESSAGE);	
				break;
				
			case "Piegādes pasūtījumi":
				if(!picasAkt.isEmpty()) {
					failiem.lasitFailu("piegade.txt");
				}else 
					JOptionPane.showMessageDialog(null, "Piegāde vēl nav", "Picerija", JOptionPane.ERROR_MESSAGE);
				break;

			case "Pabeigti pasūtījumi":
				if(!picasPab.isEmpty()) 
					failiem.lasitFailu("pabeigti.txt");
				else
					JOptionPane.showMessageDialog(null, "Pabeigtu pasūtījumu vēl nav", "Picerija", JOptionPane.ERROR_MESSAGE);
				break;

			case "Apturet":
				JOptionPane.showMessageDialog(null, "Paldies par speli!");
				failiem.clearFail("pabeigti.txt");
				failiem.clearFail("pasutijumi.txt");
				failiem.clearFail("piegade.txt");
				break;
			}
		}while(!izvele.equals("Apturet"));
	}

}
//DOSTAVKA
//VIBOR S POMOSHJU TOCHECHEK
//KARTINKI
//ZVUKI
//GIFKI
//...
