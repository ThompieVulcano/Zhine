package zhine.entity;

import zhine.gfx.Screen;

public abstract class Entity {
	
	protected int x;
	protected int y;
	
	public Entity(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
	
	public abstract void tick();
	
	public abstract void render(Screen screen);
	
	public void move(int xa, int ya) {
		
		x += xa;
		y += ya;
	}
	
	public void teleport(int xc, int yc) {
		
		x = xc;
		y = yc;
	}
	
	public int getX() {
		
		return x;
	}
	
	public int getY() {
		
		return y;
	}
}