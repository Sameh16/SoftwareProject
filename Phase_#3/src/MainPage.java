import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class MainPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Game For All");
		frame.setLocation(100, 100);
        frame.setSize(1050,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//backs
		

		try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("back.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.setSize(1050, 600);
		
		
		JButton btnNewButton = new JButton("Log In as Teacher");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(126, 186, 307, 69);
		frame.getContentPane().add(btnNewButton);

		JButton btnLogInAs = new JButton("Log In as Student");
		btnLogInAs.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLogInAs.setBounds(126, 70, 307, 69);
		frame.getContentPane().add(btnLogInAs);

		JButton btnSignUpAs = new JButton("Signup as Teacher");
		btnSignUpAs.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSignUpAs.setBounds(126, 424, 307, 69);
		frame.getContentPane().add(btnSignUpAs);

		JButton btnSignUpAs_1 = new JButton("Sign Up as Student");
		btnSignUpAs_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSignUpAs_1.setBounds(126, 308, 307, 67);
		frame.getContentPane().add(btnSignUpAs_1);
		
	
		
		frame.setVisible(true);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				new Log_In(frame, true);
			}
		});

		btnLogInAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				new Log_In(frame, false);
			}
		});

		btnSignUpAs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				new Registration(frame, true);
			}
		});

		btnSignUpAs_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				new Registration(frame, false);
			}
		});
	}
}
