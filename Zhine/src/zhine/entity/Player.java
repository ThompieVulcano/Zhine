package zhine.entity;

import zhine.gfx.Screen;
import zhine.input.Input;

public class Player extends Mob {

	protected Input input;
	
	public Player(int x, int y, int width, int height, Input input) {
		super(x, y, width, height);
		
		this.input = input;
	}

	@Override
	public void tick() {
		
		if(input.KEY_UP.isPressed()) {
			move(0, -1);
		}
		if(input.KEY_RIGHT.isPressed()) {
			move(1, 0);
		}
		if(input.KEY_DOWN.isPressed()) {
			move(0, 1);
		}
		if(input.KEY_LEFT.isPressed()) {
			move(-1, 0);
		}
	}

	@Override
	public void render(Screen screen) {
	}
}