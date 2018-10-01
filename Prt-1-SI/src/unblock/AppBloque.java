package unblock;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AppBloque extends JPanel {

	private int x, y;
	private final int ancho, alto;
	private boolean orientacion;
	public static final boolean HORIZONTAL = true;
	public static final boolean VERTICAL   = false;
	private JLabel lbl;

	public AppBloque(int x, int y, int t, boolean o, char c) {
		this.x = x;
		this.y = y;
		this.orientacion = o;
		this.ancho = (o == HORIZONTAL)? 100 * t - 1 :
			100 - 1;
		this.alto = (o == HORIZONTAL)? 100 - 1 :
			100 * t - 1;
		setBounds(x, y, ancho, alto);
		setPreferredSize(new Dimension(ancho, alto));
		setBackground(new Color(random(), random(), random()));
		lbl = new JLabel(c+"");
		add(lbl);
	}

	public void setColor(Color color) {
		setBackground(color);
		lbl.setBackground(color);
	}

	private int random() {
		return (int)(Math.random() * 256);
	}

	public void move(int d) {
		try {
			if (orientacion == HORIZONTAL)
				for (int i = 0; i <= Math.abs(d); i++) {
					setBounds(x + ((d < 0)? -i : i), y, ancho, alto);
					Thread.sleep(10);
				}
			else
				for (int i = 0; i <= Math.abs(d); i++) {
					setBounds(x, y + ((d < 0)? -i : i), ancho, alto);
					Thread.sleep(10);
				}
		x = getX();
		y = getY();
		} catch(InterruptedException e) {}
	}

}
