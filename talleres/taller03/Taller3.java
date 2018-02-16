
import java.util.*;
import java.util.*;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #3
 * Realizado por: Juan Jose Parra, Luisa Maria Vasquez
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller3 {
    
   static int sol;
   
    private static boolean puedoPonerReina(int r, int c, int[] tablero) {
        for (int i=0; i<r;i++) {
            if ( (i-r)==(tablero[i]-c)||(i-r)==(c-tablero[i]) || tablero[i]==c){ 
                return false;
            }
        }
        return true;
    }
    
    public static int nReinas(int n) {
        int[] tablero=new int[n];
        sol=0;
        int res = nReinas(0,n,tablero);
        return res;
    }
    
    private static int nReinas(int r, int c, int[] queens){
        for (int i = 0;i<c;i++){
          if(puedoPonerReina(r, i, queens)){
                queens[r] = i;
              if(r ==c-1){
                    imprimirTablero(queens);
                    sol++;
              }else{
                    nReinas(r+1,c,queens);
              }
          }
        }
        return sol;
    }

    public static void imprimirTablero(int[] tablero) {
        int n = tablero.length;
        System.out.print("    ");
        for (int i = 0; i < n; ++i)
            System.out.print(i + " ");
        System.out.println("\n");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + "   ");
            for (int j = 0; j < n; ++j)
                System.out.print((tablero[i] == j ? "Q" : "#") + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static ArrayList<Integer> camino(Digraph g, int inicio, int fin) {
           boolean[] vis = new boolean[g.size()];
          ArrayList<Integer> camino = new ArrayList<Integer>();
          dfs(g,inicio,fin,vis,camino);
          camino.add(fin);
          return camino;
    }

    // recomendacion
    private static boolean dfs(Digraph g, int nodo, int objetivo, boolean[] visitados, ArrayList<Integer> list) {
       if (nodo==objetivo){ 
            return true;
       }else{
            ArrayList<Integer> sucesores = g.getSuccessors(nodo);
            for(int i=0;i<sucesores.size();i++){
                if(!visitados[sucesores.get(i)]){
                    visitados[sucesores.get(i)]=true;
                    list.add(nodo);
                    dfs(g,sucesores.get(i),objetivo,visitados,list);
                }
            }       
       }
        return false;
    }
    
    public static void main(String [] args){

         System.out.println(nReinas(4));
        // System.out.println(nReinas(5));
    }

}