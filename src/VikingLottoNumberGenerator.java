import java.util.Arrays;
import java.util.Random;


public class VikingLottoNumberGenerator {

	public int[] generate(int amount) {
		int[] n = new int[amount];
		Random r = new Random();
		while(amount > 0) {		
			int nn = r.nextInt(49) + 1;
			if(Arrays.binarySearch(n, nn) < 0) {
				n[--amount] = nn;
				Arrays.sort(n);
			}
		}		
		return n;
	}
	
}
