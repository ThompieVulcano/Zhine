package zhine.gfx;

import java.awt.Color;

public enum GameColor {
	
	WHITE(255, 255, 255),
	LIGHT_GRAY(219, 219, 219),
	GRAY(168, 168, 168),
	DARK_GRAY(68, 68, 68),
	BLACK(0, 0, 0),
	;
	
	private final Color m_color;
	
	GameColor(int r, int b, int g) {
		
		m_color = new Color(r, g, b);
	}
	
	public Color getColor() {
		
		return m_color;
	}
}