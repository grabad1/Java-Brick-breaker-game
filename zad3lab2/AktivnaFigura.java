package zad3lab2;

import java.awt.Color;

public abstract class AktivnaFigura extends Figura implements Runnable {
	protected int ms;
	protected Thread nit;
	public AktivnaFigura(Scena s, double x, double y, Color c, int ms) {
		super(s, x, y, c);
		this.ms=ms;
	}

	@Override
	public void run() {
		
	}
	public void pokreni() {
		nit=new Thread(this);
		nit.start();
	}
	public void zaustavi() {
		nit.interrupt();
	}
	@Override
	void unisti() {
		super.unisti();
		zaustavi();
	}
}
