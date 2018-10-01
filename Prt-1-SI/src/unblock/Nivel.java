package unblock;
import java.io.File;

/**
 * Esta clase se inicializa para desplegar el ComboBox del
 * panel derecho de la intefaz. (NO ES NECESARIO MODIFICAR)
 */
public class Nivel {
	
	private File archivo;
	private String nombre;
	
	/**
	 * Crea un Nivel y guardado con la extensión .puzzle.
	 * @param f	.puzzle File
	 */
	public Nivel(File f) {
		archivo = f;
		String[] nombreArchivo = f.getName().split("-");
		nombre = nombreArchivo[0] + " " +
				Integer.parseInt(nombreArchivo[1].substring(0,2));
	}
	
	/**
	 * @return Devuelve el archivo asociado con el objeto Nivel.
	 */
	public File file() {
		return archivo;
	}
	
	public String toString() {
		return nombre;
	}
	
}
