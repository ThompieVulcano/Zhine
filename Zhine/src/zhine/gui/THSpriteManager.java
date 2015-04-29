package zhine.gui;

import zhine.gfx.SpriteSheet;

public class THSpriteManager {
	
	public static SpriteSheet hud = new SpriteSheet("/textures/guis/hud/hud.png", 1920, 1080);
	
	public static SpriteSheet knob = new SpriteSheet("/textures/guis/lib/knob.png", 30, 30);
	public static SpriteSheet button = new SpriteSheet("/textures/guis/lib/button.png", 148, 26);
	public static SpriteSheet scrollbar = new SpriteSheet("/textures/guis/lib/scrollbar.png", 20, 20);
	public static SpriteSheet check_box = new SpriteSheet("/textures/guis/lib/check_box.png", 128, 128);
	public static SpriteSheet text_field = new SpriteSheet("/textures/guis/lib/text_field.png", 140, 25);
	
	public static SpriteSheet tiles = new SpriteSheet("/textures/tiles/tile_sprites.png", 32, 32);
	public static SpriteSheet entities = new SpriteSheet("/textures/entities/entity_sprites.png", 32, 32);
	
	public static SpriteSheet main_menu = new SpriteSheet("/textures/guis/menus/mainmenu_background.png", 1920, 1080);
	public static SpriteSheet host_menu = new SpriteSheet("/textures/guis/menus/hostmenu_background.png", 1920, 1080);
}