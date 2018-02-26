import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/**
 * Solucion al ejercicio en linea
 * 
 * @author Juan Jose Parra , Luisa Maria Vasquez
 * @version 25/02/2018
 */
public class nreinasTableroRoto
{
    int sol;
    public ArrayList<int[][]> inputManager() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String entrada = br.readLine();
        int largo = Integer.parseInt(entrada);
        ArrayList<int[][]> tableros = new ArrayList<>();
        while(largo != 0){
            int[][] huecos = new int[largo][largo];
            for(int f = 0; f < largo; f++){
                entrada = br.readLine();
                for(int c = 0; c < largo; c++){
                    if(entrada.charAt(c) == '*'){
                        huecos[f][c] = 1;
                    }
                }
            }
            tableros.add(huecos);
            entrada = br.readLine();
            largo = Integer.parseInt(entrada);
        }
        return tableros;
    }

    public static void main(String [] args){
        System.out.println();
        nreinasTableroRoto nreinas = new nreinasTableroRoto();
        ArrayList<int[][]> huecos = null;
        try{
            huecos = nreinas.inputManager();
        } catch (IOException e){}
        
        for(int[][] i: huecos){
            int n;
            for(n = 0; n < i.length; n++){}
            int[] tablero = new int[n];
            nreinas.sol=0;
            int res = nreinas.nReinas(0,n,tablero,i);
            System.out.println("Para caso de prueba " + n + ", puedo poner en " + res + " posiciones diferentes las reinas.");
        }
    }
    
    private boolean puedoPonerReina(int r, int c, int[] tablero, int[][] huecos) {
        if(huecos[r][c] == 1){
            return false;
        }
        for (int i=0; i<r;i++) {
            if ((i-r)==(tablero[i]-c)||(i-r)==(c-tablero[i]) || tablero[i]==c){ 
                return false;
            }
        }
        return true;
    }
    
    private int nReinas(int r, int c, int[] queens, int[][] huecos){
        for (int i = 0;i<c;i++){
          if(puedoPonerReina(r, i, queens, huecos)){
              queens[r] = i;
              if(r ==c-1){
                    //imprimirTablero(queens);
                    sol++;
              }else{
                    nReinas(r+1,c,queens, huecos);
              }
          }
        }
        return sol;
    }

    public void imprimirTablero(int[] tablero) {
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
}
