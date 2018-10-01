package unblock;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Panel derecho del interfaz de usuario: menú
 * (NO ES NECESARIO MODIFICAR ESTA CLASE)
 */
@SuppressWarnings("serial")
public class AppMenu extends JPanel {

	private JComboBox<Nivel> cbNiveles;
	private JButton btnResolver;
	private JButton btnSimular;
	private JLabel lbMovimientos;
	private JLabel lbExpEstados;
	private JLabel lbDuracion;
	private JRadioButton rbAnchura;
	private JRadioButton rbProfundidad;
	private JRadioButton rbAestrella;
	
	public static boolean enprogreso = false;
	private Busqueda s;
	
	/**
	 * Crea el panel
	 */
	public AppMenu() {
		setPreferredSize(new Dimension(300,630));
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		initComponents();
		loadPuzzles();
	}

	/**
	 * Inicializa los componentes
	 */
	private void initComponents() {
		cbNiveles = new JComboBox<>();
		rbAnchura 	  = new JRadioButton("Búsqueda en Anchura");
		rbProfundidad     = new JRadioButton("Búsqueda en Profundidad");
		rbAestrella   = new JRadioButton("Búsqueda A*");
		btnResolver  = new JButton("Resolver");
		btnSimular  = new JButton("Simular");
		lbMovimientos = new JLabel("");
		lbExpEstados = new JLabel("");
		lbDuracion = new JLabel("");
		
		cbNiveles.setBounds(50, 0, 200, 30);
		rbAnchura.setBounds(50, 50, 200, 50);
		rbProfundidad.setBounds(50, 90, 200, 50);
		rbAestrella.setBounds(50, 130, 200, 50);
		btnResolver.setBounds(50, 240, 100, 50);
		btnSimular.setBounds(155, 240, 100, 50);
		lbMovimientos.setBounds(50, 420, 300, 30);
		lbExpEstados.setBounds(50, 460, 300, 30);
		lbDuracion.setBounds(50, 500, 300, 30);
		
		cbNiveles.setToolTipText("Seleccione el puzzle");
		cbNiveles.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rbAestrella.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rbAnchura.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rbProfundidad.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnResolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSimular.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rbAestrella.setFocusPainted(false);
		rbAnchura.setFocusPainted(false);
		rbProfundidad.setFocusPainted(false);
		btnResolver.setFocusPainted(false);
		btnSimular.setFocusPainted(false);

		rbAestrella.setBackground(Color.LIGHT_GRAY);
		rbAnchura.setBackground(Color.LIGHT_GRAY);
		rbProfundidad.setBackground(Color.LIGHT_GRAY);
		lbMovimientos.setBackground(Color.LIGHT_GRAY);
		lbExpEstados.setBackground(Color.LIGHT_GRAY);
		lbDuracion.setBackground(Color.LIGHT_GRAY);
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rbAestrella);
		radioGroup.add(rbAnchura);
		radioGroup.add(rbProfundidad);

		cbNiveles.addActionListener(new ComboBoxListener());
		btnResolver.addActionListener(new ResolverButtonListener());
		btnSimular.addActionListener(new SimularButtonListener());

		btnSimular.setEnabled(false);
		
