package warmup.staticmembers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BeerInStock shows how many beers you bought 
 * and beersDrankCount shows how many beers you have drunk
 * @author Ramona
 */
public class BeerCounter {

    // how many beers you bought 
    private static int beerInStock;

    // how many beers you have drunk
    private static int beersDrankCount;

    // add beers to the beers in stock
    private static int buyBeer(int bottlesCount) {
        int beersInStock = BeerCounter.beerInStock += bottlesCount;
        return beersInStock;
    }

    // add beers to the drunk beers counter and subtract beers in stock 
    private static int drinkBeer(int bottlesCount) {
        int beersDrankCount = BeerCounter.beersDrankCount += bottlesCount;
        int beersInStock   = BeerCounter.beerInStock -= bottlesCount;
        
        return beersDrankCount;
    }
    
    public static void beerCounter(String input) {
        String[] splitted = input.split(" ");
        int beersBye = Integer.parseInt(splitted[0]);
        int beersDrink = Integer.parseInt(splitted[1]);

        BeerCounter.buyBeer(beersBye);
        BeerCounter.drinkBeer(beersDrink);

    }
  

    public static void main(String[] args) {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        
        // On every input line you will get pair of beers you bought
        // and beers you drank, until you receive command "End" 
        try {
            while (!(input = bReader.readLine()).equals("End")) {
                BeerCounter.beerCounter(input);
            }
        } catch (IOException ioex) {
            System.out.println("I/O Exception:  " + ioex.getMessage());
        }
        
        // Print beersInStock and beersDrankCount separated by 1 space
        System.out.println(BeerCounter.beerInStock + " " + BeerCounter.beersDrankCount);
    }
}

