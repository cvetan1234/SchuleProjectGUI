package smg_2;
import javax.swing.*;  
import java.awt.*;

public class Translator {
	public static void main(String[] args) {
		JFrame f = new JFrame("Translator");
		f.setSize(615,500);
		
		JLabel l = new JLabel("Morse code translator", SwingConstants.CENTER);
		l.setBounds(0,0,615,50);
		l.setOpaque(true);
		l.setBackground(Color.yellow);
		
		JTextArea t = new JTextArea("Exаmple"); //creating instance of JTextArea
		t.setBounds(20, 70, 270, 340); // set x axis, y axis, width, height  of the JTextArea
		
		JTextArea t1 = new JTextArea(". -..- .- -- .--. .-.. ."); //creating instance of JTextArea
		t1.setBounds(310, 70, 270, 340); // set x axis, y axis, width, height  of the JTextArea
		
		JButton translate = new JButton("Translate"); //creating instance of JButton 
		JButton read = new JButton("read"); //creating instance of JButton 
		JButton reverse = new JButton("R"); //creating instance of JButton 
	    JButton quit = new JButton("X"); //creating instance of JButton 
		translate.setBounds(105,410,100,30); // set x axis, y axis, width, height  of the JButton
		read.setBounds(395,410,100,30); // set x axis, y axis, width, height  of the JButton
		reverse.setBounds(20,410,20,20); // set x axis, y axis, width, height  of the JButton
		quit.setBounds(560,410,20,20); // set x axis, y axis, width, height  of the JButton
		
		f.add(translate); //add the elements to the Frame
		f.add(read);
		f.add(reverse);
		f.add(quit);
		f.add(l);
		f.add(t);
		f.add(t1);
		
		f.setLayout(null); // using no layout managers
		f.setVisible(true); 
	}
}
