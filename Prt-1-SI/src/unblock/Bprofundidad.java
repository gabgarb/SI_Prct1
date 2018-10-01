package unblock;
import java.util.ArrayList;

/**
 * Clase que hereda de Busqueda para implementar el algoritmo
 * de búsqueda de primero en profundidad.
 * (ESTE ARCHIVO ES SOLO EL ESQUELETO DE LA CLASE,
 * ES NECESARIO COMPLETAR LA IMPLEMENTACIÓN)
 */
public class Bprofundidad extends Busqueda{
	
	/**
	 *  Busca una solución al puzzle utilizando el algoritmo
	 *  de búsqueda primero en profundidad.
	 * @param inicial		El estado inicial del tablero
	 */
	public Bprofundidad(Estado inicial) {
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
