import java.util.Random;

public class GarbageRecyclingApp {

	public static void main(String[] args) {

		int[] values = {5, 10, 15};
		Random rand = new Random();
		int randomIndex = rand.nextInt(values.length);
		int randomValue = values[randomIndex];
		System.out.println("Randomly selected value: " + randomValue);
	}

}
