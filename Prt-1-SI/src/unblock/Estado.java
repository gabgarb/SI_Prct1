package unblock;
import java.util.Arrays;
import java.util.Stack;

/**
 * Representaci�n de la situaci�n de un tablero en un
 * instante del juego.
 * IMPLEMENTAR LAS FUNCIONES INCOMPLETAS DE ESTA CLASE
 * - isEstadoFinal()
 * - eAdyacentes()
 * - getOperador()
 * - equals()
 * - heuristica()
 * 
 */
public class Estado {

    char[][] casillas;
    private int N;
    char ultimoBloqueMovido = '?';
    int pasosMovidos = 0;
    private int heuristica = -1;
    
    /** Constructor del estado (tablero de N x N)
    * 	bloques [I][J] = bloque en fila I, columna J)
    */
    public Estado(char[][] bloques) {
        // Constructor del estado (tablero de N x N)
        // bloques [I][J] = bloque en fila I, columna J)
        N = bloques.length;
        this.casillas = new char[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
    		    this.casillas[i][j] = bloques[i][j];
    }

    /** Constructor del estado (tablero de N x N)
    * 	bloques [I][J] = bloque en fila I, columna J)
    * 	el char bloque representa el �ltimo bloque movido
    * 	el entero pasos representa el n�mero de casillas desplazado
    */
    public Estado(char[][] bloques, char bloque, int pasos) {
        this(bloques);
        this.ultimoBloqueMovido = bloque;
        this.pasosMovidos = pasos;
    }
    
    public int dimension() {
        return N;	//tama�o del lado del cuadrado
    }
    
    /**
     *  Si el valor ha sido calculado, devuelve el valor
   	 *	en caso contrario lo calcula y lo devuelve
     * @return el dato de la heur�stica para este Estado
     */
    public int heuristica() {

        if (heuristica != -1) return heuristica;
        if (isEstadoFinal()) return 0;
        int c = 0;
        char valor;
        int i = 0;
        for(int j=0; j<N; j++){
            if(casillas[j][N] == 'x'){
                valor = casillas[j][N];//Probablemente inecesario.
                i = j;
            }
        }
        return N-i;
    }
    /**
     * Comprueba si ha llegado al final del juego
     * @return
     */
    public boolean isEstadoFinal() {
        /*if(heuristica() == 0) return true;*/
        int i = 0;
        
        /*Recorremos la matriz en el eje de las J y la posición N/2 de las I,
        en caso de finalizar y encontrarnos en el ultimo elemento con una 'x', 
        estamos en el satado final*/
        for(int j=0; j<N; j++){
            if(casillas[j][N/2] == 'x'){
                i = j;
            }
        }
        if(i == N) return true;
        else return false;
        
    }
    
    
 
    private char[][] copiarCasillas() {
        char[][] array = new char[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                array[i][j] = casillas[i][j];

        return array;
    }
    
    /**
     * Calcula todos los estados posibles partiendo del actual
     * @return Un objeto tipo iterable con todos los estados adyacentes
     */
    public Iterable<Estado> eAdyacentes() {
        Stack<Estado> eAdyacentes = new Stack<Estado>();

        int tempi = 0, tempj = 0;
        char[][] casillasMirror = copiarCasillas();
        
        
                
        throw new UnsupportedOperationException("Falta implementar");
    }
    
    /** representaci�n del estado en formato texto
     * 
     */
    public String toString() {
        String s = ultimoBloqueMovido + ", " + pasosMovidos + "\n";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                s += casillas[i][j] + " ";

            s += "\n";
        }

        return s;
    }    
    
    public Operador getOperador() {
        throw new UnsupportedOperationException("Falta implementar");
    }
    
    /** Intercambia los valores en un array.
     */
    private void swap(char[][] array, int row1, int row2, int col1, int col2) {
        char temp = array[row1][col1];
        array[row1][col1] = array[row2][col2];
        array[row2][col2] = temp;
    }
    
    /** Comprueba si un estado es igual a otro
     * 
     */
    public boolean equals(Object o) {
        if (!(o instanceof Estado)) return false;
        Estado b = (Estado) o;
        return Arrays.equals(this.casillas, b.casillas);
    }
}
