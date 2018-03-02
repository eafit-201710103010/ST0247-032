import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #5
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller5 {

    public static boolean mColoring(Digraph g, int m) {
      int[] colors = new int[g.size()];
        for (int i = 0; i < g.size(); i++){
            colors[i] = 0;
        }
      boolean puede =mColoring(g, 0, colors, m);
        if (!puede){
            return false;
        }
        return true;
    }

    private static boolean isSafe(Digraph g, int v, int[] colors, int c) {
        for (int i = 0; i < g.size(); i++){
            if (g.getWeight(v,i) >= 1 && c == colors[i]){
                return false;
            }
        }
        return true;
    }

    // recomendacion
    private static boolean mColoring(Digraph g, int v, int[] colors, int m) {    
        if (v == g.size()){
            return true;
        }
        for (int c = 1; c <= m; c++){
            if (isSafe( g,v, colors, c)){
                colors[v] = c;
                if (mColoring(g, v+1,colors, m)){
                    return true;
                }
                colors[v] = 0;
            }
        }
        return false;
    }
}
