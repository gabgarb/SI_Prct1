package unblock;

/**
 * Representaci�n de la situaci�n de un operador o
 * transici�n entre dos estados
 * IMPLEMENTAR LA CLASE COMPLETA INCLUYENDO VARIABLES
 * NECESARIAS PARA DEFINIR LA MISMA.
 */
public class Operador {

        private char bloque;
        private int pasos;
    
	public Operador(char bloque, int pasos) {
            this.bloque = bloque;
            this.pasos = pasos;
	}
	
	public char getBloque() {
            return bloque;
	}

	public int getPasos() {
            return pasos;
	}

        public void setBloque(char bloque) {
            this.bloque = bloque;
        }

        public void setPasos(int pasos) {
            this.pasos = pasos;
        }   
                
}
