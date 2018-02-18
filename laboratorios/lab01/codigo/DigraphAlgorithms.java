    import java.util.ArrayList;
    import java.util.Arrays;
    import java.io.File;
    import java.util.Scanner;
    /**
     * This class contains algorithms for digraphs.
     * Adapted from: http://cs.fit.edu/~ryan/java/programs/graph/Dijkstra-java.html
     * @author Mauricio Toro, Juan Jose Parra y Luisa Maria Vasquez
     * @version 1
     */
    public class DigraphAlgorithms
    {
        
       private static int minVertex (int [] dist, boolean [] v) {
            int x = Integer.MAX_VALUE;
            int y = -1;   // graph not connected, or no unvisited vertices
            for (int i=0; i<dist.length; i++) {
               if (!v[i] && dist[i]<x) {y=i; x=dist[i];}
            }
            return y;
       }
      
        
         /**
          * Algoritmo de Dijsktra
          * @param dg Grafo
          * @param source Nodo de salida
          * @return Ruta mas corta
          */
       static int [] dijsktra(Graph dg, int source)
       {
              final int [] dist = new int [dg.size()];  // shortest known distance from "s"
             final int [] pred = new int [dg.size()];  // preceeding node in path
             final boolean [] visited = new boolean [dg.size()]; // all false initially
       
             for (int i=0; i<dist.length; i++) {
               dist[i] = Integer.MAX_VALUE; //Infinity
           }
            dist[source] = 0;
      
            for (int i=0; i<dist.length; i++) {
               final int next = minVertex (dist, visited);
               visited[next] = true;
      
               // The shortest path to next is dist[next] and via pred[next].
      
               final ArrayList<Integer> n = dg.getSuccessors (next); 
               for (int j=0; j<n.size(); j++) {
                  final int v = n.get(j);
                  final int d = dist[next] + dg.getWeight(next,v);
                  if (dist[v] > d) {
                     dist[v] = d;
                     pred[v] = next;
                  }
               }
            }
            return pred;  // (ignore pred[s]==0!)
       }
      
      
       /**
       * Metodo usado para pruebas
       *
       */
           public static ArrayList getPath (int [] pred, int s, int e) {
            final java.util.ArrayList path = new java.util.ArrayList();
           int x = e;
            while (x!=s) {
               path.add (0, x);
               x = pred[x];
            }
            path.add (0, s);
            return path;
         }
     
       /**
        * Código para dibujar el grafo en GraphViz
        * @param g Grafo a dibujar
        */
         public static void dibujarGrafo(Graph g)
         {
            System.out.println("digraph Grafo {");
            System.out.println("node [color=cyan, style=filled];");
            int nv = g.size();
            for (int i = 0; i < nv; i++)
            {
               ArrayList<Integer> lista = g.getSuccessors(i);
               for (int j = 0; j < lista.size(); j++)
                 System.out.println("\"" + i + "\" -> \"" + lista.get(j) + "\" [ label=\""+ g.getWeight(i,lista.get(j)) +"\"];");
            }
            System.out.println("}");
         }
         
         /**
          * Metodo que determina cual es el vertice del grafo con mas sucesores comparando el tamaño del ArrayList 
          * obtenido al llamar el metodo getSuccessors.
          * @param g Grafo en el que se buscara el vertice con mas sucesores.
          * @return Vertice con mas sucesores.
          */
       public static int masSucesores(Graph g){
             if(g instanceof DigraphAL){
                 int max=0;
                 int gan=0;
                 DigraphAL a=(DigraphAL)g;
                 for(int i =0;i<a.lista.size();i++){
                     int suc=a.lista.get(i).size();
                     if(suc>max){
                        gan=i;
                        }
                    }
                    return gan;
              }else{
                  int max=0;
                  int gan=0;
                  DigraphAM a=(DigraphAM)g;
                  for(int i=0;i<a.matriz.length;i++){
                      int suc= a.getSuccessors(i).size();
                       if(suc>max){
                        gan=i;
                        }
                    }
                    return gan;
                }
            }
            
            
         /**
          * Método que prueba que el algoritmo de Dijsktra funciona con las dos implementaciones de grafos (Matrices y listas de adyancencia"
          */
       public static void pruebaDijsktra(){
              DigraphAL dgal = new DigraphAL(5);
             dgal.addArc(0,1,10);
             dgal.addArc(0,2,3);
             dgal.addArc(1,2,1);
             dgal.addArc(1,3,2);
             dgal.addArc(2,1,4);
             dgal.addArc(2,3,8);
             dgal.addArc(2,4,2);
             dgal.addArc(3,4,7);
             dgal.addArc(4,3,9);
              System.out.println("Dijsktra con DigraphAL");
             System.out.println(getPath(dijsktra(dgal,0),0,3));
             
             DigraphAM dgam = new DigraphAM(5);
             dgam.addArc(0,1,10);
             dgam.addArc(0,2,3);
             dgam.addArc(1,2,1);
             dgam.addArc(1,3,2);
             dgam.addArc(2,1,4);
             dgam.addArc(2,3,8);
             dgam.addArc(2,4,2);
             dgam.addArc(3,4,7);
             dgam.addArc(4,3,9);
             System.out.println("Dijsktra con DigraphAM");
             System.out.println(getPath(dijsktra(dgam,0),0,3)); 
             
        }
         
         /**
          * Método que prueba que el algoritmo implementado para saber que nodo tiene más sucesores funciona con las dos implementaciones de grafos
          * (Matrices y listas de adyancencia"
          */
       public static void pruebaMasSucesores(){
              DigraphAL dgal = new DigraphAL(5);
             dgal.addArc(0,1,10);
             dgal.addArc(0,2,3);
             dgal.addArc(1,2,1);
             dgal.addArc(1,3,2);
             dgal.addArc(2,1,4);
             dgal.addArc(2,3,8);
             dgal.addArc(2,4,2);
             dgal.addArc(3,4,7);
             dgal.addArc(4,3,9);
              System.out.println("Mas sucesores con DigraphAL");
             System.out.println(masSucesores(dgal));
             
             DigraphAM dgam = new DigraphAM(5);
             dgam.addArc(0,1,10);
             dgam.addArc(0,2,3);
             dgam.addArc(1,2,1);
             dgam.addArc(1,3,2);
             dgam.addArc(2,1,4);
             dgam.addArc(2,3,8);
             dgam.addArc(2,4,2);
             dgam.addArc(3,4,7);
             dgam.addArc(4,3,9);
             System.out.println("Mas sucesores con DigraphAM");
             System.out.println(masSucesores(dgam)); 
             
       }

       /**
        * Metodo que lee el archivo txt que contiene todas las calles de Medellin y las ubica en un grafo de listas de adyacencia.
        */
        public static void leerGrafo() {    
            try {
                File file = new File("medellin_colombia-grande.txt");
                Scanner input = new Scanner(file);
                String line = input.nextLine();             
               DigraphAL grafo = new DigraphAL(Integer.MAX_VALUE);
                while (input.hasNextLine()) {                    
                    line = input.nextLine();
                    String[] compone=line.split(" ");                 
                    int calle =(int)Double.parseDouble(compone[0]);
                    int esquina1 =(int)Double.parseDouble(compone[1]);
                    int esquina2=(int)Double.parseDouble(compone[2]);
                    grafo.addArc(esquina1,esquina2,calle);
                }
                input.close();
    
            } catch (Exception ex) {
                
            }
        }
    
        
       public static void main(String[] args){
             pruebaDijsktra();
             pruebaMasSucesores();
         }
}
