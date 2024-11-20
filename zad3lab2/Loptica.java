package zad3lab2;

import java.awt.Color;
import java.awt.Graphics;

public class Loptica extends AktivnaFigura {
	protected double r;
	private int smerX, smerY;
	private int t;
	private double pomX,pomY;
	private int cnt=0;
	public Loptica(Scena s, double x, double y,double r,  int ms) {
		super(s, x, y,Color.GREEN , ms);
		smerX=-1;
		smerY=1;
		this.r=r;
		t=ms;
		pomX=Math.random();
		pomY=( Math.random()-1);
	}

	@Override
	public void crtaj() {
		Graphics g=s.getGraphics();
		g.setColor(c);
		g.fillOval((int)(x-r/2),(int) (y-r/2),(int) r,(int) r);
	}
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				Thread.sleep(t);Graphics g=s.getGraphics();
				g.setColor(Color.WHITE);
				g.fillOval((int)(x-r/2),(int) (y-r/2),(int) r,(int) r);
				pomeri(smerX*pomX,smerY*pomY);
				cnt++;
				if (smerX>0) {
					if(x+r/2>=s.getWidth()) {
						x=s.getWidth()-r/2;
						smerX=-smerX;
					}
					synchronized (s) {
						for(Figura f: s.figure) {
							if(f instanceof Cigla) {
								Cigla c=(Cigla) f;
								if(!c.isPogodjena()) {
									if(c.y<=y &&y<=c.y+c.getH() && c.x<x+r/2 && c.x>=x) {
										x=c.x-r/2;
										smerX=-smerX;
										c.pogodi();
										break;
									}
								}
								else {
									c.crtaj();
								}
							}
						}
					}
					
				}
				else {
					if(x-r/2<=0) {
						x=r/2;
						smerX=-smerX;
					}
					synchronized (s) {
						for(Figura f: s.figure) {
							if(f instanceof Cigla) {
								Cigla c=(Cigla) f;
								if(!c.isPogodjena()) {
									if(c.y<=y && y<=c.y+c.getH() && c.x+c.getW()>x-r/2 && c.x+c.getW()<=x) {
										x=c.x+c.getW()+r/2;
										smerX=-smerX;
										c.pogodi();
										break;
									}
								}
								else {
									c.crtaj();
								}
							}
						}
					}
				}
				if(smerY>0) {
					if(y-r/2<=0) {
						y=r/2;
						smerY=-smerY;
					}
					synchronized (s) {
						for(Figura f: s.figure) {
							if(f instanceof Cigla) {
								Cigla c=(Cigla) f;
								if(!c.isPogodjena()) {
									if(c.x<=x && x<=c.x+c.getW() && c.y+c.getH()>y-r/2) {
										y=c.y+c.getH()+r/2;
										smerY=-smerY;
										c.pogodi();
										break;
									}
								}
								else {
									c.crtaj();
								}
							}
						}
					}
					
				}
				else{
					if(y+r/2>=s.getHeight()) {
						synchronized (s) {
							unisti();
							s.repaint();	
						}
					}
					synchronized (s.i) {
						if(s.i.x-s.i.getW()/2<=x && x<=s.i.x+s.i.getW()/2 && s.i.y<y+r/2 && s.i.y>=y) {
							y=s.i.y-r;
							smerY=-smerY;
							s.i.crtaj();
							continue;
						}
					}
					synchronized (s) {
						for(Figura f: s.figure) {
							if(f instanceof Cigla) {
								Cigla c=(Cigla) f;
								if(!c.isPogodjena()) {
									if(c.x<=x && x<=c.x+c.getW() && c.y<y+r/2 && c.y>=y) {
										y=c.y+c.getH()+r/2;
										smerY=-smerY;
										c.pogodi();
										break;
									}
								}
								else {
									c.crtaj();
								}
							}
						}
					}
					
					
				}
				if (cnt==100) {
					cnt=0;
					pomX*=1.001;
					pomY*=1.001;
				}
				crtaj();
			}
		}catch(InterruptedException e) {}
	}
	@Override
	public char getOznaka() {
		return 'L';
	}

}
