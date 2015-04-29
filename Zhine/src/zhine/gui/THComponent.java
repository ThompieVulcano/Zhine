package zhine.gui;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import zhine.gfx.Screen;
import zhine.gfx.SpriteSheet;

public abstract class THComponent {
	
	protected int m_x;
	protected int m_y;
	protected int m_width;
	protected int m_height;
	
	protected ArrayList<THComponent> m_componennts;
	
	protected ArrayList<THKeyListener> m_keyListeners;
	protected ArrayList<THMouseListener> m_mouseListeners;
	
	public THComponent() {
		
		m_x = 0;
		m_y = 0;
		m_width = 0;
		m_height = 0;
		
		m_componennts = new ArrayList<THComponent>();
		m_keyListeners = new ArrayList<THKeyListener>();
		m_mouseListeners = new ArrayList<THMouseListener>();
	}
	
	public abstract void paint(Screen screen);
	
	public void setBounds(int x, int y, int width, int height) {
		
		m_x = x;
		m_y = y;
		m_width = width;
		m_height = height;
	}
	
	protected BufferedImage convertSprite(BufferedImage image, SpriteSheet sheet) {
		
		BufferedImage sprite = new BufferedImage(m_width, m_height, 2);
		Graphics2D g = sprite.createGraphics();
		
		int spriteWidth = sheet.getSpriteWidth() - 4;
		int spriteHeight = sheet.getSpriteHeight() - 4;
		
		int innerWidth = m_width - 4;
		int innerHeight = m_height - 4;
		
		for(int x = 0; x < innerWidth; x += spriteWidth) {
			
			for(int y = 0; y < innerHeight; y += spriteHeight) {
				
				int subWidth = 0;
				int subHeight = 0;
				
				if(innerWidth - x < spriteWidth) {
					
					subWidth = innerWidth - x;
				} else {
					
					subWidth = spriteWidth;
				}
				
				if(innerHeight - y < spriteHeight) {
					
					subHeight = innerHeight - y;
				} else {
					
					subHeight = spriteHeight;
				}
				
				g.drawImage(image.getSubimage(2, 2, subWidth, subHeight), 2 + x, 2 + y, null);
				
				g.drawImage(image.getSubimage(2, 0, subWidth, 2), 2 + x, 0, null);
				g.drawImage(image.getSubimage(2, image.getHeight() - 2, subWidth, 2), 2 + x, innerHeight + 2, null);
				
				g.drawImage(image.getSubimage(0, 2, 2, subHeight), 0, 2 + y, null);
				g.drawImage(image.getSubimage(image.getWidth() - 2, 2, 2, subHeight), innerWidth + 2, 2 + y, null);
			}
		}
		
		g.drawImage(image.getSubimage(0, 0, 2, 2), 0, 0, null);
		g.drawImage(image.getSubimage(image.getWidth() - 2, 0, 2, 2), innerWidth + 2, 0, null);
		
		g.drawImage(image.getSubimage(0, image.getHeight() - 2, 2, 2), 0, innerHeight + 2, null);
		g.drawImage(image.getSubimage(image.getWidth() - 2, image.getHeight() - 2, 2, 2), innerWidth + 2, innerHeight + 2, null);
		
		g.dispose();
		return sprite;
	}
	
	public void add(THComponent component) {
		
		m_componennts.add(component);
	}
	
	public void remove(THComponent component) {
		
		m_componennts.remove(component);
	}
	
	public void addKeyListener(THKeyListener keyListener) {
		
		m_keyListeners.add(keyListener);
	}
	
	public void addMouseListener(THMouseListener mouseListener) {
		
		m_mouseListeners.add(mouseListener);
	}
	
	public ArrayList<THKeyListener> getKeyListeners() {
		
		return m_keyListeners;
	}
	
	public ArrayList<THMouseListener> getMouseListeners() {
		
		return m_mouseListeners;
	}
	
	public void keyPressed(KeyEvent e) {
		
		for(THKeyListener listener : m_keyListeners) {
			
			listener.keyPressed(e);
		}
	}
	
	public void keyReleased(KeyEvent e) {
		
		for(THKeyListener listener : m_keyListeners) {
			
			listener.keyReleased(e);
		}
	}
	
	public void keyTyped(KeyEvent e) {
		
		for(THKeyListener listener : m_keyListeners) {
			
			listener.keyTyped(e);
		}
	}
	
	public void mousePressed(MouseEvent e) {
		
		for(THMouseListener listener : m_mouseListeners) {
			
			listener.mousePressed(e);
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
		for(THMouseListener listener : m_mouseListeners) {
			
			listener.mouseReleased(e);
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		
		for(THMouseListener listener : m_mouseListeners) {
			
			listener.mouseClicked(e);
		}
	}
	
	public void mouseMoved(MouseEvent e) {
		
		for(THMouseListener listener : m_mouseListeners) {
			
			listener.mouseMoved(e);
		}
	}
	
	public void mouseDragged(MouseEvent e) {
		
		for(THMouseListener listener : m_mouseListeners) {
			
			listener.mouseDragged(e);
		}
	}
	
	public void mouseWheelMoved(MouseEvent e) {
		
		for(THMouseListener listener : m_mouseListeners) {
			
			listener.mouseWheelMoved(e);
		}
	}
	
	public void mouseEntered(MouseEvent e) {
		
		for(THMouseListener listener : m_mouseListeners) {
			
			listener.mouseEntered(e);
		}
	}
	
	public void mouseExited(MouseEvent e) {
		
		for(THMouseListener listener : m_mouseListeners) {
			
			listener.mouseExited(e);
		}
	}
}