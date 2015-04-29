package zhine.gui;

import java.awt.event.MouseEvent;

import zhine.gfx.Screen;

public class THScrollBar extends THComponent {
	
	protected ScrollBarKnob m_knob;
	
	protected int m_yMin;
	protected int m_yMax;
	
	public THScrollBar() {
		super();
		
		m_knob = new ScrollBarKnob(this);
	}
	
	@Override
	public void setBounds(int x, int y, int width, int height) {
		
		m_x = x;
		m_y = y;
		m_height = height;
		
		m_width = 20;
		m_yMin = m_y + 10;
		m_yMax = m_y + m_height - 10;
		m_knob.setBounds(m_x, m_yMin);
	}

	@Override
	public void paint(Screen screen) {
		
		screen.drawImage(THSpriteManager.scrollbar.getSprite(0, 0), m_x, m_y);
		for(int c = m_y + 20; c <= m_y + m_height - 40; c++) {
			
			screen.drawImage(THSpriteManager.scrollbar.getSprite(0, 1), m_x, c);
		}
		screen.drawImage(THSpriteManager.scrollbar.getSprite(0, 2), m_x, m_y + m_height - 20);
		
		m_knob.render(screen);
	}
	
	public double getValue() {
		
		return m_knob.getValue();
	}
	
	public class ScrollBarKnob {
		
		private int m_knobX;
		private int m_knobY;
		private int m_knobWidth;
		private int m_knobHeight;
		
		private boolean m_pressed;
		
		public ScrollBarKnob(THScrollBar bar) {
			
			setBounds(0, 0);
			
			init(bar);
		}
		
		public void setBounds(int x, int y) {
			
			m_knobX = x - 5;
			m_knobY = y - 15;
			m_knobWidth = 30;
			m_knobHeight = 30;
		}
		
		public void render(Screen screen) {
			
			screen.drawImage(THSpriteManager.knob.getFullImage(), m_knobX, m_knobY);
		}
		
		public double getValue() {
			
			double kry = m_knobY - m_yMin + (m_knobHeight / 2);
			double th = m_yMax - m_yMin;
			
			return kry / th * 100;
		}
		
		private void init(THScrollBar bar) {
			
			bar.addMouseListener(new THMouseListener() {

				@Override
				public void mousePressed(MouseEvent e) {
					
					if((e.getX() > m_knobX && e.getX() < m_knobX + m_knobWidth) || (e.getX() > m_x && e.getX() < m_x + m_width)) {
						
						if((e.getY() > m_knobY && e.getY() < m_knobY + m_knobHeight) || (e.getY() > m_y && e.getY() < m_y + m_height)) {
							
							m_pressed = true;
						}
					}
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					
					m_pressed = false;
				}

				@Override
				public void mouseClicked(MouseEvent e) {
				}

				@Override
				public void mouseMoved(MouseEvent e) {
				}

				@Override
				public void mouseDragged(MouseEvent e) {
					
					if(m_pressed) {
						
						m_knobY = e.getY() - (m_knobHeight / 2);
						
						if(m_knobY + (m_knobHeight / 2) < m_yMin) {
							
							m_knobY = m_yMin - (m_knobHeight / 2);
						} else if(m_knobY + (m_knobHeight / 2) > m_yMax) {
							
							m_knobY = m_yMax - (m_knobHeight / 2);
						}
					}
				}

				@Override
				public void mouseWheelMoved(MouseEvent e) {
				}

				@Override
				public void mouseEntered(MouseEvent e) {
				}

				@Override
				public void mouseExited(MouseEvent e) {
				}
			});
		}
	}
}