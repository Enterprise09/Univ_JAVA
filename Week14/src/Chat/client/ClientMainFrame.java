package Chat.client;

import javax.swing.JFrame;

public class ClientMainFrame extends JFrame {

	
	
	public ClientMainFrame() {
		setTitle("Client Chatting Frame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		ClientGUI client = new ClientGUI("127.0.0.1", 7777);
		client.giveAndTake();
		add(client, "Center");
		
		setBounds(1000, 200, 400, 300);
		setVisible(true);
		
		
				
	}
	
	public static void main(String[] args) {
		new ClientMainFrame();

	}

}
