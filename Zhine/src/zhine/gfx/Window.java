package zhine.gfx;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import zhine.main.Panel;

public class Window extends Canvas {
	
	private static final long serialVersionUID = 1L;
	
	private JFrame m_frame;
	
	public Window() {
	}
	
	public void init() {
		
		m_frame = new JFrame(Panel.NAME);
		
		setMaximumSize(new Dimension(Panel.WIDTH, Panel.HEIGHT));
		setMinimumSize(new Dimension(Panel.WIDTH, Panel.HEIGHT));
		setPreferredSize(new Dimension(Panel.WIDTH, Panel.HEIGHT));
		
//		m_frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		m_frame.setUndecorated(true);
		m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m_frame.setLayout(new BorderLayout());
		m_frame.add(this, BorderLayout.CENTER);
		m_frame.pack();

		m_frame.setResizable(true);
		m_frame.setLocationRelativeTo(null);
		m_frame.setVisible(true);
	}
	
	public JFrame getFrame() {
		
		return m_frame;
	}
}