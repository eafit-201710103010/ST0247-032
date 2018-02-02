import java.util.*;

/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, <su nombre>
 */
public class DigraphAL extends Digraph {
    public LinkedList<LinkedList<Pair<Integer, Integer>>> lista;

    public DigraphAL(int size) {
        super(size);
          lista=new LinkedList<>();
         for (int i = 0; i < size; ++i) {
            lista.add( new LinkedList<Pair<Integer,Integer>>());
         }
    }

    public void addArc(int source, int destination, int weight) {
        if(source < lista.size() && destination < lista.size()){
        LinkedList a = lista.get(source);
        a.add(new Pair(destination, weight));
      }
    }

    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList a = new ArrayList<Integer>();
        for (int i = 0; i < lista.get(vertex).size(); i++) {
            a.add(lista.get(vertex).get(i).first);
        }
        if(a.isEmpty()){
            return null;
        }
        return a;
    }

    public int getWeight(int source, int destination) {
       LinkedList a = lista.get(source);
        if(a.isEmpty() ){
            return 0;
        }
        
        for(int i = 0; i < a.size(); i++){
            Pair par = (Pair)a.get(i);
            if ((int)(par.first) == destination){
                return (int)par.second;
            }
        }
        return 0;
    }

}