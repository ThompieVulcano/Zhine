package zhine.gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.VolatileImage;

import zhine.input.Input;
import zhine.main.Panel;

public class Camera {

	private Input m_input;
	private double m_zoom;

	public Camera(Input input) {

		m_input = input;
		m_zoom = 1;
	}

	public void tick() {
		
		if (m_input.KEY_ESC.isPressed()) {

			System.exit(1);
		}
	}

	public void render(VolatileImage image, Graphics g, int windowWidth, int windowHeight) {
		
		double scaleX, scaleY;
		scaleX = (double) (windowWidth) / (double) (Panel.WIDTH);
		scaleY = (double) (windowHeight) / (double) (Panel.HEIGHT);
		int x, y, width, height;
		width = (int) (image.getWidth() * m_zoom * scaleX);
		height = (int) (image.getHeight() * m_zoom * scaleY);
		x = (windowWidth - width) / 2;
		y = (windowHeight - height) / 2;
		g.drawImage(image, x, y, width, height, null);
	}

	public void render(BufferedImage image, Graphics g, int windowWidth, int windowHeight) {
		
		double scaleX, scaleY;
		scaleX = (double) (windowWidth) / (double) (Panel.WIDTH);
		scaleY = (double) (windowHeight) / (double) (Panel.HEIGHT);
		int x, y, width, height;
		width = (int) (image.getWidth() * m_zoom * scaleX);
		height = (int) (image.getHeight() * m_zoom * scaleY);
		x = (image.getWidth() - width) / 2;
		y = (image.getHeight() - height) / 2;
		g.drawImage(image, x, y, width, height, null);
	}
	
	public void setZoom(double amt) {

		m_zoom = amt;
		
		if(m_zoom < 0) {
			
			m_zoom = 1;
		}
	}

	public void zoomIn(double amt) {

		m_zoom += amt;
		
		if(m_zoom < 0) {
			
			m_zoom -= amt;
		}
	}

	public void zoomOut(double amt) {

		m_zoom -= amt;
		
		if(m_zoom < 0) {
			
			m_zoom += amt;
		}
	}
	
	public double getZoom() {
		
		return m_zoom;
	}
}