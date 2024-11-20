package zad3lab2;

import java.awt.Color;
import java.awt.Graphics;

public class Igrac extends Figura {
	private double w,h;
	public Igrac(Scena s, double x, double y,double w,double h) {
		super(s, x, y, Color.BLUE);
		this.w=w;
		this.h=h;
	}

	@Override
	public void crtaj() {
		Graphics g=s.getGraphics();
		g.setColor(c);
		double xx=x-w/2;
		double yy=y-h/2;
		g.fillRect((int) xx,(int) yy,(int) w, (int) h);
	}
	public double getH() {
		return h;
	}
	public double getW() {
		return w;
	}
	@Override
	public char getOznaka() {
		return 'I';
	}
	@Override
	public void pomeri(double dx, double dy) {
		if (x+dx-w/2>=0 && x+dx+w/2<=s.getWidth()) {
			super.pomeri(dx, 0);
		}
	}
	public void ispali(Color c) {
		Loptica l=new Loptica(s, x,y-h,h, 5);
		l.pokreni();
	}

}
