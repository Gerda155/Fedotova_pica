package fedotova_picca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Queue;
import javax.swing.JOptionPane;
import javax.swing.JSlider;

public class metodes {
	
	static int i = 1, d = 30;
	
	public static Object jaunsPasutijums(Queue<Object> picas1) {
		String[] picas = {"pica1", "pica2", "pica3", "pica4", "pica5", "pica6"};
		String[] dzerieni = {"CocaCola", "Fanta", "Pepsi"};
		//String[] diam = {"30", "40", "50"};
		String pic, dzer;
		boolean siers, pipari;
		double cena = 0;
		String diam;
		int choice;

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

	        JSlider slider = createSlider();
	        slider.setValue(d);
	        
	        
	        int option = JOptionPane.showConfirmDialog(null, new Object[]{"Izvelies picas diametru: ", slider}, "Выбор значения", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	        
	        if (option == JOptionPane.OK_OPTION) {
	            d = slider.getValue();
	            System.out.println("Выбранное значение: " + d);
	        } else {
	            System.out.println("Отменено");
	        }
	        
	        diam = String.valueOf(d);
	        
			if(diam.equals("40")) {
				cena += 0.50;
			}
			else if(diam.equals("50")) {
				cena ++;
			}

		dzer = (String)JOptionPane.showInputDialog(null, "Kadu dzerienu tu gribi?", "Dzeriens", JOptionPane.QUESTION_MESSAGE, null, dzerieni, dzerieni[0]);
			cena += 1.50;

	    choice = JOptionPane.showOptionDialog( null, "Vai tu gribi papildu sieru?", "Siers", JOptionPane.YES_NO_OPTION,
	        		 JOptionPane.QUESTION_MESSAGE, null, new String[]{"Jā", "Nē"}, "Nē");
			if(choice == JOptionPane.YES_OPTION){
				siers = true;
				cena += 0.50;
			}else siers = false;

		choice = JOptionPane.showOptionDialog( null, "Vai tu gribi papildu sieru?", "Siers", JOptionPane.YES_NO_OPTION,
	        	 JOptionPane.QUESTION_MESSAGE, null, new String[]{"Jā", "Nē"}, "Nē");
			if(choice == JOptionPane.YES_OPTION) {
				pipari = true;
				cena += 0.10;
			}else pipari = false;
			
		pasutijums jaunsPas = new pasutijums(pic, dzer, siers, pipari, cena, diam, i);
		i++;
		rakstitFaila(jaunsPas, "pasutijumi.txt");
		
			return jaunsPas;
	}
	
	static void rakstitFaila(Object jaunsPas, String failaNos) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(failaNos, true))) {
            writer.write(((pasutijums)jaunsPas).izvadit());
        } catch (IOException e) {
        	JOptionPane.showMessageDialog(null, "Kļūda 1.", "Kļūda", JOptionPane.ERROR_MESSAGE);
        }
 
	}

	static void lasitFailu(String failaNos) {
		StringBuilder pasut = new StringBuilder();
		
        try (BufferedReader reader = new BufferedReader(new FileReader(failaNos))) {
            String line;
            while ((line = reader.readLine()) != null) {
                pasut.append(line).append("\n");
            }
        } catch (IOException e) {
        	JOptionPane.showMessageDialog(null, "Kļūda 1.", "Kļūda", JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, pasut.toString(), "Faila saturs", JOptionPane.INFORMATION_MESSAGE);
	}
	
	static void clearFail(String failaNos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(failaNos, false))) {
        	
        } catch (IOException e) {
        	JOptionPane.showMessageDialog(null, "Kļūda 3", "Kļūda", JOptionPane.ERROR_MESSAGE);
        }
	}
	
	static void parrakstit() {
		
		 List<String> rindas = new ArrayList<>();
	        try (BufferedReader reader = new BufferedReader(new FileReader("pasutijumi.txt"))) {
	            String line;
	            int lineCount = 0;
	            while ((line = reader.readLine()) != null) {
	                if (lineCount >= 6) {
	                	rindas.add(line);
	                }
	                lineCount++;
	            }
	        } catch (IOException e) {
	        	JOptionPane.showMessageDialog(null, "Kļūda 1.", "Kļūda", JOptionPane.ERROR_MESSAGE);
	        }

	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("pasutijumi.txt"))) {
	            for (String i : rindas) {
	                writer.write(i);
	                writer.newLine();
	            }
	        } catch (IOException e) {
	        	JOptionPane.showMessageDialog(null, "Kļūda 1.", "Kļūda", JOptionPane.ERROR_MESSAGE);
	        }
	}
	
	static String Laiks() {
        Date time = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH : mm");
        String laiks = format.format(time);
        return laiks;
	}
	
    private static JSlider createSlider() {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 30, 50, 30);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        return slider;
    }
    
	
	}

