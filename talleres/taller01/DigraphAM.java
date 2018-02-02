
import java.util.ArrayList;

/**
 * Implementacion de un grafo dirigido usando matrices de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, <su nombre>
 */
public class DigraphAM extends Digraph {
	int[][] matriz;

	public DigraphAM(int size) {
      super(size);
      matriz =new int[size][size];
      for(int i=0; i< size; i++){
            for(int j=0; j< size; j++){
                matriz[i][j] = 0;
            }            
        }
   
	}

	public void addArc(int source, int destination, int weight) {
		matriz[source][destination]=weight;
	}

	public ArrayList<Integer> getSuccessors(int vertex) {
		ArrayList<Integer> s=new ArrayList<Integer>();
       for(int i =0;i<matriz[vertex].length;i++){
         if(matriz[vertex][i]!=0){
             s.add(i);
            }
        }
        return s;
	}

	public int getWeight(int source, int destination) {
		return matriz[source][destination];
	}

}