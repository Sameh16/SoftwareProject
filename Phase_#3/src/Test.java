import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class Test {

	private JFrame frame;
	private JTextField textField;
	private String UserName;
	private JFrame lastPage;
	// private boolean isTeacher;
	// private boolean isCreate;

	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @param b
	 * @param username2
	 * @param isTeacher2
	 * @param frame2
	 */
	public Test(JFrame frame2, boolean isTeacher2, String username2, boolean b) {
		lastPage = frame2;
		// isTeacher=isTeacher2;
		// isCreate=b;
		UserName = username2;
		main();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("back.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
		frame.setSize(1050, 600);
		frame.getContentPane().setLayout(null);

		JComboBox<String> category = new JComboBox<String>();
		category.setBounds(247, 100, 108, 20);
		frame.getContentPane().add(category);

		Controller controller = new Controller();
		ArrayList<Category> categories = controller.LoadCategory();
		for (int i = 0; i < categories.size(); i++) {
			category.addItem(categories.get(i).getName());
		}

		JComboBox<String> type = new JComboBox<>();
		type.setBounds(247, 171, 108, 20);
		frame.getContentPane().add(type);

		ArrayList<Type> types = controller.LoadGameTypes(categories.get(0).getName());
		for (int i = 0; i < types.size(); i++) {
			type.addItem(types.get(i).getTypeName());
		}

		category.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				type.removeAllItems();
				ArrayList<Type> types = controller.LoadGameTypes(category.getSelectedItem().toString());
				for (int i = 0; i < types.size(); i++) {
					type.addItem(types.get(i).getTypeName());
				}

			}
		});

		JLabel lblCategory = new JLabel("Category ");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCategory.setForeground(Color.WHITE);
		lblCategory.setBounds(74, 64, 100, 85);
		frame.getContentPane().add(lblCategory);

		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblType.setForeground(Color.WHITE);
		lblType.setBounds(74, 147, 100, 60);
		frame.getContentPane().add(lblType);

		JLabel lblGameName = new JLabel("Game name ");
		lblGameName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGameName.setForeground(Color.WHITE);
		lblGameName.setBounds(74, 232, 142, 42);
		frame.getContentPane().add(lblGameName);

		textField = new JTextField();
		textField.setBounds(247, 247, 108, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSubmit.setBounds(149, 361, 142, 42);
		frame.getContentPane().add(btnSubmit);

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lastPage.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(20, 493, 108, 49);
		frame.getContentPane().add(btnBack);

		btnSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter Game Name Plz");

				} else {
					String m = JOptionPane.showInputDialog("Enter Number of Level");
					Game game = new Game();
					game.setCatName(category.getSelectedItem().toString());
					game.setTypeName(type.getSelectedItem().toString());
					game.setGameName(textField.getText().toString());
					if (game.CreateGame(UserName)) {
						if (game.getTypeName().equals("MCQ")) {
							new insertintoMultipleChoice(Integer.parseInt(m), game.getGameName(), lastPage);
						} else if (game.getTypeName().equals("TF")) {
							new insertTrueFalse(Integer.parseInt(m), game.getGameName(), lastPage);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Valid Game Name Plz");
					}

				}
			}
		});
	}
}
