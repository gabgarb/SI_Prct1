package unblock;
import lib.Stack;


public abstract class Busqueda {
	protected boolean resoluble;
	protected int nMovimientos = -1;
	protected Stack<Operador> solucion;
	protected int expEstados = 0;
	protected long duracion = 0;
		
	/**
	 *  Devuelve si el puzzle se puede resolver
	 *  @return true si se puede resolver
	 */
	protected abstract boolean isResoluble();

	/**
	 *  Numero de movimientos necesarios para llegar a la solución
	 *  @return Dato de tipo entero
	 */
	protected abstract int nMovimientos();
	
	/**
	 *  Numero de estados visitados para llegar a la solución
	 *  @return Dato de tipo entero
	 */
	protected abstract int expEstados();
	
	/**
	 *  Tiempo de ejecución necesario para llegar a la solución
	 *  @return Tiempo en tipo long
	 */	
    protected abstract long getDuracion();
    


	/**
	 *  Devuelve la solución estado a estado
	 *  @return Un dato tipo iterable<Operador> con la solución
	 */
    protected abstract Iterable<Operador> solucion();
}
