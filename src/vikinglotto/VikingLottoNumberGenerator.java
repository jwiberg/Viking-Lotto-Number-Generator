package vikinglotto;
import java.util.Arrays;
import java.util.Random;


public class VikingLottoNumberGenerator {
	public int[] generate(int amountOfNumbers) {
		int[] n = new int[amountOfNumbers];
		Random r = new Random();
		while (amountOfNumbers > 0) {
			int nn = r.nextInt(48) + 1;
			if (Arrays.binarySearch(n, nn) < 0) {
				n[--amountOfNumbers] = nn;
				Arrays.sort(n);
			}
		}
		return n;
	}
}
