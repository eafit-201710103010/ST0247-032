
/**
 * Solución al punto 1 del Laboratorio 2
 * 
 * @author Juan Jose Parra , Luisa María Vásquez 
 * @version 25/02/2018
 */
public class Punto1
{
   /**
    * Método que imprime un tablero con los espacios ocupados por reinas 
    * @param tablero Tablero a imprimir
    */
    public static void imprimirTablero(int[] tablero) {
        int n = tablero.length;
        System.out.print(" ");
        for (int i = 0; i < n; ++i)
            System.out.print(i + " ");
            System.out.println();
        for (int i = 0; i < n; ++i) {
            System.out.print(i + " ");
            for (int j = 0; j < n; ++j)
                System.out.print((tablero[i] == j ? "Q" : "#") + " ");
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Metodo que determina si en un tablero las reinas se atacan o no, e imprime los tableros válidos
     * @param queens Tablero a revisar
     * @return Si las reinas se atacan o no
     */
    public static boolean esValido(int[] queens) {
        for(int i = 0; i < queens.length; i++){
            for(int j = i+1; j < queens.length; j++){
                if(Math.abs(queens[i] - queens[j]) == Math.abs(i - j)){
                    return false;
                }
            }
        }
        imprimirTablero(queens);
        return true;
    }
    
    /**
     * Metodo que genera tableros posibles por fuerza bruta y cuenta los válidos para retornar la cantidad de soluciones posibles
     * @param pos Segunda parte del tablero
     * @param pre Primera parte del tablero
     * @param n Tamaño del tablero
     * @param queens Tablero generado
     * @param cuenta Cantidad de tableros válidos temporal
     * @return Número de soluciones posibles
     */
    private static int queens(String pos, String pre, int n, int[] queens, int[] cuenta) {
        if(pre.length() == 0){
            for(int i = 0; i < n; i++){
                queens[i] = Integer.parseInt(pos.charAt(i)+"");
            }
            if(esValido(queens)){
                cuenta[0]++;
            }
        } else {
            for (int i = 0; i < pre.length(); i++){
                queens(pos + pre.charAt(i), pre.substring(0,i) + pre.substring(i+1, pre.length()), n, queens, cuenta);
            }
        }
        return cuenta[0];
    }
    
    /**
     * Método que recibe un tamaño de tablero y determina cuantas soluciones hay para el problema de las n reinas en este
     * @param n Tamaño del tablero
     * @return Cantidad de soluciones a las n reinas
     */
    public static int queens(int n) {
        int[] cuenta = {0};
        int[] queens = new int[n];
        String s = "";
        for(int i = 0; i < n; i++){
            s += i;
        }
       return queens("",s,n,queens, cuenta);
       
    }
}
