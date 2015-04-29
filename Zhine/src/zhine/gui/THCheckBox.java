package zhine.gui;

import java.awt.event.MouseEvent;

import zhine.gfx.Screen;

public class THCheckBox extends THComponent {
	
	private boolean m_selected;
	
	public THCheckBox() {
		
		m_selected = false;
		
		setBounds(0, 0, 10, 10);
		
		addMouseListener(new THMouseListener() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(e.getX() > m_x && e.getX() < m_x + m_width &&
					e.getY() > m_y && e.getY() < m_y + m_height) {
					
					toggle();
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			
			@Override
			public void mouseMoved(MouseEvent e) {
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
			
			@Override
			public void mouseWheelMoved(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
	}
	
	@Override
	public void paint(Screen screen) {
		
		screen.drawImage(THSpriteManager.check_box.getSprite(0, 0), m_x, m_y, m_width, m_height);
		
		if(m_selected) {
			
			screen.drawImage(THSpriteManager.check_box.getSprite(0, 1), m_x, m_y, m_width, m_height);
		}
	}
	
	public void select() {
		
		m_selected = true;
	}
	
	public void unselect() {
		
		m_selected = false;
	}
	
	public void toggle() {
		
		m_selected = !m_selected;
	}
	
	public boolean isChecked() {
		
		return m_selected;
	}
}