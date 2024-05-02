package Fedotova_pica;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class picerija {

	public static void main(String[] args) throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		Queue<Object> picasAkt = new LinkedList<Object>();
		ArrayList<Object> picasPab = new ArrayList<Object>();
		String[] darbibas = {"Jauns klients", "Apkalpot klientu", "Aktivie pasūtūjumi", "Piegādes pasūtījumi", "Aptūret"};
		ImageIcon pica_kot = new ImageIcon(".//atteli//pica_kot2.gif");
		ImageIcon pica_logo = new ImageIcon(".//atteli//pica_logo.png");
		String izvele = null;
        
		do {
			izvele = (String)JOptionPane.showInputDialog(null, "Darbīas", "Picērija", JOptionPane.QUESTION_MESSAGE, pica_logo, darbibas, darbibas[0]);
			if(izvele == null) 
				izvele = "Aptūret";
			switch(izvele) {
			case "Jauns klients":
				picasAkt = metodes.jaunsPasutijums(picasAkt);
				metodes.skana("kolokol.wav");
				JOptionPane.showMessageDialog(null, "Pasūtījums tika pieņemts", "Picērija", JOptionPane.INFORMATION_MESSAGE);
				break;

			case "Apkalpot klientu":
				if(!picasAkt.isEmpty()) {
					Object pirc = picasAkt.peek();
					picasPab.add(pirc);
					if(((pasutijums)pirc).isPiegad()) 
						failiem.parrakstit("piegade.txt");
					else
						failiem.parrakstit("pasutijumi.txt");
					
					failiem.rakstitFaila(pirc, "pabeigti.txt");
					picasAkt.remove();
					JOptionPane.showMessageDialog(null, "Kliens tiek apkalpots!", "Picērija", JOptionPane.INFORMATION_MESSAGE);
				}else {
					metodes.skana("no.wav");
					JOptionPane.showMessageDialog(null, "Nav pasūtījumu", "Picērija", JOptionPane.ERROR_MESSAGE);
				}
				break;

			case "Aktivie pasūtūjumi":
				if(!picasAkt.isEmpty()) 
					failiem.lasitFailu("pasutijumi.txt");
				else {
					metodes.skana("no.wav");
					JOptionPane.showMessageDialog(null, "Nav aktīvu pasūtījumu", "Picērija", JOptionPane.ERROR_MESSAGE);
				}
				break;
				
			case "Piegādes pasūtījumi":
				if(!picasAkt.isEmpty()) {
					failiem.lasitFailu("piegade.txt");
				}else {
					metodes.skana("no.wav");
					JOptionPane.showMessageDialog(null, "Nav piegādes pasūtījumu", "Picērija", JOptionPane.ERROR_MESSAGE);
				}
				break;

			case "Pabeigti pasūtījumi":
				if(!picasPab.isEmpty()) 
					failiem.lasitFailu("pabeigti.txt");
				else {
					metodes.skana("no.wav");
					JOptionPane.showMessageDialog(null, "Pabeigtu pasūtījumu vēl nav", "Picērija", JOptionPane.ERROR_MESSAGE);
				}
				break;

			case "Aptūret":
				metodes.skana("kids.wav");
				JOptionPane.showMessageDialog(null,"", "Paldies par speli! :3", JOptionPane.INFORMATION_MESSAGE, pica_kot);
				failiem.clearFail("pabeigti.txt");
				failiem.clearFail("pasutijumi.txt");
				failiem.clearFail("piegade.txt");
				break;
			}
		}while(!izvele.equals("Aptūret"));
	}

}