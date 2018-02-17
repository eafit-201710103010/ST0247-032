import java.util.ArrayList;
/**
 * Abstract class for implementations of Digraphs
 * 
 * @author Mauricio Toro
 * @version 1
 */
public abstract class Graph
{
    /**
     * Numero de vertices del grafo
     */
   protected int size;

   /**
    * Constructor de la clase grafo
    * @param vertices Vertices existentes en el grafo
    */
   public  Graph(int vertices) 
   {
       size = vertices;

   }
   public  abstract void addArc(int source, int destination, int weight);
   public abstract ArrayList<Integer> getSuccessors(int vertice);
   public abstract int getWeight(int source, int destination);
   public  int size() {return size;}
}