import java.util.*;
import java.io.*;
/**
 * Clase en la cual se implementan los metodos del Taller de Clase #4
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller4 {

    public static int costoMinimo(Digraph g, int inicio, int fin) {
        return 0;
    }

    // recomendacion
    private static void dfs(Digraph g, int v, int[] costo) {
        // complete...
    }

   

    public static ArrayList<Integer> dfs(Digraph g, int start){
        boolean visitados[] = new boolean[g.size()];
        ArrayList<Integer> camino =new ArrayList<Integer>();
        dfs(g,start,visitados,camino); 
        return camino.size()>0 ? camino : null;
    }

    private static void dfs(Digraph g, int nodo,boolean[] visitados,ArrayList<Integer> list){    
        ArrayList<Integer> sucesores = g.getSuccessors(nodo);
        visitados[nodo] = true;
        list.add(nodo);
        if(sucesores != null){

            for (int i = 0; i < sucesores.size(); i++)
            {
                if(visitados[sucesores.get(i)]==false){
                    dfs(g,sucesores.get(i),visitados,list);     
                }

            }
        }

    }

    public static ArrayList<Integer> bfs(Digraph g, int start){
        boolean visitados[] = new boolean[g.size()];
        ArrayList<Integer> camino =new ArrayList<Integer>();
        LinkedList<Integer> v= new LinkedList<>();
        v.add(start);
        camino.add(start);
        while(v.isEmpty()==false){

            int ver = v.poll();
            ArrayList<Integer> sucesores = g.getSuccessors(ver);
            if(sucesores != null){
                for(int sucesor:sucesores){
                    v.add(sucesor);
                    if(!visitados[sucesor]){
                        camino.add(sucesor);
                    }

                    visitados[sucesor] = true;
                }
            }

        }

        return camino.size()>1 ? camino : null;
    }

    
     public static boolean hayCaminoDFS(Digraph g, int a, int b){
        boolean visitados[] = new boolean[g.size()];
        return hayCaminoDFSAux(g,a,b,visitados);
    }

    private static boolean hayCaminoDFSAux(Digraph g, int v, int w, boolean[] visitados){
        visitados[v] = true;
        ArrayList<Integer> sucesores = g.getSuccessors(v);
        if(sucesores != null){
            for (int i=0;i< sucesores.size();i++){ 
                if(!visitados[sucesores.get(i)]&&(sucesores.get(i)==w||
                    hayCaminoDFSAux(g,sucesores.get(i),w,visitados))){
                    return true ;                  
                }
            }
            return false;
        }else{
            if(v==w){
                return true;
            }else{
                return false;
            }
            
        }

    }
    
    public static boolean hayCaminoBFS(Digraph g, int start,int destino){
        boolean visitados[] = new boolean[g.size()];
        boolean hay =false;
        ArrayList<Integer> camino =new ArrayList<Integer>();
        LinkedList<Integer> v= new LinkedList<>();
        v.add(start);
        camino.add(start);
        while(v.isEmpty()==false){

            int ver = v.poll();
            ArrayList<Integer> sucesores = g.getSuccessors(ver);
            if(sucesores != null){
                for(int sucesor:sucesores){
                    v.add(sucesor);
                    if(!visitados[sucesor]){
                        camino.add(sucesor);
                    }
                    if(sucesor==destino){
                        return true;
                    }
                    visitados[sucesor] = true;
                }
            }

        }

        return hay;
    }
    
    
    public static void main(String[] args){
        DigraphAM g =new DigraphAM(6);
        g.addArc(3,0,1);
        g.addArc(3,1,1);
        g.addArc(0,2,1);
        g.addArc(1,4,1);
        ArrayList<Integer> esto= dfs(g,3);
        if(esto==null){
            System.out.println("nulo");
        }else{
            for(int nodo: esto){
                System.out.println(nodo);
            }
        }
        System.out.println("");
        ArrayList<Integer> est= bfs(g,3);
        if(est==null){
            System.out.println("nulo");
        }else{
            for(int nodo: est){
                System.out.println(nodo);
            }
        }
        System.out.println(hayCaminoDFS(g,3,4));
        System.out.println(hayCaminoBFS(g,3,4));
        System.out.println(hayCaminoDFS(g,2,4));
        System.out.println(hayCaminoBFS(g,2,4));
    }
}
