package Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JLabel;

public class MainServer {
	
	private ServerSocket listener;
	private Socket socket;
	private BufferedReader input;
	private BufferedWriter output;
	
	public static void main(String[] args) {
		new MainServer();
	}
	
	public MainServer() {
		System.out.println("���� ����");
		try {
			listener = new ServerSocket(10501);
			socket=listener.accept();
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (Exception e) {
			System.out.println("���� ���� �̽�:"+e.getMessage());
		}
	
		while(true){
			try {
				if(input.readLine()!=null) {
					output.write("���ۿϷ��߽��ϴ�.");
					output.flush();
					}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				break;
			}	
		}
		
		try {
			System.out.println("���� ����");
			socket.close();
			listener.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	
	
		
		
	}
	

}
