package Client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerAccessing {
	private Socket socket;
	private BufferedReader input;
	private BufferedWriter output;
	
	public static void main(String[] args) {
		new ServerAccessing();
	}
	
	
	
	public ServerAccessing() {
		try {
			Socket socket= new Socket("localhost", 10501);
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
	}
	
	
	public String getInput() {
		try {
			return input.readLine();		
		} catch (Exception e) {
			return null;
		}
		}
	
	
	public void putOutput(String output) {
		try {
			this.output.write(output+"\n");
			this.output.flush();
		} catch (Exception e) {
			
		}
	}

}
