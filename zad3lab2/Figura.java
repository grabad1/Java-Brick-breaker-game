package zad3lab2;

import java.awt.Color;

public abstract class Figura {
	protected Scena s;
	protected double x,y;
	protected Color c;
	public Figura(Scena s,double x, double y, Color c) {
		this.s=s;
		this.x=x;
		this.y=y;
		this.c=c;
		s.addFigura(this);
	}
	void unisti() {
		s.removeFigura(this);
	}
	public abstract void crtaj();
	public abstract char getOznaka();
	public void pomeri(double dx,double dy) {
		if (x+dx>=0 && x+dx<=s.getWidth())
			x+=dx;
		y+=dy;
	}
}
