package warmup;

/**
 * Given a string, return a new string where the last 3 chars are now in upper case.
 * If the string has less than 3 chars, uppercase whatever is there.
 * 
 * @author Ramona
 */
public class EndUp {
    
    public static String endUp(String str) {
        if (str.length() <=3 ) {
            return str.toUpperCase();
        }
 
        String newStr = str.substring(str.length()-3).toUpperCase();
        return str.substring(0,str.length()-3).concat(newStr);
    }
    
    public static void main(String[] args) {
        String str = "hi there";
        String result = endUp(str);
        
        System.out.println(result);
    }
}
