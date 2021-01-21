package smg_2;
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*; 
import java.util.concurrent.*; 

public class Translator extends Sound {
	static String[] morse = {".- ", "-... ",".-- ","--. ","-.. ",". ","...- ","--.. ",".. ",".--- ","-.- ",".-.. ","-- ","-. ","--- ",".--. ",".-. ","... ","- ","..- ","..-. ",".... ","-.-. ","---. ","---- ","--.- ","-..- ","-.-- ","..-- ",".-.- ","----- ",".---- ","..--- ","...-- ","....- ","..... ","-.... ","--... ","---.. ","----. ",".-.-.- ","--..-- ","..--.. ","-.-.-- ", "---... ","-.--. ","-.--.- ", "-....- ", "/ "};
	static String[] letters = {"а", "б", "в", "г", "д", "е", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ь", "ю", "я", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", ",", "?", "!", ":", "(", ")", "-", " "};
    static TimeUnit time = TimeUnit.MILLISECONDS;
    
	public static void main(String[] args) {
		JFrame f = new JFrame("Translator");
		f.setSize(615,500);
		
		JLabel l = new JLabel("Morse code translator", SwingConstants.CENTER);
		l.setBounds(0,0,615,50);
		l.setOpaque(true);
		l.setBackground(Color.yellow);
		
		JTextArea t = new JTextArea("Пример"); //creating instance of JTextArea
		t.setBounds(20, 70, 270, 340); // set x axis, y axis, width, height  of the JTextArea
		
		JTextArea t1 = new JTextArea(".- .-. .. -- . .-. "); //creating instance of JTextArea
		t1.setBounds(310, 70, 270, 340); // set x axis, y axis, width, height  of the JTextArea
		
		JButton translate = new JButton("Translate"); //creating instance of JButton
		translate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){  
	            t1.setText(sentence(t.getText()));  
			}  
		});
		JButton read = new JButton("read"); //creating instance of JButton 
		read.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){  
				sound(t1.getText());
			}  
		});
		JButton reverse = new JButton("R"); //creating instance of JButton 
	    JButton quit = new JButton("X"); //creating instance of JButton 
	    quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){  
				System.exit(0);
			}  
		});
		translate.setBounds(105,410,100,30); // set x axis, y axis, width, height  of the JButton
		read.setBounds(395,410,100,30); // set x axis, y axis, width, height  of the JButton
		reverse.setBounds(20,410,50,30); // set x axis, y axis, width, height  of the JButton
		quit.setBounds(530,410,50,30); // set x axis, y axis, width, height  of the JButton
		
		
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
	
	static String tr (String s) {
		int position = 0;
		for (int n = 0; n<49; n++) {
			if (s.equals(letters[n])){
				position = n; break;
			}
		}
		return morse[position];
	}
	
	static String sentence (String s) {
		String a = "";
		int length = s.length();
		char ch;
		String letter;
		for (int n = 0; n<length; n++) {
			ch = s.charAt(n);
			letter = String.valueOf(ch);
			a += tr(letter);
			if(n%20 == 0 && n != 0) {
				a += "\n";
			}
		}
		return a;
	}
	
	public static void sleep (long seconds) {
    	try { 
    		  time.sleep(seconds);  
        } 
    	catch (InterruptedException e) { 
            System.out.println("Interrupted "
                               + "while Sleeping"); 
        } 
    }
	
	static void sound (String s) {
		int length = s.length();
		char ch;
		for (int n = 0; n<length; n++) {
			ch = s.charAt(n);
			if (ch == '.') {
				play("/333_1+.wav");
			    sleep(333);
			}if (ch == '-') {
				play("/333_3+.wav");
				sleep(333);
			}else if (ch == ' ') {
				sleep(1000);
			}else if (ch == '/') {
				sleep(333);
			}
		}
	}

}
