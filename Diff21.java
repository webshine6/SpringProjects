package warmup;

/**
 * Given an int n, return the absolute difference between n and 21,
 * except return double the absolute difference if n is over 21.
 * @author Ramona
 */
public class Diff21 {
    
    public static int diff21(int n) {
        if (n <= 21) {
            return 21  - n;
        }else {
           return (n-21) + (n-21);
        }      
    }
    
    
    public static void main(String[] args) {
       int diff =  diff21(19);
        System.out.println(diff);
    }
}
