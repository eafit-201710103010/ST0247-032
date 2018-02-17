import java.util.ArrayList;
import java.util.*;
/**
 * Esta clase es una implementación de un digrafo usando listas de adyacencia
 * 
 * @author Juan Jose Parra y Luisa Maria Vasquez
 * @version 1
 */
public class DigraphAL extends Graph
{
    /**
     * Lista de adyacencia de listas de parejas(sucesores)
     */
   protected LinkedList<LinkedList<Pareja>> lista;
   
   /**
    * Constructor de DigraphAL que crea e inicializa la lista de adyacencia
    * @param size Tamaño de la lista a construir
    */
   public DigraphAL(int size)
   {
     super(size);
     lista=new LinkedList<LinkedList<Pareja>>();
     for (int i = 0; i < size; ++i) {
            lista.add( new LinkedList<Pareja>());
      }
   }
   
   /**
    * Metodo que añade un arco al grafo
    * @param source Nodo de salida
    * @param destination Nodo de llegada
    * @param weight Peso del arco
    */
   public void addArc(int source, int destination, int weight)
   {
       boolean yaEsta=false;
       for(int i =0;i<lista.get(source).size();i++){
           if(lista.get(source).get(i).vertice==destination){
               yaEsta=true;
            }
        }
        if(yaEsta==false){
           lista.get(source).add(new Pareja(destination,weight));
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
      for(int i =0;i<lista.get(source).size();i++){
          if(lista.get(source).get(i).vertice==destination){
              return lista.get(source).get(i).peso;
            }
        }
        return 0;
   }
  
   /**
    * Metodo que retorna un ArrayList que contiene los sucesores del nodo indicado en el grafo
    * @param vertice Nodo del que se desea saber sucesores
    * @return ArrayList con los sucesores del nodo
    */
   public ArrayList<Integer> getSuccessors(int vertice)
   {
       ArrayList<Integer> a=new ArrayList<Integer>();
      for(int i =0;i<lista.get(vertice).size();i++){
         a.add( lista.get(vertice).get(i).vertice);
        }
        return a;
   }
}