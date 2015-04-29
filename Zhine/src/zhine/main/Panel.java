package zhine.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.VolatileImage;

import zhine.gfx.Camera;
import zhine.gfx.GameColor;
import zhine.gfx.Screen;
import zhine.gfx.Window;
import zhine.util.Console;

public class Panel implements Runnable {

	public static final String NAME = "Zhine";
	public static final String VERSION = "0.01";
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public static boolean USE_GPU = true;

	private Thread m_thread;
	private boolean m_running;

	public Window m_window;
	public Screen m_screen;
	public Camera m_camera;

	public Panel() {
		
		m_window = new Window();
		m_window.init();
	}

	private void init() {

		Console.log("Initializing game...");
		
		m_screen = new Screen(WIDTH, HEIGHT);
		m_camera = new Camera();
	}

	private void tick() {
	}

	private void render() {

		BufferStrategy bs = m_window.getBufferStrategy();

		while (bs == null) {

			m_window.createBufferStrategy(3);
			return;
		}
		
		VolatileImage vBuffer = null;
		BufferedImage buffer = null;
		Graphics2D bgfx = null;

		if (vBuffer == null && USE_GPU) {
			
			vBuffer = m_window.createVolatileImage(WIDTH, HEIGHT);
			bgfx = vBuffer.createGraphics();
			bgfx.setBackground(Color.BLACK);
			bgfx.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
			m_screen.refresh(bgfx);
		} else if (buffer == null && !USE_GPU) {
			
			buffer = new BufferedImage(WIDTH, HEIGHT, 2);
			bgfx = buffer.createGraphics();
			bgfx.setBackground(Color.BLACK);
			bgfx.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
			m_screen.refresh(bgfx);
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, m_window.getWidth(), m_window.getHeight());
		
		m_screen.setBackground(GameColor.DARK_GRAY);
		Font font = new Font("Verdana", Font.PLAIN, 80);
		m_screen.setFont(font);
		m_screen.setColor(GameColor.WHITE);
		m_screen.drawCenteredString("Zhine", Panel.WIDTH / 2, 100);
		
		m_screen.dispose();
		if (USE_GPU) {
			m_camera.render(vBuffer, g, m_window.getWidth(), m_window.getHeight());
			vBuffer.flush();
		} else {
			m_camera.render(buffer, g, m_window.getWidth(), m_window.getHeight());
			buffer.flush();
		}
		Toolkit.getDefaultToolkit().sync();
		
		g.dispose();
		bs.show();
	}

	public synchronized void start() {

		m_running = true;
		m_thread = new Thread(this, Panel.NAME + "_main");
		m_thread.start();
	}

	public synchronized void stop() {

		m_running = false;
		try {
			m_thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		long lastTime = System.nanoTime();

		double nsPerTick = 1000000000D / 60D;

		double delta = 0;

		init();

		while (m_running) {

			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;

			boolean shouldRender = true;

			while (delta >= 1) {

				tick();
				delta--;
				shouldRender = true;
			}

			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (shouldRender) {

				render();
			}
		}
	}
	
	public Window getWindow() {
		
		return m_window;
	}
}