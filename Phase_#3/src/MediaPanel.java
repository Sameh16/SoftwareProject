import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.plaf.synth.SynthSeparatorUI;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import uk.co.caprica.vlcj.runtime.x.LibXUtil;


    public class MediaPanel {
    	
        static JFrame frame = new JFrame("Game For All");
        public static void main(final String[] args) throws InterruptedException {
        	final ScheduledExecutorService s = Executors.newSingleThreadScheduledExecutor();
            s.schedule(new Runnable() {
                @Override
                public void run() {
                	frame.dispose();
                     chargerLibrairie();
                     try {
						new MediaPanel(args);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
                       
                }
               
            }, 0,TimeUnit.SECONDS);

         //   System.out.println("hi");
       // bye(frame);
           
             
        }

        static void chargerLibrairie(){
             NativeLibrary.addSearchPath(
                    RuntimeUtil.getLibVlcLibraryName(), "lib");
            Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);

        }
        
       
        public MediaPanel(String[] args) throws InterruptedException {
            JFrame frame = new JFrame("Game For All");
            frame.setLocation(100, 100);
            frame.setSize(1050, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            Canvas c = new Canvas();
            
            c.setBackground(Color.black);
            JPanel p = new JPanel();
            p.setLayout(new BorderLayout());
            p.add(c, BorderLayout.CENTER);
            frame.add(p, BorderLayout.CENTER);


            MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
   
            EmbeddedMediaPlayer mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer(new Win32FullScreenStrategy(frame));
            mediaPlayer.setVideoSurface(mediaPlayerFactory.newVideoSurface(c));
            
           // mediaPlayer.toggleFullScreen();
            
            mediaPlayer.setEnableMouseInputHandling(false);
           
            mediaPlayer.setEnableKeyInputHandling(true);
           
            
            mediaPlayer.prepareMedia("Juniors.mp4");
             
            mediaPlayer.play();
           
            try {
        		Thread.sleep(7000);
        		
        		frame.hide();
        	new MainPage();
        		 
        	} catch (InterruptedException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	} //close the frame after 1 second.
            
            
        }

		
    }