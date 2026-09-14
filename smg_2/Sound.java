package smg_2;

import javax.swing.*;
import java.io.*;
import javax.sound.sampled.*;

// To play sound using Clip, the process need to be alive.
// Hence, we use a Swing application.
public class Sound{
	public static void play(String filename)
	{
	    try
	    {
	        Clip clip = AudioSystem.getClip();
	        InputStream stream = Sound.class.getResourceAsStream(filename);
	        clip.open(AudioSystem.getAudioInputStream(new BufferedInputStream(stream)));
	        clip.start();
	    }
	    catch (Exception exc)
	    {
	        exc.printStackTrace(System.out);
	    }
	}
	public static void main(String[] args) {
		// System.out.println("Before play");
		play("/333"
				+ ".wav");
		
		SwingUtilities.invokeLater(() -> {
            // A GUI element to prevent the Clip's daemon Thread
            // from terminating at the end of the main()
            JOptionPane.showMessageDialog(null, "Close to exit!");
        });
		
		// System.out.println("After play");
	}
}