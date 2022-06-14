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
	private JTextField textField; //채팅 입력칸
	private JPanel boardArea; //채팅창
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
		setTitle("채팅 프로그램");
		
		contentPane = new JPanel();
		contentpane_borderBorder=new TitledBorder(new LineBorder(Color.black)); 
		textField=new JTextField(" ", 100); 
		boardArea= new JPanel();
		inputButton= new JButton("전송");
		server=new ServerAccessing();
		
		
		contentPane.add(boardArea);
		contentPane.add(textField);
		contentPane.add(inputButton);
		
	
		boardArea.setLayout(new FlowLayout());
		boardArea.add(new JLabel("채팅을 시작합니다."));
		boardArea.setBorder(contentpane_borderBorder);
		boardArea.setPreferredSize(new Dimension(850, 700));
		
		contentPane.setBorder(contentpane_borderBorder); //테두리를 검은색으로 설정
		contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);
		
		textField.addKeyListener(new KeyAdapter() {
			
		@Override
		public void keyTyped(KeyEvent e) {
			if(e.getKeyChar()==KeyEvent.VK_ENTER) { //ENTER가 눌려졌을 때.
				System.out.println("버튼이 클릭 되었습니다"); //밑에 버튼 액션이랑 같아야 한다.
			}
				
		}
			
		});
		
		inputButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼이 클릭 되었습니다");
				//server.putOutput(textField.getText());
				System.out.println(textField.getText()); //테스팅 코드
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
