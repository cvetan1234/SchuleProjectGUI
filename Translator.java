package smg_2;
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*; 
import java.util.concurrent.*; 

public class Translator extends Sound {
	static String[] morse = {"", ".- ", "-... ",".-- ","--. ","-.. ",". ","...- ","--.. ",".. ",".--- ","-.- ",".-.. ","-- ","-. ","--- ",".--. ",".-. ","... ","- ","..- ","..-. ",".... ","-.-. ","---. ","---- ","--.- ","-..- ","-.-- ","..-- ",".-.- ","----- ",".---- ","..--- ","...-- ","....- ","..... ","-.... ","--... ","---.. ","----. ",".-.-.- ","--..-- ","..--.. ","-.-.-- ", "---... ","-.--. ","-.--.- ", "-....- ", "/ "};
	static String[] letters = {"", "а", "б", "в", "г", "д", "е", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ь", "ю", "я", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", ",", "?", "!", ":", "(", ")", "-", " "};
    static TimeUnit time = TimeUnit.MILLISECONDS;
    static boolean reversedOrNotReversed = true;
    static boolean isTheInformationCorrect = true;
    static String text;
    
	public static void main(String[] args) {
		JFrame f = new JFrame("Translator");
		f.setSize(615,500);
		f.getContentPane().setBackground(new Color(54,129,74));
		
		JPanel panel1 = new JPanel();  
	    panel1.setBounds(0,0,615,164);    
	    panel1.setBackground(Color.white); 
	    
	    JPanel panel2 = new JPanel();  
	    panel2.setBounds(0,164,615,164);    
	    panel2.setBackground(new Color(0,153,0));  
	    
	    JPanel panel3 = new JPanel();  
	    panel3.setBounds(0,328,615,164);    
	    panel3.setBackground(new Color(255,0,0));  
	 
	    f.add(panel1);
	    f.add(panel2);
	    f.add(panel3);
		
		JLabel l = new JLabel("Morse code translator", SwingConstants.CENTER);
		l.setBounds(0,0,615,50);
		l.setOpaque(true);
		l.setBackground(Color.yellow);
		
		JLabel reversed = new JLabel ("Letters to morse code", SwingConstants.CENTER);
		reversed.setBounds(0,12,200,100);
		
		JTextArea t = new JTextArea("Пример"); //creating instance of JTextArea
		t.setBounds(20, 70, 270, 340); // set x axis, y axis, width, height  of the JTextArea
		
		JTextArea t1 = new JTextArea(".--. .-. .. -- . .-. "); //creating instance of JTextArea
		t1.setBounds(310, 70, 270, 340); // set x axis, y axis, width, height  of the JTextArea
		
		JButton translate = new JButton("Translate"); //creating instance of JButton
		translate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){ 
				if (reversedOrNotReversed) {
					text = sentence(t.getText());
					if (isTheInformationCorrect) {
						t1.setText(text);
					}else {
						t1.setText("Wrong input.");
					}
				} else {
					text = sentenceReversed(t.getText());
					if (isTheInformationCorrect) {
						t1.setText(text);
					}else {
						t1.setText("Wrong input.");
					}
				}
				
			}  
		});
		JButton read = new JButton("read"); //creating instance of JButton 
		read.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){  
				if (reversedOrNotReversed) {
					sound(t1.getText());
				}else {
					sound(t.getText());
				}
			}  
		});
		JButton reverse = new JButton("R"); //creating instance of JButton 
		reverse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				reversedOrNotReversed = !reversedOrNotReversed;
				if (reversedOrNotReversed) {
					reversed.setText("Letters to morse code");
					t.setText("Пример");
					t1.setText(".--. .-. .. -- . .-. ");
				} else {
					reversed.setText("Morse code to letters");
					t.setText(".--. .-. .. -- . .-. ");
					t1.setText("Пример");
				}
			}  
		});
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
		
		JButton start = new JButton("Morse code translator: bulgarian <-> morse code");
		start.setBounds(90,195,450,100); 
		start.setBackground(new Color(0,153,0));
		start.setFont(new Font("Arial", Font.ITALIC, 15));
		f.add(start);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){ 
			reverse.setBackground(new Color(233,177,80));	
			read.setBackground(new Color(233,177,80));
			quit.setBackground(new Color(233,177,80));
			translate.setBackground(new Color(233,177,80));
			reversed.setForeground(Color.yellow);
			l.setFont(new Font("", Font.BOLD, 17));
			l.setBackground(new Color(233,177,80));
			f.remove(start);
			f.remove(panel1);
			f.remove(panel2);
			f.remove(panel3);
			f.add(translate); 
			f.add(read);
			f.add(quit);
			f.add(reverse);
			f.add(reversed);
			f.add(l);
			f.add(t);
			f.add(t1);
			f.repaint();
			}
		});
		
		f.setLayout(null); // using no layout managers
		f.setVisible(true);
	}
	
	static String tr (String s) {
		int position = 0;
		for (int n = 0; n<50; n++) {
			if (s.equals(letters[n])){
				position = n; break;
			}
		}
		if (position == 0) {
			isTheInformationCorrect = false;
		} else {
			isTheInformationCorrect = true;
		}
		return morse[position];
	}
	
	static String trReversed (String s) {
		int position = 0;
		for (int n = 0; n<50; n++) {
			if (s.equals(morse[n])){
				position = n; break;
			}
		}
		if (position == 0) {
			isTheInformationCorrect = false;
		} else {
			isTheInformationCorrect = true;
		}
		return letters[position];
	}
	
	static String sentence (String s) {
		s = s.toLowerCase();
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
	
	static String sentenceReversed (String s) {
		String a = "";
		String symbol = "";
		String letter = "";
		char ch = s.charAt(0);
		int length = s.length();
		if (s.charAt(length-1) != ' ') {
			s += ' ';
		}
		for (int n = 0; n<length; n++) {
			ch = s.charAt(n);
			while (ch != ' ') {
				letter = String.valueOf(ch);
				symbol += letter;
				n++;
				ch = s.charAt(n);
			} 
			symbol += " ";
			a += trReversed(symbol);
			symbol = "";
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
				sleep(500);
			}if (ch == '-') {
				play("/333_3+.wav");
				sleep(1500);
			}else if (ch == ' ') {
				sleep(500);
			}else if (ch == '/') {
				sleep(1500);
			}
		}
	}
}