import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* Task 2:
 * Create a virtual collection of primes. 
 * Use lazy evaluation to only compute the numbers when they are needed.
*/

public class SetOfPrimes {
	final List<Integer> primes;
	
	// Constructor
	public SetOfPrimes() {
		primes = new ArrayList<Integer>();
	}
	
	// Return i-th prime
	public Integer get (Integer i) {
		int num;
		if(primes.isEmpty()) {
			primes.add(2);
		}
		num = primes.get(primes.size()-1);
		
		// If we do not have enough primes yet, create them
		while (primes.size() < i + 1) {
	        if (isPrime(num, primes))
	            primes.add(num);
	        num++;
	    }
		
		return primes.get(i);
	}
	
	private boolean isPrime(final int num, final List<Integer> primes) {
	    for (int prime : primes)
	        if (num % prime == 0)
	            return false;
	    return true;
	}

	
	// returns an iterator over the primes. The n-th call to
	// the iterator's next() method returns and Integer value
	// containing the n-th largest prime. 
	public Iterator<Integer> iterator(){
        final Integer[] current = {2};
		Iterator<Integer> iterator = new Iterator<Integer>() {
			@Override
			public boolean hasNext(){
				return true;
			}

			@Override
			public Integer next() {
			    while(hasNext()){
			        current[0]++;
			        if(isPrime(current)){
                        if (!primes.contains(current[0])) {
                            primes.add(current[0]);
                        }
                        return current[0];
                    }
                }
                throw new NoSuchElementException();
			}
            private boolean isPrime(Integer[] a) {
                if(a[0]<2) return false;
                for(int i = 2; i < a[0]; i++) if((a[0]%i)==0) return false;
                return true;
            }
		};
		return iterator;
	}

	public static void main(String[] args) {
		SetOfPrimes virtualPrimes = new SetOfPrimes();
		System.out.println(virtualPrimes.get(99));
		Iterator<Integer> it = virtualPrimes.iterator();
		Integer currentPrime = virtualPrimes.get(0);
		Integer maxPrime = 30;
		while (currentPrime < maxPrime) {
			System.out.println("The next prime is: " + currentPrime);
            currentPrime = it.next();
			} 
		
	} 
}
