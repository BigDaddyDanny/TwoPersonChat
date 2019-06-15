import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Host {
	
	public static void main(String [] args) throws IOException {
		
		ServerSocket server = new ServerSocket(21514);
		
		Socket socket = server.accept();
		System.out.println("Connection Successful");
		
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		
		new MessageListener(socket).start();

		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		while(!input.equals("exit")) {
			out.println(input);
			input = scan.nextLine();
		}
		
		out.println(input);
				
		scan.close();
		out.close();
		socket.close();
		server.close();
		
		System.exit(0);
		
	}
}