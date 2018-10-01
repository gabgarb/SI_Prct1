package unblock;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class App extends JFrame {
	
	public App() {
		AppShared.app = this;
		setTitle("Práctica 1");
		setSize(new Dimension(930, 650));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		
		AppTablero tablero		= new AppTablero();
		AppShared.tablero = tablero;
		AppMenu rightSidebar = new AppMenu();

		getContentPane().add(rightSidebar, BorderLayout.EAST);
		getContentPane().add(tablero, BorderLayout.CENTER);
		setVisible(true);
	}
	
	public static void main(String[] args) throws InterruptedException {
		new App();
	}
	
}
