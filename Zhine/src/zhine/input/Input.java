package zhine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import zhine.gfx.Camera;
import zhine.gfx.Screen;
import zhine.gfx.Window;

public class Input implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

	public Key KEY_UP = new Key();
	public Key KEY_LEFT = new Key();
	public Key KEY_RIGHT = new Key();
	public Key KEY_DOWN = new Key();

	public Key KEY_SHIFT = new Key();
	
	public Key KEY_ESC = new Key();
	
	public Key KEY_F1 = new Key();
	
	public Mouse MOUSE;
	
	private Window m_window;

	public Input(Window window) {

		m_window = window;
		window.addKeyListener(this);
		window.addMouseListener(this);
		window.addMouseMotionListener(this);
		window.addMouseWheelListener(this);
	}
	
	public void initMouse(Camera camera, Screen screen) {
		
		MOUSE = new Mouse(0, 0, camera, screen);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		m_window.keyPressed(e);

		if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
			KEY_UP.toggle(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
			KEY_LEFT.toggle(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
			KEY_DOWN.toggle(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
			KEY_RIGHT.toggle(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
			KEY_SHIFT.toggle(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			KEY_ESC.toggle(true);
		}
		if(e.getKeyCode() == KeyEvent.VK_F1) {
			KEY_F1.toggle(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		m_window.keyReleased(e);

		if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
			KEY_UP.toggle(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_A
				|| e.getKeyCode() == KeyEvent.VK_LEFT) {
			KEY_LEFT.toggle(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_S
				|| e.getKeyCode() == KeyEvent.VK_DOWN) {
			KEY_DOWN.toggle(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_D
				|| e.getKeyCode() == KeyEvent.VK_RIGHT) {
			KEY_RIGHT.toggle(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
			KEY_SHIFT.toggle(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			KEY_ESC.toggle(false);
		}
		if(e.getKeyCode() == KeyEvent.VK_F1) {
			KEY_F1.toggle(false);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		m_window.keyTyped(e);
	}

	public class Key {

		private boolean m_pressed;
		private boolean m_onPress;

		public Key() {

			m_pressed = false;
			m_onPress = false;
		}

		public void toggle(boolean pressed) {

			if (pressed && !m_pressed) {

				m_onPress = true;
			}

			m_pressed = pressed;
		}

		public boolean isPressed() {

			return m_pressed;
		}

		public boolean onPress() {

			boolean onPress = m_onPress;
			m_onPress = false;
			return onPress;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		m_window.mousePressed(e);

		if (e.getButton() == MouseEvent.BUTTON1) {
			MOUSE.toggleLeftButton(true);
		}
		if (e.getButton() == MouseEvent.BUTTON2) {
			MOUSE.toggleMouseWheelButton(true);
		}
		if (e.getButton() == MouseEvent.BUTTON3) {
			MOUSE.toggleRightButton(true);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		m_window.mouseReleased(e);
		
		if (e.getButton() == MouseEvent.BUTTON1) {
			MOUSE.toggleLeftButton(false);
		}
		if (e.getButton() == MouseEvent.BUTTON2) {
			MOUSE.toggleMouseWheelButton(false);
		}
		if (e.getButton() == MouseEvent.BUTTON3) {
			MOUSE.toggleRightButton(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		m_window.mouseClicked(e);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		
		m_window.mouseWheelMoved(e);
		
		if(e.getWheelRotation() > 0) {
			
			MOUSE.m_camera.zoomOut(e.getWheelRotation() * 0.08);
		} else {
			
			MOUSE.m_camera.zoomIn(e.getWheelRotation() * -0.08);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		m_window.mouseDragged(e);

		MOUSE.set(e.getX(), e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		m_window.mouseMoved(e);

		MOUSE.set(e.getX(), e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		m_window.mouseEntered(e);

		MOUSE.set(e.getX(), e.getY());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		m_window.mouseExited(e);
	}

	public class Mouse {

		private int m_x, m_y;
		private boolean m_left, m_right, m_wheel;
		
		private Screen m_screen;
		public Camera m_camera;

		public Mouse(int x, int y, Camera camera, Screen screen) {

			m_x = x;
			m_y = y;
			m_left = false;
			m_right = false;
			m_wheel = false;
			
			m_screen = screen;
			m_camera = camera;
		}

		public void set(int x, int y) {

			m_x = x;
			m_y = y;
		}
		
		public void setX(int x) {
			
			m_x = x;
		}
		
		public void setY(int y) {
			
			m_y = y;
		}

		public void toggleLeftButton(boolean pressed) {
			
			m_left = pressed;
		}

		public void toggleRightButton(boolean pressed) {
			
			m_right = pressed;
		}

		public void toggleMouseWheelButton(boolean pressed) {
			
			m_wheel = pressed;
		}
		
		public boolean isInBox(int x, int y, int width, int height) {
			
			if(m_x >= x && m_x <= x + width) {
				
				if(m_y >= y && m_y <= y + height) {
					
					return true;
				}
			}
			
			return false;
		}

		public boolean leftIsPressed() {

			return m_left;
		}

		public boolean rightIsPressed() {

			return m_right;
		}

		public boolean mouseWheelIsPressed() {

			return m_wheel;
		}

		public int getX() {

			return m_x;
		}

		public int getY() {

			return m_y;
		}
		
		public int getMappedX() {

			return m_x + m_screen.getXOffset();
		}

		public int getMappedY() {

			return m_y + m_screen.getYOffset();
		}
	}
}