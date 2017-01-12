package warmup;

/**
 * We have a loud talking parrot.
 * The "hour" parameter is the current hour time in the range 0..23.
 * We are in trouble if the parrot is talking and the hour is before 7
 * or after 20. Return true if we are in trouble.
 * 
 * @author Ramona
 */
public class ParrotTrouble {
    
    public static boolean parrotTrouble(boolean talking, int hour) {
        return (talking && (hour < 7 || hour >20));
    }
    
    public static void main(String[] args) {
        boolean result = parrotTrouble(true, 6);
        
        System.out.println(result);
    }
}
