package zad3lab2;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class IgraLoptica extends Frame {
	private Scena s;
	public IgraLoptica()  {
		s=new Scena();
		
		add(s);
		s.pokreni();
		addListeners();
		pack();
		setResizable(false);
		setVisible(true);
	}
	private void addListeners() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				s.zaustavi();
				dispose();
			}
		});
		
	}
	public static void main(String[] args) {
		new IgraLoptica();
	}

}
