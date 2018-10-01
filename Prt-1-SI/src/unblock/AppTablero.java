package unblock;
import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * Panel izquierdo del interfaz de usuario: tablero
 * (NO ES NECESARIO MODIFICAR ESTA CLASE)
 */
@SuppressWarnings("serial")
public class AppTablero extends JPanel {
	
	public AppBloque[] appBloques;
	
	public AppTablero() {
		setSize(630, 640);
		setLayout(null);
		setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.GRAY));
		setBackground(new Color(222, 184, 135));
		appBloques = null;
	}
	
	/**
	 * Carga el puzzle de un archivo en disco.
	 * @param f	Nombre del nivel (.puzzle)
	 * @throws FileNotFoundException	Si el archivo no existe
	 */
	public void load(Nivel f) throws FileNotFoundException {
		if (appBloques != null) for (AppBloque b : appBloques) b.setVisible(false);
		Scanner in = new Scanner(f.file());
		int n = in.nextInt();
		appBloques = new AppBloque[n];
		String text = "";
		while (in.hasNextLine()) text += in.nextLine().replace(" ", "");
		int index = 0;
		anadirBloque('X', text, index++);
		for (char c = 'a'; c < 'a' + n - 1; c++)
			anadirBloque(c, text, index++);
		appBloques[0].setColor(Color.RED);
		in.close();
	}
	
	/**
	 * Convierte el puzzle a un intefaz visual más fácil de seguir
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 15; i <= 615; i += 100) {
			g.drawLine(i, 15, i, 615);
			g.drawLine(15, i, 615, i);
		}
		g.drawLine(515, 215, 615, 315);
		g.drawLine(615, 215, 515, 315);
	}
	
	/**
	 * Crea un bloque, lo guarda y lo imprime
	 * @param c		Letra que identifica al bloque.
	 * @param text	Contenido del archivo cargado.
	 * @param index	Índice del bloque a añadir.
	 */
	private void anadirBloque(char c, String text, int index) {
		ArrayList<Integer> indices = new ArrayList<Integer>(3);
		int i = -1;
		while ((i = text.indexOf(c, i+1)) != -1)
			indices.add(i);
		boolean orientation = (indices.get(1) == indices.get(0) + 1)?
							  AppBloque.HORIZONTAL : AppBloque.VERTICAL;
		int x = 100 * (indices.get(0) % 6) + 15 + 1;
		int y = 100 * (indices.get(0) / 6) + 15 + 1;
		appBloques[index] = new AppBloque(x, y, indices.size(),orientation, c);
		this.add(appBloques[index]);
	}
}
