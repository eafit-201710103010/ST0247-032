import java.util.*;
/**
 * Solucion al ejercicio en linea del lab 6
 * 
 * @author Santiago Escobar , Sebastian Giraldo y Luisa Maria Vasquez
 * @version 5/11/2017
 */
public class EjercicioEnLinea
{
    
    public static void main(String [] args){
        entrada();
    }
    
    public static void entrada(){
        System.out.println("");
        Scanner sc=new Scanner(System.in);
        int NumNodos=sc.nextInt();
        if(NumNodos != 0){
            DigraphAL g= new DigraphAL(NumNodos);
         int arcos=sc.nextInt();
        for(int i =0;i<arcos;i++){
            int source=sc.nextInt();
            int destination=sc.nextInt();
            g.addArc(source,destination,1);
            g.addArc(destination,source,1);
         }
         
         System.out.println(isBicolorable(g) ? "BICOLORABLE" :"NOT BICOLORABLE");
         entrada();
       }
    }
    
    public static boolean isBicolorable(DigraphAL g){
        ArrayList<Integer> group1=new ArrayList<Integer>();
        ArrayList<Integer> group2=new ArrayList<Integer>();
      
        int size1= g.getSuccessors(0).size();
        for(int i =0;i<g.lista.size();i++){
           int vertex= g.getSuccessors(i).size();
           if(g.getSuccessors(i).size()==size1){
               group1.add(i);
            }
        }
        int size2=0;
        for(int i =0;i<g.lista.size();i++){
           if(!group1.contains(i)){
               size2=g.getSuccessors(i).size();
               break;
            }
        }
        
        for(int i =0;i<g.lista.size();i++){
           int vertex= g.getSuccessors(i).size();
           if(g.getSuccessors(i).size()==size2){
               group2.add(i);
            }
        }
        
        boolean uno= (group1.size()==size2);
        boolean dos= (group2.size()==size1);
       
        return uno && dos ;
        
    }
    
}