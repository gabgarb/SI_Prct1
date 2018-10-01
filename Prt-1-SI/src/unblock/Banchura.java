package unblock;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/* Las siguientes librerias sólo son necesarias para
  ejecutor la función main de esta clase.*/
/*import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;*/

import lib.Queue;
import lib.Stack;

/**
 * Clase que hereda de Busqueda para implementar el algoritmo
 * de búsqueda de primero en anchura.
 * (ES NECESARIO COMPLETAR EL CONSTRUCTOR DE ESTA CLASE)
 */
public class Banchura extends Busqueda{
	private class Rastreador{
	    private Estado estado;
	    private int nMovimientos;
	   	private Rastreador padre;
	    
	    public Rastreador(Estado b, int m, Rastreador p) {
	    	this.estado = b;
	    	this.nMovimientos = m;
	    	this.padre = p;
	   	}
	}
			 
	/**
	 *  Busca una solución al puzzle utilizando el algoritmo
	 *  de búsqueda primero en anchura.
	 * @param inicial		El estado inicial del tablero
	 */
	public Banchura(Estado initial) {
    	Queue<Rastreador> queue = new Queue<Rastreador>();
    	ArrayList<Estado> consumido = new ArrayList<Estado>();

    	duracion = System.currentTimeMillis();
    	
        throw new UnsupportedOperationException("Falta implementar");


/*    	Una vez completada la búsqueda pasa los valores para las variables
 * 		 resoluble y solucion de la clase Busqueda
 * 		if (queue.isEmpty()) {
    		resoluble = false;
    		return;
    	}
    	
    	duracion = System.currentTimeMillis() - duracion;
    	
    	Rastreador prev = sn;
    	solucion = new Stack<Operador>();
    	
    	while (prev != null) {
    		solucion.push(prev.estado.getOperador());
    		nMovimientos++;
    		prev = prev.padre;
    	}
    	resoluble = true;*/
    }
	

	public boolean isResoluble() {
		return resoluble;
	}

	public long getDuracion() {
		return duracion;
	}

	public int expEstados() {
		return expEstados;
	}

	public int nMovimientos() {
		return nMovimientos;
	}

	public Iterable<Operador> solucion() {
		if (!resoluble) return null;
    	return solucion;
	}
/*	
	public static void main(String[] args) {
		 // crea un estado inicial cargando el puzzle de un archivo.
		File file = new File("puzzles/Principiante-02.puzzle");
		
		Scanner in = null;
		try {
			in = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		in.next();
		
        int N = 6;
        char[][] bloques = new char[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                bloques[i][j] = in.next().charAt(0);
        

        Estado inicial = new Estado(bloques);
        
        // computa la solucion al puzzle
        try {
        	Banchura busqueda = new Banchura(inicial);
		} catch (UnsupportedOperationException e2) {
			JOptionPane.showMessageDialog(null,
					e2.getMessage());
		}
        // imprime por consola la solución al puzzle 
        System.out.println("Número mínimo de movimientos = " + busqueda.nMovimientos());
        
        for (Operador a: busqueda.solucion())
        	System.out.println(a);
	}*/
}
