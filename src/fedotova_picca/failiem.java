package fedotova_picca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class failiem {
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
}
