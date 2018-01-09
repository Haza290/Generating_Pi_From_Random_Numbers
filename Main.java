import java.math.BigInteger;
import java.util.Random;


public class Main {
	
	int ITERATION_LIMIT = 1000000;
	
	int iterationCount;
	int coprimeCount;

	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		iterationCount = 0;
		coprimeCount = 0;
		Random rand = new Random();
		
		// Each loop generates 2 random ints, checks if they are coprime, then increments the coprime counter if needed.
		while (iterationCount < ITERATION_LIMIT) {
			iterationCount ++;
			
			int x = rand.nextInt(Integer.MAX_VALUE);
			int y = rand.nextInt(Integer.MAX_VALUE);
			
			if(areCoprime(x,y)) {
				coprimeCount ++;
			}
		}
		
		// Works out Pi using the percentage of coprimes generated
		double coprimePercentage = (double) coprimeCount / ITERATION_LIMIT;
		double piApprox = Math.sqrt((6 / coprimePercentage));
		double percentageOff = ((piApprox - Math.PI) / Math.PI) * 100;
		
		// Prints out results
		System.out.println("Pi is approximately: " + piApprox + " Off by: " + percentageOff + "%");
		System.out.println("Pi is              : " + Math.PI);
	}
	
	/**
	 * Finds out if 2 ints are co prime by checking there Greatest Common Divisor and if it is 1 it means they are co prime
	 */
	private boolean areCoprime(int x, int y) {
		BigInteger bigX = BigInteger.valueOf(x);
		BigInteger bigY = BigInteger.valueOf(y);
		BigInteger gcd = bigX.gcd(bigY);
		
		// if 2 ints gcd is 1 then they are co prime
		if(gcd.intValue() == 1) {
			return true;
		} else {
			return false;
		}
	}
}
