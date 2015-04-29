package zhine.gfx;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

import zhine.gui.THComponent;
import zhine.main.Panel;
import zhine.util.Console;
import zhine.util.LogType;

public class Window extends Canvas {
	
	private static final long serialVersionUID = 2021070710923315034L;
	
	private JFrame m_frame;
	private SpriteSheet m_cursorSpriteSheet;
	
	private ArrayList<THComponent> m_components;
	
	public Window() {
		
		m_components = new ArrayList<THComponent>();
	}
	
	public void init() {
		
		m_frame = new JFrame(Panel.NAME);
		
		setMaximumSize(new Dimension(Panel.WIDTH, Panel.HEIGHT));
		setMinimumSize(new Dimension(Panel.WIDTH, Panel.HEIGHT));
		setPreferredSize(new Dimension(Panel.WIDTH, Panel.HEIGHT));
		
		m_cursorSpriteSheet = new SpriteSheet("/textures/guis/cursor.png", 64, 64);
		
		try {
			setCursor(Toolkit.getDefaultToolkit().createCustomCursor(m_cursorSpriteSheet.getFullImage(), new Point(0, 0), "custom cursor"));
		} catch (Exception e) {
			Console.log(LogType.WARNING, "Could not set custom cursor!");
		}
		
//		m_frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		m_frame.setUndecorated(true);
		m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m_frame.setLayout(new BorderLayout());
		m_frame.add(this, BorderLayout.CENTER);
		m_frame.pack();

		m_frame.setResizable(true);
		m_frame.setLocationRelativeTo(null);
		m_frame.setVisible(true);
	}
	
	public JFrame getFrame() {
		
		return m_frame;
	}
	
	public void add(THComponent component) {
		
		m_components.add(component);
	}
	
	public void remove(THComponent component) {
		
		m_components.remove(component);
	}
	
	public void render(Screen screen) {
		
		for(THComponent component : m_components) {
			
			component.paint(screen);
		}
	}
	
	public void keyPressed(KeyEvent e) {
		
		for(THComponent component : m_components) {
			
			component.keyPressed(e);
		}
	}
	
	public void keyReleased(KeyEvent e) {
		
		for(THComponent component : m_components) {
			
			component.keyReleased(e);
		}
	}
	
	public void keyTyped(KeyEvent e) {
		
		for(THComponent component : m_components) {
			
			component.keyTyped(e);
		}
	}
	
	public void mousePressed(MouseEvent e) {
		
		for(THComponent component : m_components) {
			
			component.mousePressed(e);
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
		for(THComponent component : m_components) {
			
			component.mouseReleased(e);
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		
		for(THComponent component : m_components) {
			
			component.mouseClicked(e);
		}
	}
	
	public void mouseMoved(MouseEvent e) {
		
		for(THComponent component : m_components) {
			
			component.mouseMoved(e);
		}
	}
	
	public void mouseDragged(MouseEvent e) {
		
		for(THComponent component : m_components) {
			
			component.mouseDragged(e);
		}
	}
	
	public void mouseWheelMoved(MouseEvent e) {
		
		for(THComponent component : m_components) {
			
			component.mouseWheelMoved(e);
		}
	}
	
	public void mouseEntered(MouseEvent e) {
		
		for(THComponent component : m_components) {
			
			component.mouseEntered(e);
		}
	}
	
	public void mouseExited(MouseEvent e) {
		
		for(THComponent component : m_components) {
			
			component.mouseExited(e);
		}
	}
}