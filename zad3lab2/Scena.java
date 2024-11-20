package zad3lab2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Scena extends Canvas {
	protected ArrayList<Figura> figure;
	protected Igrac i;
	public Scena() {
		figure=new ArrayList<Figura>();
		setSize(400,500);
		for (int i=0;i<5;i++) {
			for (int j=0;j<4;j++) {
				new Cigla(this, i*(80) ,j*20, 79, 19, 200);
			}
		}
		i=new Igrac(this, 200, 480, 50, 10);
		setFocusable(true);
		requestFocusInWindow();
		
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_LEFT) {
					i.pomeri(-10, 0);
				}
				if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
					i.pomeri(10, 0);
				}
				repaint();
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				i.ispali(Color.GREEN);
			}
		});
	}
	public synchronized void addFigura(Figura f) {
		figure.add(f);
		
	}
	public Figura getFigura(int i) {
		if (i<0 || i>=figure.size()) {
			return null;
		}
		return figure.get(i);
	}
	public synchronized void removeFigura(Figura f) {
		figure.remove(f);
	}
	public synchronized void pokreni() {
		for (Figura f: figure) {
			if (f instanceof AktivnaFigura) {
				((AktivnaFigura) f).pokreni();
			}
		}
	}
	@Override
	public synchronized void paint(Graphics g) {
		for (Figura f:figure) {
			f.crtaj();
		}
	}
	
	public synchronized void zaustavi() {
		for (Figura f: figure) {
			if (f instanceof AktivnaFigura) {
				((AktivnaFigura) f).zaustavi();
			}
		}
	}
	
}
