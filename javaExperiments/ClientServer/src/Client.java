import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client {
	static JTextField b4;
	static JTextArea b5;
	static BufferedReader br;
	static PrintWriter pw;

	public static void main(String[] args) throws UnknownHostException,
			IOException {

		System.out.println("welcome to swing");

		JFrame f1 = new JFrame("Echo Server CONVERSATION");
		f1.setSize(400, 400);
		f1.setVisible(true);
		JPanel jp = new JPanel();
		jp.setSize(300, 300);

		Listen l = new Listen();
		JButton b3 = new JButton("SEND");
		b3.addActionListener(l);
		b4 = new JTextField(30);
		b4.addActionListener(l);
		b5 = new JTextArea(10, 10);
		b5.setEditable(false);
		jp.add(b4);
		jp.add(b3);
		f1.add(BorderLayout.CENTER, b5);
		f1.add(BorderLayout.SOUTH, jp);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Socket soc = new Socket("127.0.0.1", 45000);
		System.out.println("client signing in");
		InputStream is = soc.getInputStream();
		OutputStream os = soc.getOutputStream();

		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(os)),
				true);
		br = new BufferedReader(new InputStreamReader(is));

		
        while(true){
		String str = br.readLine();
		b5.append("\n"+str);
        }
		

	}

}

class Listen implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("button clicked");
		String text = Client.b4.getText();
        Client.pw.println(text);
		Client.b4.setText("");

	}
}
