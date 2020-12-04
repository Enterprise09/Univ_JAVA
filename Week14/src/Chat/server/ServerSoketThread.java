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
		System.out.println(s.getInetAddress() + "에서 접속했습니다.");
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
			sendMessage("대화명을 입력하세요.");
			name = br.readLine();
			cs.broadCastring("[" + name + "]님 입장");
			
			while(true) {
				String in = br.readLine();
				cs.broadCastring("[" + name + "]님 : " + in);
			}
			
			
		} catch (IOException e) {
			System.out.println(threadName + "님 퇴장");
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