		add(cbNiveles);
		add(rbAestrella);
		add(rbAnchura);
		add(rbProfundidad);
		add(btnResolver);
		add(btnSimular);
		add(lbMovimientos);
		add(lbExpEstados);
		add(lbDuracion);
	}

	/**
	 * Carga los niveles de la carpeta /puzzles
	 */
	private void loadPuzzles() {
		File nivelesDir = new File("puzzles/");
		for (File file : nivelesDir.listFiles()) {
			String fileName = file.getName();
			if (Pattern.matches(".*(\\.puzzle)$", fileName))
				cbNiveles.addItem(new Nivel(file));
		}
	}

	private class ComboBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				AppShared.tablero.load((Nivel)cbNiveles.getSelectedItem());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}

	private class ResolverButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
				new ResolverThread().start();
		}
	}
	
	private class SimularButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				AppShared.tablero.load((Nivel)cbNiveles.getSelectedItem());
				new SimularThread().start();
			} catch (FileNotFoundException e1) {}
		}
	}
	
	private class ResolverThread extends Thread {

		public void run() {
			btnResolver.setEnabled(false);
			btnSimular.setEnabled(false);
			cbNiveles.setEnabled(false);
			rbAestrella.setEnabled(false);
			rbAnchura.setEnabled(false);
			rbProfundidad.setEnabled(false);
			
			Nivel bFile= (Nivel)cbNiveles.getSelectedItem();
			Scanner in = null;
			try {
				in = new Scanner(bFile.file());
			} catch (FileNotFoundException e1) {}

			in.next();
			char[][] blocks = new char[6][6];
			for (int i = 0; i < 6; i++)
				for (int j = 0; j < 6; j++)
					blocks[i][j] = in.next().charAt(0);

			Estado initial = new Estado(blocks);
			
			if (rbAestrella.isSelected())
				try {
					s = new Baestrella(initial);
				} catch (UnsupportedOperationException e2) {
					JOptionPane.showMessageDialog(null,
							e2.getMessage());
				}
			else if (rbAnchura.isSelected())
				try {
					s = new Banchura(initial);
				} catch (UnsupportedOperationException e2) {
					JOptionPane.showMessageDialog(null,
							e2.getMessage());
				}
			else if (rbProfundidad.isSelected())
				try {
					s = new Bprofundidad(initial);
				} catch (UnsupportedOperationException e2) {
					JOptionPane.showMessageDialog(null,
							e2.getMessage());
				}
			else {
				JOptionPane.showMessageDialog(null,
						"Seleccione un algoritmo");
				enprogreso = false;
				
				lbMovimientos.setText("Número de movimientos: N/A");
				lbExpEstados.setText("Número de estados visitados: N/A");
				lbDuracion.setText("Tiempo de ejecución: N/A");
				
				btnResolver.setEnabled(true);
				btnSimular.setEnabled(true);
				cbNiveles.setEnabled(true);
				rbAestrella.setEnabled(true);
				rbAnchura.setEnabled(true);
				rbProfundidad.setEnabled(true);
				return;
			}
			
			lbMovimientos.setText("Número de movimientos: " + s.nMovimientos());
			lbExpEstados.setText("Número de estados visitados " + s.expEstados());
			lbDuracion.setText("Tiempo de ejecución: " + s.getDuracion());
			
			btnResolver.setEnabled(true);
			btnSimular.setEnabled(true);
			cbNiveles.setEnabled(true);
			rbAestrella.setEnabled(true);
			rbAnchura.setEnabled(true);
			rbProfundidad.setEnabled(true);
		}
	}

	private class SimularThread extends Thread {

		public void run() {
			btnResolver.setEnabled(false);
			btnSimular.setEnabled(false);
			cbNiveles.setEnabled(false);
			rbAestrella.setEnabled(false);
			rbAnchura.setEnabled(false);
			rbProfundidad.setEnabled(false);
			
			if (s.isResoluble())
				for (Operador a : s.solucion()) {
					try {
						if (a.getBloque() == 'X')
							AppShared.tablero.appBloques[0].move(100 * a.getPasos());
						else if (a.getBloque() != '?')
							AppShared.tablero.appBloques[a.getBloque() - 96].move(100 * a.getPasos());
					} catch (UnsupportedOperationException e3) {
						JOptionPane.showMessageDialog(null,
								e3.getMessage());
					}
				}
			else
				JOptionPane.showMessageDialog(null,
						"The board you selected has no solution");
			btnResolver.setEnabled(true);
			btnSimular.setEnabled(true);
			cbNiveles.setEnabled(true);
			rbAestrella.setEnabled(true);
			rbAnchura.setEnabled(true);
			rbProfundidad.setEnabled(true);
			
			AppShared.tablero.appBloques[0].setBackground(Color.GREEN);
		}
	}
}
