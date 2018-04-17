
/**
 * Taller 10
 * 
 * @author Juan jose Parra , Luisa Maria Vasquez
 * @version 19/04/2018
 */
public class Taller10
{
    public static int lcsdyn(String x, String y){
        int[][] mat = new int[x.length()+1][y.length()+1];
        
        for(int i=0; i<=x.length(); i++){
            for(int j=0; j<=y.length(); j++){
                if(i==0 || j==0){
                    mat[i][j]=0;
                }else if(x.charAt(i-1)==y.charAt(j-1)){
                    mat[i][j] = 1 + mat[i-1][j-1];
                }else{
                    mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
                }
            }
        }

        return mat[x.length()][y.length()];
    }
    
    public static String lcsdyn2(String x, String y){
        int[][] mat = new int[x.length()+1][y.length()+1];
        String mas="";
        for(int i=0; i<=x.length(); i++){
            for(int j=0; j<=y.length(); j++){
                if(i==0 || j==0){
                    mat[i][j]=0;
                }else if(x.charAt(i-1)==y.charAt(j-1)){
                    mas+=x.charAt(i-1);
                    mat[i][j] = 1 + mat[i-1][j-1];
                }else{
                    mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
                }
            }
        }

        return mas;
    }
}
