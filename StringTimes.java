package warmup;

/**
 *
 * @author Ramona
 */
public class StringTimes {
    
    public static String stringTimes(String str, int n) {
        String restultStr = "";
  
        for (int i = 0; i < n; i++) {
            restultStr += str;
        }
      
        return restultStr;
    }
    
    
    public static void main(String[] args) {
        String res = stringTimes("Hi", 5);
        System.out.println(res);
    }
}
