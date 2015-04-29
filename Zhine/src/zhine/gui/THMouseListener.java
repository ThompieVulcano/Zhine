package zhine.gui;

import java.awt.event.MouseEvent;

public interface THMouseListener {
	
	public void mousePressed(MouseEvent e);
	
	public void mouseReleased(MouseEvent e);
	
	public void mouseClicked(MouseEvent e);
	
	public void mouseMoved(MouseEvent e);
	
	public void mouseDragged(MouseEvent e);
	
	public void mouseWheelMoved(MouseEvent e);
	
	public void mouseEntered(MouseEvent e);
	
	public void mouseExited(MouseEvent e);
}