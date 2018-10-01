package unblock;
import java.util.ArrayList;

/**
 * Clase que hereda de Busqueda para implementar el algoritmo
 * de b�squeda A estrella.
 * (ESTE ARCHIVO ES SOLO EL ESQUELETO DE LA CLASE,
 * ES NECESARIO COMPLETAR LA IMPLEMENTACI�N)
 */
public class Baestrella extends Busqueda{	
	/**
	/**
	 *  Busca una soluci�n al puzzle utilizando el algoritmo
	 *  de b�squeda A*.
	 * @param inicial		El estado inicial del tablero
	 */
	public Baestrella(Estado initial) {
        throw new UnsupportedOperationException("Falta implementar");

    }

	public long getDuracion() {
		return duracion;
	}

	public int expEstados() {
		return expEstados;
	}

	public boolean isResoluble() {
		return resoluble;
	}

	public int nMovimientos() {
		return nMovimientos;
	}

	public Iterable<Operador> solucion() {
		if (!resoluble) return null;		
    	return solucion;
	}
}
