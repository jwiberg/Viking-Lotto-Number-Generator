import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class VikinLottoTester {

	@Test
	public void generateRightAmountOfNumbers() {
		VikingLottoNumberGenerator generator = new VikingLottoNumberGenerator();
		assertEquals(18, generator.generate(18).length);
	}

	@Test
	public void returnedArrayIsSorted() {
		VikingLottoNumberGenerator generator = new VikingLottoNumberGenerator();
		int[] numbers = generator.generate(18);
		int[] numbersCopy = Arrays.copyOf(numbers, 18);
		Arrays.sort(numbersCopy);
		assertArrayEquals(numbers, numbersCopy);
	}

	@Test
	public void returnedArrayContainsOnlyDifferentNumbers() {
		for (int j = 0; j < 100; j++) {
			List<Integer> checked = new ArrayList<Integer>();
			VikingLottoNumberGenerator generator = new VikingLottoNumberGenerator();
			int[] numbers = generator.generate(48);
			for (int i = 0; i < 48; i++) {
				if (checked.contains(numbers[i])) {
					System.out.println(Arrays.toString(numbers));
					fail();
				}
				checked.add(numbers[i]);
			}
		}
	}
}
