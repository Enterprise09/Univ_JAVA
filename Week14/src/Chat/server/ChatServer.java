package Chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
	ServerSocket ss;	//������ ����
	Socket s;		//Ŭ���̾�Ʈ�� ������ �޾ƿͼ� ����
	ArrayList<Thread> aList;
	
	public ChatServer() {
		aList = new ArrayList<Thread>();
		System.out.println("ä�� ���� ����");
	}
	
	public void giveAndTake() {
		try {
			ss = new ServerSocket(7777);
			ss.setReuseAddress(true);	//IP�ּҵ��� ���밡��
			while(true) { 
				s = ss.accept();	//Ŭ���̾�Ʈ�� ������ ��û�ϰ� �Ǹ� Ŭ���̾�Ʈ�� �޾Ƽ� s�������Ѵ�.
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
		System.out.println("Ŭ���̾�Ʈ 1�� ����, ��" + aList.size());
	}
	
	public synchronized void removeClient(Thread t) {
		aList.remove(t);
		System.out.println("Ŭ���̾�Ʈ 1�� ����, �� "+ aList.size() + "��");
	}
	
	public synchronized void broadCastring(String str) {
		for(int i= 0; i < aList.size(); i++) {
			ServerSoketThread sst = (ServerSoketThread)aList.get(i);
			sst.sendMessage(str);
		}
	}
	
	
	
	
}
