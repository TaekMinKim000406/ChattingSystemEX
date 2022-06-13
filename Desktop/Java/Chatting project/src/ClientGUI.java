import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClientGUI extends JFrame {
	private JTextField textField;
	public ClientGUI() {
		
		textField = new JTextField();
		getContentPane().add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
	}
	void ClientGUI() {		
		setTitle("채팅 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c= getContentPane();
		
		JTextArea board = new JTextArea(100,20);
		JTextField inputboard = new JTextField();
		board.setVisible(true);
		inputboard.setVisible(true);
		
		c.add(board);
		c.add(inputboard);
		
		setSize(1000,2000);
		setVisible(true);
		
	
	}
	
	public static void main(String[] args) {
		System.out.print("실행중");
		new ClientGUI();
		
	}
}
