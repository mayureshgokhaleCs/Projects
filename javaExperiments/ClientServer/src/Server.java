import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(45000);
		while(true){
		Socket soc = ss.accept();

		InputStream is = soc.getInputStream();
		OutputStream os = soc.getOutputStream();
		PrintWriter pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(os)),true);
		BufferedReader br=new BufferedReader(new InputStreamReader(is));
		
		
	    String str =br.readLine();
	    while(!str.equals("end")){
         System.out.println("recieved---"+str);
         str=br.readLine();
	}
	}
}
}