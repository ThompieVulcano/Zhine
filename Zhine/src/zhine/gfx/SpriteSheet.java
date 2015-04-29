package zhine.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import zhine.util.Console;
import zhine.util.LogType;

public class SpriteSheet {

	private String m_path;
	private BufferedImage m_image;
	
	private BufferedImage[] m_sprites;

	private int m_spriteWidth;
	private int m_spriteHeight;
	private int m_spriteAmountX;
	private int m_spriteAmountY;
	private int m_width;
	private int m_height;

	public SpriteSheet(String path, int spriteWidth, int spriteHeight) {
		
		m_path = path;
		m_spriteWidth = spriteWidth;
		m_spriteHeight = spriteHeight;
		load();
	}

	private void load() {

		BufferedImage image = null;

		try {
			Console.log("Loading spritesheet at: \"res" + m_path + "\"");
			image = ImageIO.read(SpriteSheet.class.getResourceAsStream(m_path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (image == null) {

			Console.log(LogType.WARNING, "Could not find file at path: \"" + m_path + "\"");
			return;
		}

		m_image = image;
		m_width = image.getWidth();
		m_height = image.getHeight();
		m_spriteAmountX = m_width / m_spriteWidth;
		m_spriteAmountY = m_height / m_spriteHeight;
		m_sprites = new BufferedImage[m_spriteAmountX * m_spriteAmountY];
		
		int counter = 0;
		
		for(int xc = 0; xc < m_spriteAmountX; xc ++) {
			
			for(int yc = 0; yc < m_spriteAmountY; yc ++) {
				
				m_sprites[(yc * m_spriteAmountX) + xc] = m_image.getSubimage(xc * m_spriteWidth, yc * m_spriteHeight, m_spriteWidth, m_spriteHeight);
				counter += 1;
			}
		}
		
		Console.log("Finished loading the spritesheet with " + counter + " sprites.");
	}

	public BufferedImage getFullImage() {
		
		return m_image;
	}

	public BufferedImage getSprite(int xi, int yi) {

		return m_sprites[(yi * m_spriteAmountX) + xi];
	}

	public String getPath() {

		return m_path;
	}

	public int getWidth() {

		return m_width;
	}

	public int getHeight() {

		return m_height;
	}
	
	public int getSpriteWidth() {

		return m_spriteWidth;
	}

	public int getSpriteHeight() {

		return m_spriteHeight;
	}
}