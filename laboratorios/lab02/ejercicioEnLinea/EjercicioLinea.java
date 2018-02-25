import java.util.*;
import java.io.*;
/**
 * Solución al ejercicio en linea
 * 
 * @author Juan Jose Parra, Luisa Maria Vasquez 
 * @version 25/02/2018
 */
public class EjercicioLinea
{
    public static void leer(){
      System.out.print(" ");
        Scanner sc=new Scanner(System.in);
        int tamaño=sc.nextInt();
        ArrayList<Integer> casos=new ArrayList<Integer>();
        while(tamaño!=0){
        int[] huecos =new int[tamaño];
        for(int i =0;i<huecos.length;i++){
            huecos[i]=-1;
        }
        String useless=sc.nextLine();
        for(int i =0;i<tamaño;i++){
            String a = sc.nextLine();
            for(int j =0;j<a.length();j++){
                if(a.charAt(j)=='*'){
                    huecos[i]=j;
                    
                }    
            } 
        }
        casos.add(queens(tamaño,huecos));
        tamaño=sc.nextInt();
      }
      
      for(int i =0;i<casos.size();i++){
          System.out.println("Case "+(i+1)+": "+casos.get(i));
        }
    }
    
    public static int queens(int n, int[] huecos) {
        int[] cuenta = {0};
        int[] queens = new int[n];
        String s = "";
        for(int i = 0; i < n; i++){
            s += i;
        }
       return queens("",s,n,queens, cuenta,huecos);
       
    }
    
       private static int queens(String pos, String pre, int n, int[] queens, int[] cuenta, int[] huecos) {
        if(pre.length() == 0){
            for(int i = 0; i < n; i++){
                queens[i] = Integer.parseInt(pos.charAt(i)+"");
            }
            if(esValido(queens,huecos)){
                cuenta[0]++;
            }
        } else {
            for (int i = 0; i < pre.length(); i++){
                queens(pos + pre.charAt(i), pre.substring(0,i) + pre.substring(i+1, pre.length()), n, queens, cuenta,huecos);
            }
        }
        return cuenta[0];
    }
    
    public static boolean esValido(int[] queens,int[] huecos) {
        for(int i = 0; i < queens.length; i++){
            for(int j = i+1; j < queens.length; j++){
                if(Math.abs(queens[i] - queens[j]) == Math.abs(i - j)){
                    return false;
                }
                if(queens[i]==huecos[i]){
                   return false;
                }
            }
        }
        
        return true;
    }
    
    public static void main(String[] args){
    leer();
    }
}
