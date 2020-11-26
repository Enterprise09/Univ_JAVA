import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AnimatioTest extends JFrame implements Runnable{

	JLabel lbl;
	
	public AnimatioTest() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		ImageIcon icon = new ImageIcon("img/ship1.jpg");
		lbl = new JLabel(icon);
		lbl.setLocation(0, 300);
		lbl.setSize(102, 55);

		add(lbl);
		setTitle("움직이는 배");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Thread t = new Thread(this);
		t.start();
		
		setBounds(1000, 200, 700, 500);
		setVisible(true);
	}
	
	int x = 0;
	ImageIcon icon = null;
	int ship = 1;	//1 : 정방향  		2 : 역방향
	@Override
	public void run() {		
		try {
			while (true) {
				Thread.sleep(100);
				
				if(x == 590) {
					icon = new ImageIcon("img/ship2.jpg");
					ship = 2;
				}				
				if(x == 0) {
					ship = 1;
					icon = new ImageIcon("img/ship1.jpg");
				}

				if(ship == 1) {
					x += 10;
				}
				else if(ship ==2) {
					x -= 10;
				}
				lbl.setIcon(icon);
				lbl.setLocation(x, 300);
				repaint();
			}
		} catch (InterruptedException e) {
			
		}
	}
	
	/*@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage("img/wave.jpg");
		g.drawImage(img, 0, 0, 700, 500, this);
	}*/
	
	public static void main(String[] args) {
		new AnimatioTest();
	}



	

}
