import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class BallThrow extends JComponent implements ActionListener
{
	private int dx = 0, dy = 0;
	
	public BallThrow(int x,int y)
	{
		setLocation(x,y);
		setSize(20,20);
	}

	public void paintComponent(Graphics g)
	{
		Graphics g3 = (Graphics2D) g;
		Ellipse2D.Double ball = new Ellipse2D.Double(4,0,10,10);
		((Graphics2D) g3).fill(ball);
		
	}
	public void setDY(int y)
	{
		dy = y;
	}
	public void setDX(int x)
	{
		dx = x;
	}
	public void update()
	{
		setLocation(getX() + dx, getY() +  dy);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}

}
