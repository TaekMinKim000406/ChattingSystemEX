package Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Client.ServerAccessing;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField; //ä�� �Է�ĭ
	private JPanel boardArea; //ä��â
	private JButton inputButton;
	private TitledBorder contentpane_borderBorder;
	private ServerAccessing server;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 850);
		setTitle("ä�� ���α׷�");
		
		contentPane = new JPanel();
		contentpane_borderBorder=new TitledBorder(new LineBorder(Color.black)); 
		textField=new JTextField(" ", 100); 
		boardArea= new JPanel();
		inputButton= new JButton("����");
		server=new ServerAccessing();
		
		
		contentPane.add(boardArea);
		contentPane.add(textField);
		contentPane.add(inputButton);
		
	
		boardArea.setLayout(new FlowLayout());
		boardArea.add(new JLabel("ä���� �����մϴ�."));
		boardArea.setBorder(contentpane_borderBorder);
		boardArea.setPreferredSize(new Dimension(850, 700));
		
		contentPane.setBorder(contentpane_borderBorder); //�׵θ��� ���������� ����
		contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);
		
		textField.addKeyListener(new KeyAdapter() {
			
		@Override
		public void keyTyped(KeyEvent e) {
			if(e.getKeyChar()==KeyEvent.VK_ENTER) { //ENTER�� �������� ��.
				System.out.println("��ư�� Ŭ�� �Ǿ����ϴ�"); //�ؿ� ��ư �׼��̶� ���ƾ� �Ѵ�.
			}
				
		}
			
		});
		
		inputButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("��ư�� Ŭ�� �Ǿ����ϴ�");
				//server.putOutput(textField.getText());
				System.out.println(textField.getText()); //�׽��� �ڵ�
				textField.setText("");
				
			}
		});
		
			
		
		while(true){
			if(server.getInput()!=null) {
				boardArea.add(new JLabel(server.getInput()));
			}
			
		}
		
	
		
		
		
	}

}
