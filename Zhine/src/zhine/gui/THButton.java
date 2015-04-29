package zhine.gui;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import zhine.gfx.GameColor;
import zhine.gfx.Screen;

public class THButton extends THComponent {
	
	protected String m_title;
	
	protected boolean m_pressed;
	protected boolean m_hovered;
	
	protected ArrayList<THButtonListener> m_buttonListeners;
	protected BufferedImage[] m_sprites;
	
	public THButton() {
		
		m_pressed = false;
		m_hovered = false;
		m_title = "";
		
		setBounds(0, 0, 10, 10);
		
		addMouseListener(new THMouseListener() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(e.getX() > m_x && e.getX() < m_x + m_width &&
					e.getY() > m_y && e.getY() < m_y + m_height) {
					
					m_pressed = true;
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				m_pressed = false;
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			
			@Override
			public void mouseMoved(MouseEvent e) {
				
				if(e.getX() > m_x && e.getX() < m_x + m_width &&
					e.getY() > m_y && e.getY() < m_y + m_height) {
					
					m_hovered = true;
				} else {
					
					m_hovered = false;
				}
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
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		
		m_sprites = new BufferedImage[3];
		m_sprites[0] = convertSprite(THSpriteManager.button.getSprite(0, 0), THSpriteManager.button);
		m_sprites[1] = convertSprite(THSpriteManager.button.getSprite(0, 1), THSpriteManager.button);
		m_sprites[2] = convertSprite(THSpriteManager.button.getSprite(0, 2), THSpriteManager.button);
	}
	
	public void setTitle(String title) {
		
		m_title = title;
	}
	
	@Override
	public void paint(Screen screen) {
		
		if(m_pressed) {
			
			screen.drawImage(m_sprites[1], m_x, m_y, m_width, m_height);
		} else if(m_hovered) {
			
			screen.drawImage(m_sprites[2], m_x, m_y, m_width, m_height);
		} else {
			
			screen.drawImage(m_sprites[0], m_x, m_y, m_width, m_height);
		}
		
		Font font = new Font(Font.SERIF, Font.BOLD, 24);
		screen.setFont(font);
		screen.setColor(GameColor.LIGHT_GRAY);
		screen.drawCenteredString(m_title, m_x + (m_width / 2), m_y + (m_height / 2) - 3);
	}
	
	public void press() {
		
		m_pressed = true;
		m_hovered = true;
	}
	
	public void release() {
		
		m_pressed = false;
		m_hovered = false;
	}
	
	public boolean isPressed() {
		
		return m_pressed;
	}
	
	public boolean isHovered() {
		
		return m_hovered;
	}
	
	public boolean onPress() {
		
		boolean ans = m_pressed;
		m_pressed = false;
		
		return ans;
	}
}