package zhine.gfx;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class Screen {

	private Graphics m_graphics;

	private int m_xOffset;
	private int m_yOffset;
	private int m_width;
	private int m_height;

	public Screen(int width, int height) {

		m_xOffset = 0;
		m_yOffset = 0;
		m_width = width;
		m_height = height;
	}

	private boolean onScreen(int x, int y) {

		if (x > m_xOffset && x < m_xOffset + m_width) {

			if (y > m_yOffset && y < m_yOffset + m_height) {

				return true;
			}
		}

		return false;
	}

	private boolean onScreen(int x, int y, int width, int height) {

		int centerX = x + (width / 2);
		int centerY = y + (height / 2);

		if (onScreen(x, y) || onScreen(x + width, y) || onScreen(x, y + height)
				|| onScreen(x + width, y + height)
				|| onScreen(centerX, centerY)) {

			return true;
		} else {

			return false;
		}
	}

	public void setColor(GameColor color) {

		m_graphics.setColor(color.getColor());
	}

	public void refresh(Graphics graphics) {

		m_graphics = graphics;
	}

	public void dispose() {

		m_graphics.dispose();
	}

	public void setColor(Color color) {

		m_graphics.setColor(color);
	}

	public void setFont(Font font) {

		m_graphics.setFont(font);
	}

	public void drawImage(BufferedImage image, int x, int y) {

		if (onScreen(x, y, image.getWidth(), image.getHeight())) {

			m_graphics.drawImage(image, x - m_xOffset, y - m_yOffset, null);
		}
	}

	public void drawImage(BufferedImage image, int x, int y, int width,
			int height) {

		if (onScreen(x, y, image.getWidth(), image.getHeight())) {

			m_graphics.drawImage(image, x - m_xOffset, y - m_yOffset, width,
					height, null);
		}
	}

	public void setBackground(GameColor color) {

		setColor(color);
		m_graphics.fillRect(0, 0, m_width, m_height);
	}

	public void drawString(String string, int x, int y) {

		Graphics2D g2d = (Graphics2D) m_graphics;
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);

		m_graphics.drawString(string, x, y);
	}

	public void drawCenteredString(String s, int x, int y) {
		
		Graphics2D g2d = (Graphics2D) m_graphics;
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
		
		FontMetrics fm = m_graphics.getFontMetrics();
		
		int nx = (x - (fm.stringWidth(s)) / 2);
		int ny = fm.getAscent() + y - ((fm.getAscent() + fm.getDescent()) / 2);
		
		m_graphics.drawString(s, nx, ny);
	}

	public void drawRect(int x, int y, int width, int height) {

		m_graphics.drawRect(x, y, width, height);
	}

	public void fillRect(int x, int y, int width, int height) {

		m_graphics.fillRect(x, y, width, height);
	}

	public void drawOval(int x, int y, int width, int height) {

		m_graphics.drawOval(x, y, width, height);
	}

	public void fillOval(int x, int y, int width, int height) {

		m_graphics.fillOval(x, y, width, height);
	}

	public void addOffset(int xa, int ya) {

		m_xOffset += xa;
		m_yOffset += ya;
	}

	public void setOffset(int xa, int ya) {

		setXOffset(xa);
		setYOffset(ya);
	}

	public void setXOffset(int xa) {

		m_xOffset = xa;
	}

	public void setYOffset(int ya) {

		m_yOffset = ya;
	}

	public int getXOffset() {

		return m_xOffset;
	}

	public int getYOffset() {

		return m_yOffset;
	}

	public int getWidth() {

		return m_width;
	}

	public int getHeight() {

		return m_height;
	}

	public Graphics getGraphics() {

		return m_graphics;
	}
}