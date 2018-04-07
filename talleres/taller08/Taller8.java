/**
 * Soleftucion al talleright 8
 * 
 * @authoright Juan Jose Parra, luisa Maria Vasquez 
 * @version 06/04/2018
 */
public class Taller8
{

    public static int[] mergeSort(int[] a){
        mergeSort(a,0,a.length-1);
        return a ;
    }
    
    private static void mergeSort(int[] a, int left, int r){
        if(left < r){
            int m = (r+left)/2;
            mergeSort(a,left,m);
            mergeSort(a,m+1,r);
            merge(a,left,m,r);
        }        
    }
    
    private static void merge(int[] a, int l, int m, int r){
        int tam1=m-l+1;
        int[] arr1= new int[tam1];
        int tam2=r-m;
        int[] arr2= new int[tam2];        
        for(int i=0;i<tam1;i++){
            arr1[i] = a[l+i];
        }
        for(int x=0;x<tam2;x++){
            arr2[x] = a[m+1+x];
        } 
        int x = 0;
        int y = 0;
        int z = l;
        while(x < tam1 && y < tam2){
            if(arr1[x] <= arr2[y]){
                a[z] = arr1[x];
                x++;
            }
            else{
                a[z] = arr2[y];
                y++;
            }
            z++;
        }
        
        while(x<tam1){
            a[z] = arr1[x];
            x++;
            z++;
        }
        
        while(y < tam2){
            a[z] = arr2[y];
            y++;
            z++;
        }
    }
    
    
    public static int[] quickSort(int[] a){
        quickSort(a,0,a.length-1);
        return a;
    }
    
    private static void quickSort(int[] a, int me, int ma){
        if(me < ma){
            int pivote = partition(a,me,ma);
            quickSort(a,me,pivote-1);
            quickSort(a,pivote+1,ma);
        }
    }
    
    private static int partition(int[] a, int me, int ma){
        int pivote =a[ma];
        int i =me-1;
        for(int j=me;j<ma;j++){
            if(a[j] <=pivote){
                i++;
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        int temp2=a[i+1];
        a[i+1]=a[ma];
        a[ma]=temp2;    
        return i+1;
    }
    
    
}
