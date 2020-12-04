package Chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
	ServerSocket ss;	//서버의 소켓
	Socket s;		//클라이언트의 소켓을 받아와서 저장
	ArrayList<Thread> aList;
	
	public ChatServer() {
		aList = new ArrayList<Thread>();
		System.out.println("채팅 서버 시작");
	}
	
	public void giveAndTake() {
		try {
			ss = new ServerSocket(7777);
			ss.setReuseAddress(true);	//IP주소등을 재사용가능
			while(true) { 
				s = ss.accept();	//클라이언트가 연결을 요청하게 되면 클라이언트를 받아서 s에저장한다.
				ServerSoketThread sst = new ServerSoketThread(this, s);
				addClient(sst);
				sst.start();
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		
		
	}
	
	public synchronized void addClient(Thread t) {
		aList.add(t);
		System.out.println("클라이언트 1명 입장, 총" + aList.size());
	}
	
	public synchronized void removeClient(Thread t) {
		aList.remove(t);
		System.out.println("클라이언트 1명 퇴장, 총 "+ aList.size() + "명");
	}
	
	public synchronized void broadCastring(String str) {
		for(int i= 0; i < aList.size(); i++) {
			ServerSoketThread sst = (ServerSoketThread)aList.get(i);
			sst.sendMessage(str);
		}
	}
	
	
	
	
}
