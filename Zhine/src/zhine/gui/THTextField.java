package zhine.gui;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import zhine.gfx.FontManager;
import zhine.gfx.GameColor;
import zhine.gfx.Screen;

public class THTextField extends THComponent {
	
	private String m_content;
	private String m_title;
	private boolean m_selected;
	
	private BufferedImage m_sprite;
	
	public THTextField() {
		
		m_content = "";
		m_title = "";
		m_selected = false;
		
		setBounds(0, 0, 10, 10);
		
		addKeyListener(new THKeyListener() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(m_selected) {
					
					if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
						
						if(m_content.length() > 0) {
							
							String newContent = m_content.substring(0, m_content.length() - 1);
							m_content = newContent;
						}
					} else if(e.getKeyChar() != KeyEvent.CHAR_UNDEFINED) {
						
						m_content += e.getKeyChar();
					}
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		
		addMouseListener(new THMouseListener() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(e.getX() > m_x && e.getX() < m_x + m_width &&
					e.getY() > m_y && e.getY() < m_y + m_height) {
					
					m_selected = true;
					setSprite(true);
				} else {
					
					m_selected = false;
					setSprite(false);
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
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		
		setSprite(m_selected);
	}
	
	private void setSprite(boolean selected) {
		
		if(selected) {
			
			m_sprite = convertSprite(THSpriteManager.text_field.getSprite(0, 1), THSpriteManager.text_field);
		} else {
			
			m_sprite = convertSprite(THSpriteManager.text_field.getSprite(0, 0), THSpriteManager.text_field);
		}
	}
	
	@Override
	public void paint(Screen screen) {
		
		// TODO: lots on this.
		
		Font font = FontManager.font_small;
		
		screen.drawImage(m_sprite, m_x, m_y);
		
		screen.setFont(font);
		screen.setColor(GameColor.WHITE);
		if(m_content.length() > 0) {
			
			screen.drawString(m_content, m_x + 4, m_y + m_height - 7);	
		} else {
			
			screen.drawString(m_title, m_x + 4, m_y + m_height - 7);	
		}
	}
	
	public void reset() {
		
		m_content = "";
	}
	
	public void setTitle(String title) {
		
		m_title = title;
	}
	
	public String getContent() {
		
		return m_content;
	}
	
	public void select() {
		
		m_selected = true;
	}
	
	public void unselect() {
		
		m_selected = false;
	}
}