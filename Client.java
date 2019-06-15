import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {	

	public static void main(String[] args) throws IOException{
				
			
		Socket client = new Socket("192.168.1.15", 21514);
		System.out.println("Connection Succesful");
			
		PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			
		new MessageListener(client).start();
			
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		while(!input.equals("exit")) {
			
			out.println(input);
				
			input = scan.nextLine();
		}
			
		out.println(input);
			
		client.close();
		scan.close();
		out.close();
		System.exit(0);	
		
	}
	
}
