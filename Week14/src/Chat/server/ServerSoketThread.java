package Chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ServerSoketThread extends Thread {
	ChatServer cs;
	Socket s;
	String threadName = "thread";
	PrintWriter pw;
	BufferedReader br;
	String name;
	
	public ServerSoketThread(ChatServer cs, Socket s) {
		this.cs = cs;
		this.s = s;
		threadName = getName();
		System.out.println(s.getInetAddress() + "���� �����߽��ϴ�.");
		System.out.println("Thread Name : " + threadName);
		
	}
	
	public void sendMessage(String str) {
		pw.println(str); 
	}
	
	@Override
	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream(), true);
			sendMessage("��ȭ���� �Է��ϼ���.");
			name = br.readLine();
			cs.broadCastring("[" + name + "]�� ����");
			
			while(true) {
				String in = br.readLine();
				cs.broadCastring("[" + name + "]�� : " + in);
			}
			
			
		} catch (IOException e) {
			System.out.println(threadName + "�� ����");
			cs.removeClient(this);
			
		}finally {
			try {
				s.close();
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		
		
	}
	
	
}
