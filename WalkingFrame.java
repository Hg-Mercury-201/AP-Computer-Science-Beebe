import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class WalkingFrame extends JFrame implements ActionListener
{


	private Man man;
	private BallThrow ball;
	private ArrayList<BallThrow> balls = new ArrayList<BallThrow>();
		public WalkingFrame()
		{
			setBounds(100,100,600,400);
			man = new Man(0,0);
			
			setLayout(null);
			add(man);
			
			Timer timer = new Timer(10,this);
			timer.start();
			addKeyListener(new KeyListener()
					{

						@Override
						public void keyPressed(KeyEvent e)
						{
							if(e.getKeyCode() == e.VK_W)
							{
								man.setDY(-2);							
							}
							if(e.getKeyCode() == e.VK_S)
							{
								man.setDY(2);							
							}
							if(e.getKeyCode() == e.VK_A)
							{
								man.setDX(-2);							
							}
							if(e.getKeyCode() == e.VK_D)
							{
								man.setDX(2);							
							}
							if(e.getKeyCode() == e.VK_SPACE)
							{
								ball = new BallThrow(man.getX(),man.getY());
								balls.add(ball);
								add(ball);
								ball.setDX(3);
							}
							
						}

						@Override
						public void keyReleased(KeyEvent e) 
						{
							if(e.getKeyCode() == e.VK_W)
							{
								man.setDY(0);							
							}
							if(e.getKeyCode() == e.VK_S)
							{
								man.setDY(0);							
							}
							if(e.getKeyCode() == e.VK_A)
							{
								man.setDX(0);							
							}
							if(e.getKeyCode() == e.VK_D)
							{
								man.setDX(0);							
							}
						}

						@Override
						public void keyTyped(KeyEvent e) 
						{
							
						}
				
					});
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		
		public static void  main(String[] args) 
		{
		new WalkingFrame();	
		}
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			man.update();
			repaint();
			if(ball != null)
			{
				for(BallThrow onScreen: balls)
					onScreen.update();

				for(int i = 0; i < balls.size(); i++)
					if(balls.get(i).getX() > getWidth()|| balls.get(i).getY() > getHeight())	
						
						{
						remove(balls.get(i));	
						balls.remove(i);
						}
				repaint();
			}

		}
}
