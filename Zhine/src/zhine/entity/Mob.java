package zhine.entity;

public abstract class Mob extends Entity {
	
	protected int width;
	protected int height;
	
	public Mob(int x, int y, int width, int height) {
		super(x, y);
		
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		
		return width;
	}
	
	public int getHeight() {
		
		return height;
	}
}