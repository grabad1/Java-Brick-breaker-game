package zad3lab2;

import java.awt.Color;
import java.awt.Graphics;

public class Cigla extends AktivnaFigura {
	private boolean pogodjena;
	private double h,w;
	public Cigla(Scena s, double x, double y,double w, double h, int ms) {
		super(s, x, y, Color.RED, ms);
		pogodjena=false;
		this.w=w;
		this.h=h;
		
	}
	public synchronized void pogodi() {
		pogodjena=true;
		pokreni();
	}
	public double getW() {
		return w;
	}
	public double getH() {
		return h;
	}
	public synchronized boolean isPogodjena() {
		return pogodjena;
	}
	@Override
	public void crtaj() {
		Graphics g=s.getGraphics();
		g.setColor((pogodjena) ? Color.GRAY : Color.RED );
		g.fillRect((int) x,(int) y,(int) w,(int) h);
	}

	@Override
	public char getOznaka() {
		return 'C';
	}
	@Override
	public void run() {
		try {
			while (!Thread.interrupted() && pogodjena) {
				Thread.sleep(ms);
				if (pogodjena) {
				
					y+=5;
					if (s.getHeight()<y) {
						unisti();
					}
				}
				s.repaint();
			}
		}catch(InterruptedException e) {}
	}
}
