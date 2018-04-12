/**
 * Clase en la cual se implementan los metodos del Taller de Clase #9
 * 
 * @author Mauricio Toro, Mateo Agudelo, Juan Jose Parra, Luisa Maria Vasquez
 */
public class Taller9 {

	public static int levenshtein(String a, String b) {      
	    
        if (a.equals(b)) {
            return 0;
        }else if (a.length() == 0 ) {
            return b.length();
        }else if (b.length() == 0) {
            return a.length();
        }

        int[] arr1 = new int[b.length() + 1];
        int[] arr2 = new int[b.length() + 1];
        int[] temp;
        
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i;
        }
        
        for (int i = 0; i < a.length(); i++) {
            arr2[0] = i + 1;
            for (int j = 0; j < b.length(); j++) {
                int cost = 1;
                if (a.charAt(i) == b.charAt(j)) {
                    cost = 0;
                }
                arr2[j + 1] = Math.min(arr2[j] + 1, Math.min(arr1[j + 1] + 1,arr1[j] + cost)); 
            }
            temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }
        return arr1[b.length()];
    }
}


