import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

public class MyColor implements Icon{

	private Color color;
	private int rozmiar = 16;
	
	public MyColor(Color color) {
		this.color = color;

	}

	@Override
	public int getIconHeight() {
		return rozmiar;
	}

	@Override
	public int getIconWidth() {
		return rozmiar;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.setColor(color);
		g.drawOval(x, y, rozmiar-1, rozmiar-1);
		g.fillOval(x, y, rozmiar-1, rozmiar-1);
	}
	public Color getColor() {
		return color;
	}
	
	
}
