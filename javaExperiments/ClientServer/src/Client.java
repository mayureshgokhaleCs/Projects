import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		// TODO Auto-generated method stub
		Socket soc = new Socket("127.0.0.1", 45000);
		System.out.println("client signing in");
		InputStream is = soc.getInputStream();
		OutputStream os = soc.getOutputStream();
		
		PrintWriter pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(os)),true);
		BufferedReader br=new BufferedReader(new InputStreamReader(is));
		
		for (int i=0;i<3;i++){
			pw.println(i);
		}
		pw.println("end");
		
		
		
		

		System.out.println("client signing off");

	}

}
