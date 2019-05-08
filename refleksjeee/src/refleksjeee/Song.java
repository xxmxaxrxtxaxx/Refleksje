package refleksjeee;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.Box;

public class Song {

	private JFrame frame;
	private JTextField textField;
	private String nazwa;
	private JTextField textField_1;
	private JTextField nazwaZmiennej;
	private Box lewy;
	private Box prawy;
	private JTextArea textArea1;
	ArrayList<JTextField> tablicaText = new ArrayList<JTextField>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					Song window = new Song();
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
	public Song() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setPreferredSize(new Dimension(500, 500));// ustawienie wielkoœci
														// okienka
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(10, 11, 140, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Create Object");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				nazwa = textField.getText();

				Class classs;
				// Class classss;
				try {

					classs = Class.forName(nazwa);
					Object obj = classs.newInstance();
					Field[] field = obj.getClass().getDeclaredFields();
					for (int i = 0; i < field.length; i++) {
					
						field[i].setAccessible(true);
						String nazwazmiennej = field[i].getName().toString();
						
					
						if(nazwazmiennej.equals("text")){
							
							textArea1 = new JTextArea();
							JScrollPane jp= new JScrollPane(textArea1);
							
							JTextArea textArea2 = new JTextArea();
							lewy.add(jp);
							textArea1.setText((String.valueOf(field[i].get(obj))));
							textArea1.setPreferredSize(new Dimension(50, 50));
							
							prawy.add(textArea2);
							textArea2.setPreferredSize(new Dimension(50, 50));
							textArea2.setText("<-- "+nazwazmiennej);
							
							
						}else{
						
						
						JTextField pole = new JTextField();
						lewy.add(pole);
						pole.setColumns(5);
						pole.setText((String.valueOf(field[i].get(obj))));
						tablicaText.add(pole); // dopisywanie kazdego textFieldu, do tablicy textFields
						//pole.setText(field[i].get(obj).toString());
						nazwaZmiennej = new JTextField();
						prawy.add(nazwaZmiennej);
						nazwaZmiennej.setColumns(5);
						nazwaZmiennej.setText("<-- "+nazwazmiennej);
						
						}
					}

					frame.pack();

				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| SecurityException e1) {
					System.out.println("Nie ma takiej klasy");

				}

			}
		});
		btnNewButton.setBounds(160, 10, 134, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Save Changes");
		btnNewButton_1.setBounds(294, 10, 130, 23);
		frame.getContentPane().add(btnNewButton_1);

		JPanel panel = new JPanel();
		panel.setBounds(20, 42, 404, 140);
		frame.getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		Box horizontalBox = Box.createHorizontalBox();

		JScrollPane hboxPane = new JScrollPane(horizontalBox);
		panel.add(horizontalBox);

		lewy = Box.createVerticalBox();
		horizontalBox.add(lewy);

		/*
		 * textField_1 = new JTextField(); lewy.add(textField_1);
		 * textField_1.setColumns(10); textField_2 = new JTextField();
		 * lewy.add(textField_2); textField_2.setColumns(10);
		 */

		prawy = Box.createVerticalBox();
		horizontalBox.add(prawy);

		/*
		 * textField_2 = new JTextField(); prawy.add(textField_2);
		 * textField_2.setColumns(10);
		 */

		JTextArea textArea = new JTextArea();
		textArea.setBounds(20, 193, 404, 57);
		frame.getContentPane().add(textArea);
		
		
	}
}
