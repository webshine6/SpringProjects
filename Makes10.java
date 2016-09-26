package warmup;

/**
 *
 * @author Ramona
 */
public class Makes10 {
    
    public static boolean makes10(int a, int b) {
        return (a == 10 || b == 10 || a+b==10);
    }
    
    
    public static void main(String[] args) {
       boolean result = makes10(9, 1);
        System.out.println(result);
    }
    
}
