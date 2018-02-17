/**
 * Clase Pareja para poder hacer una lista que tenga dos valores en sus nodos
 * 
 * @author Mauricio Toro
 */
public class Pareja
{
    /**
     * Vertice sucesor 
     */
    public int vertice;
    /**
     * Pesod el arco
     */
    public int peso;
    /**
     * Constructor de la clase Pareja
     * @param v Vertice al que se diriqe el arco
     * @param p Peso del arco
     */
    public Pareja(int v,int p) {vertice = v; peso = p;}
}