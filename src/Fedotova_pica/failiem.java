package Fedotova_pica;

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
        	JOptionPane.showMessageDialog(null, "Kļūda"+e, "Kļūda", JOptionPane.ERROR_MESSAGE);
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
        	JOptionPane.showMessageDialog(null, "Kļūda"+e, "Kļūda", JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, pasut.toString(), "Faila saturs", JOptionPane.INFORMATION_MESSAGE);
	}
	
	static void clearFail(String failaNos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(failaNos, false))) {
        	
        } catch (IOException e) {
        	JOptionPane.showMessageDialog(null, "Kļūda"+e, "Kļūda", JOptionPane.ERROR_MESSAGE);
        }
	}
	
	static void parrakstit(String fail) {
		
		 List<String> rindas = new ArrayList<>();
	        try (BufferedReader reader = new BufferedReader(new FileReader(fail))) {
	            String line;
	            int lineCount = 0;
	            while ((line = reader.readLine()) != null) {
	                if (fail.equals("pasutijumi.txt") && lineCount >= 6 || fail.equals("piegade.txt") && lineCount >= 9) {
	                	rindas.add(line);
	                }
	                lineCount++;
	            }
	        } catch (IOException e) {
	        	JOptionPane.showMessageDialog(null, "Kļūda"+e, "Kļūda", JOptionPane.ERROR_MESSAGE);
	        }

	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fail))) {
	            for (String i : rindas) {
	                writer.write(i);
	                writer.newLine();
	            }
	        } catch (IOException e) {
	        	JOptionPane.showMessageDialog(null, "Kļūda"+e, "Kļūda", JOptionPane.ERROR_MESSAGE);
	        }
	}

}
