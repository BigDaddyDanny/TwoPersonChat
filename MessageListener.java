import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MessageListener extends Thread{

	private BufferedReader in; 
	
	public MessageListener(Socket s) {
		try {
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run(){
		
		try {
			
			while(true) {
				
				String line = in.readLine();
				if(line.equals("exit")) {
					break;
				}else {
					System.out.println(line);
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.exit(0);
	}
	
}
