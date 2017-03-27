import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class playtest {

	private JFrame frame;
	private String UserName;
	private JFrame lastPage;
	private boolean isTeacher;
	private boolean removed;

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
	 * @param isTeacher
	 */
	public playtest(JFrame frame2, boolean isTeacher, String username2) {
		lastPage = frame2;
		UserName = username2;
		this.isTeacher = isTeacher;
		removed = false;
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
		category.setBounds(236, 111, 136, 20);
		frame.getContentPane().add(category);

		JComboBox<String> type = new JComboBox<>();
		type.setBounds(236, 175, 136, 20);
		frame.getContentPane().add(type);

		JComboBox<String> gameBox = new JComboBox<String>();
		gameBox.setBounds(236, 242, 136, 20);
		frame.getContentPane().add(gameBox);

		Controller controller = new Controller();

		ArrayList<Category> categories = controller.LoadCategory();
		for (int i = 0; i < categories.size(); i++) {
			category.addItem(categories.get(i).getName());
		}

		ArrayList<Type> types = controller.LoadGameTypes(categories.get(0).getName());
		for (int i = 0; i < types.size(); i++) {
			type.addItem(types.get(i).getTypeName());
		}

		ArrayList<Game> games = controller.LoadGameData(categories.get(0).getName(), types.get(0).getTypeName());
		for (int i = 0; i < games.size(); i++) {
			gameBox.addItem(games.get(i).getGameName());
		}
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSubmit.setBounds(194, 360, 136, 37);
		frame.getContentPane().add(btnSubmit);


		category.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removed = true;
				type.removeAllItems();

				ArrayList<Type> types = controller.LoadGameTypes(category.getSelectedItem().toString());
				for (int i = 0; i < types.size(); i++) {

					type.addItem(types.get(i).getTypeName());
				}
				type.setSelectedIndex(0);

				ArrayList<Game> games = controller.LoadGameData(category.getSelectedItem().toString(),
						types.get(0).getTypeName());
				for (int i = 0; i < games.size(); i++) {
					gameBox.addItem(games.get(i).getGameName());
				}

			}
		});

		type.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (removed) {
					removed = false;
					return;
				}
				String CatName = category.getSelectedItem().toString();
				String TypeName = type.getSelectedItem().toString();
				gameBox.removeAllItems();
				ArrayList<Game> games = controller.LoadGameData(CatName, TypeName);
				for (int i = 0; i < games.size(); i++) {
					gameBox.addItem(games.get(i).getGameName());
				}
				if(games.size()==0)
				{
					JOptionPane.showMessageDialog(null, "This Type not Have Games");
					btnSubmit.hide();
				}
				else
				{
					btnSubmit.show();
				}

			}
		});
		JLabel lblCategory = new JLabel("Category ");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCategory.setForeground(Color.WHITE);
		lblCategory.setBounds(100, 56, 126, 122);
		frame.getContentPane().add(lblCategory);

		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblType.setForeground(Color.WHITE);
		lblType.setBounds(100, 144, 126, 75);
		frame.getContentPane().add(lblType);

		JLabel lblGameName = new JLabel("Games");
		lblGameName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGameName.setForeground(Color.WHITE);
		lblGameName.setBounds(100, 230, 136, 37);
		frame.getContentPane().add(lblGameName);

	
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				lastPage.setVisible(true);
			}
		});
		btnBack.setBounds(25, 481, 126, 53);
		frame.getContentPane().add(btnBack);

		btnSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Game game = new Game();
				
				game.setCatName(category.getSelectedItem().toString());
				game.setTypeName(type.getSelectedItem().toString());
				game.setGameName(gameBox.getSelectedItem().toString());
				int A = 0;
				if (game.getTypeName().equals("MCQ")) {
					frame.setVisible(false);
					if (!isTeacher) {
						if ((A = controller.loadStudentAchievement(UserName, game.getGameName())) == -1) {
							controller.SaveStudentAchievement(UserName, game.getGameName());
							A = 0;
						}
					}
					new PlayMultipleChoiceGame(game, UserName, lastPage, isTeacher, A);
				} else if (game.getTypeName().equals("TF")) {
					frame.setVisible(false);
					if (!isTeacher) {
						if ((A = controller.loadStudentAchievement(UserName, game.getGameName())) == -1) {
							controller.SaveStudentAchievement(UserName, game.getGameName());
							A = 0;
						}
					}
					new PlayTrueFalseGame(game, UserName, lastPage, isTeacher, A);
				}

			}
		});
	}
}
