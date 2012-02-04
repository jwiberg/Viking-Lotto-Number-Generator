package vikinglotto;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.junit.Before;
import org.junit.Test;

import vikinglotto.VikingLottoNumberGenerator;

public class VikingLottoTester {
	
	private VikingLottoNumberGenerator generator;
	
	@Before
	public void init() {
		generator = new VikingLottoNumberGenerator();
	}

	@Test
	public void generateRightAmountOfNumbers() {		
		assertEquals(18, generator.generate(18).length);
	}

	@Test
	public void returnedArrayIsSorted() {
		int[] numbers = generator.generate(18);
		int[] numbersCopy = Arrays.copyOf(numbers, 18);
		Arrays.sort(numbersCopy);
		assertArrayEquals(numbers, numbersCopy);
	}	
	
	@Test
	public void returnedArrayContainsOnlyDifferentNumbers() {
		for (int j = 0; j < 100; j++) {
			List<Integer> checked = new ArrayList<Integer>();
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
	
	@Test
	public void returnedArrayContainsNumberBetween1and48() {
		for (int j = 0; j < 1; j++) {
			List<Integer> checked = new ArrayList<Integer>();			
			int[] numbers = generator.generate(48);
			for (int i = 0; i < 48; i++) {
				if (numbers[i] < 1 || numbers[i] > 48) {
					System.out.println(Arrays.toString(numbers));
					fail();
				}
				checked.add(numbers[i]);
			}
		}
	}	
}