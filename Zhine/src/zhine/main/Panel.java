package zhine.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import zhine.gfx.Window;
import zhine.util.Console;

public class Panel implements Runnable {

	public static final String NAME = "Zhine";
	public static final String VERSION = "0.01";
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;

	private Thread m_thread;
	private boolean m_running;

	public Window m_window;

	public Panel() {
		
		m_window = new Window();
		m_window.init();
	}

	private void init() {

		Console.log("Initializing game...");
	}

	private void tick() {
	}

	private void render() {

		BufferStrategy bs = m_window.getBufferStrategy();

		while (bs == null) {

			m_window.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, m_window.getWidth(), m_window.getHeight());
		
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