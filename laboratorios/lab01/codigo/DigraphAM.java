import java.util.ArrayList;
/**
 * Esta clase es una implementación de un digrafo usando matrices de adyacencia
 * 
 * @author Santiago Escobar , Sebastian Giraldo y Luisa Maria Vasquez
 * @version 1
 */
public class DigraphAM extends Graph
{
    /**
     * Matriz de adyacencia
     */
    int[][] matriz;
   /**
    * Constructor de DigraphAM que crea e inicializa la matriz de adyacencia
    * @param size Tamaño de la matriz a construir
    */
   public DigraphAM(int size)
   {
      super(size);
      matriz =new int[size][size];
      for(int i=0; i< size; i++){
            for(int j=0; j< size; j++){
                matriz[i][j] = 0;
            }            
        }
   }
   
   /**
    * Metodo que retorna el peso de un arco especifico del grafo
    * @param source Nodo de salida
    * @param destination Nodo de llegada
    * @return Peso del arco indicado
    */
   public int getWeight(int source, int destination)
   {
     return matriz[source][destination];
    }
   
    
    /**
    * Metodo que añade un arco al grafo
    * @param source Nodo de salida
    * @param destination Nodo de llegada
    * @param weight Peso del arco
    */
   public void addArc(int source, int destination, int weight)
   {
     matriz[source][destination]=weight;
   }
  
   /**
    * Metodo que retorna un ArrayList que contiene los sucesores del nodo indicado en el grafo
    * @param vertice Nodo del que se desea saber sucesores
    * @return ArrayList con los sucesores del nodo
    */
   public ArrayList<Integer> getSuccessors(int vertex)
   {
     ArrayList<Integer> s=new ArrayList<Integer>();
       for(int i =0;i<matriz[vertex].length;i++){
         if(matriz[vertex][i]!=0){
             s.add(i);
            }
        }
        return s;
   }
}