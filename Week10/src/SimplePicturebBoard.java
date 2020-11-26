import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JFrame;


	
	public class SimplePicturebBoard extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
		
		JMenuItem mRed = new JMenuItem("����");
		JMenuItem mBlue = new JMenuItem("�Ķ�");
		JMenuItem mYellow = new JMenuItem("���");
		JMenuItem mGreen = new JMenuItem("�ʷ�");
		JMenuItem mBlack = new JMenuItem("����");
		
		JMenuItem mRect = new JMenuItem("���簢��");
		JMenuItem mOval = new JMenuItem("�� �Ǵ� Ÿ��");
		JMenuItem mLine = new JMenuItem("���׸���");
		
		JMenuItem mFill = new JMenuItem("��ä���� �׸���");
		JMenuItem mNoneFill = new JMenuItem("ä���� �ʰ� �׸���");
		
		int shape = 0;	//1 : ���簢��, 2 : ��, 3 : ��
		public static final int RECT = 1;
		public static final int OVAL = 2;
		public static final int LINE = 3;
		
		int fill = 0; //1 : ���� ä���� �׸���, 2 : ������ �׸���
		public static final int FILL = 1;
		public static final int NONEFILL = 0;
				
		
		Color color = Color.BLACK;
		
		int startX, startY, endX, endY;
		
		public SimplePicturebBoard() {
			// TODO Auto-generated constructor stub
			setTitle("���� �׸���");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			JMenuBar bar = new JMenuBar();
			JMenu menuColor = new JMenu("����");
			JMenu menuPoly = new JMenu("��������");
			JMenu menuFill = new JMenu("��ä���");
			
			menuColor.add(mRed);
			menuColor.add(mBlue);
			menuColor.add(mYellow);
			menuColor.add(mGreen);
			menuColor.add(mBlack);		
			
			menuPoly.add(mRect);
			menuPoly.add(mOval);
			menuPoly.add(mLine);
			
			menuFill.add(mFill);
			menuFill.add(mNoneFill);
			
			bar.add(menuColor);
			bar.add(menuPoly);
			bar.add(menuFill);
			setJMenuBar(bar);
			
			mRect.addActionListener(this);
			mOval.addActionListener(this);
			mLine.addActionListener(this);
			
			mRed.addActionListener(this);
			mBlue.addActionListener(this);
			mYellow.addActionListener(this);
			mGreen.addActionListener(this);
			mBlack.addActionListener(this);
			
			mFill.addActionListener(this);
			mNoneFill.addActionListener(this);
			
			Mycanvus canvas = new Mycanvus();
			add(canvas, "Center");
			canvas.addMouseListener(this);
			canvas.addMouseMotionListener(this);
			
			setBounds(1000, 200, 600, 500);
			setVisible(true);
			
		}
		
		class Mycanvus extends JPanel{
			@Override
			public void paint(Graphics g) {
				// TODO Auto-generated method stub
				super.paint(g);
				g.setColor(color);
				switch (shape) {
					case RECT: 
						switch (fill) {
						case FILL:
							g.fillRect(startX, startY, endX - startX, endY - startY);
							break;
						case NONEFILL:
							g.drawRect(startX, startY, endX - startX, endY - startY);
							break;							
						}
						break;				
					case OVAL:
						g.drawOval(startX, startY, endX - startX, endY - startY);
						switch (fill) {
						case FILL:
							g.fillOval(startX, startY, endX - startX, endY - startY);
							break;
						case NONEFILL:
							g.drawOval(startX, startY, endX - startX, endY - startY);
							break;
						}
						break;
					case LINE:
						g.drawLine(startX, startY, endX, endY);					
						break;
				}
				
			}
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object eMenu = e.getSource();
			if(eMenu == mRect) {
				shape = RECT;
			}
			else if(eMenu == mOval) {
				shape = OVAL;
			}
			else if(eMenu == mLine) {
				shape = LINE;
			}
			else if(eMenu == mRed) {
				color = Color.RED;
			}
			else if(eMenu == mBlue) {
				color = Color.BLUE;
			}
			else if(eMenu == mYellow) {
				color = Color.YELLOW;
			}
			else if(eMenu == mGreen) {
				color = Color.GREEN;
			}
			else if(eMenu == mBlack) {
				color = Color.BLACK;
			}
			else if(eMenu == mFill) {
				fill = FILL;
			}
			else if(eMenu == mNoneFill) {
				fill = 	NONEFILL;
			}
			
			repaint();	

		}
		@Override
		public void mouseClicked(MouseEvent e) {		
		}

		@Override
		public void mousePressed(MouseEvent e) {	
			startX = e.getX();
			startY = e.getY();
		}

		@Override
		public void mouseReleased(MouseEvent e) {		
		}

		@Override
		public void mouseEntered(MouseEvent e) {		
		}

		@Override
		public void mouseExited(MouseEvent e) {		
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			endX = e.getX();
			endY = e.getY();
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {		
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			new SimplePicturebBoard();
		}


	}



