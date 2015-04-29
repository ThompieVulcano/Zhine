package zhine.gui;

import zhine.gfx.Screen;

public class THHud extends THComponent {
	
	@Override
	public void paint(Screen screen) {
		
		screen.drawImage(THSpriteManager.hud.getFullImage(), 0, 0);
	}
}