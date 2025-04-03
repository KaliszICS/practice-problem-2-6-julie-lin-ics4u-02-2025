import java.util.Arrays;

public class PracticeProblem {
	
	public static void main(String args[]) {

	}
	// Question 1
	public static int[] bubbleSort(double[] nums) {
		double [] arr = Arrays.copyOf(nums, nums.length); // to copy the array
		int swaps = 0; // for swap count
		int steps = 0; // for iterations count
		
		boolean swapped = true;

		for (int i = 0; i < arr.length - 1 && swapped; i++){
			swapped = false; 
			for (int j = 0; j < arr.length - i - 1; j++){
				steps++;
				if (arr[j] > arr [j + 1]){
					double temp = arr [j];
					arr[j] = arr [j + 1];
					arr[j + 1] = temp;
					swaps+= 3;
					swapped = true;
				}
			}
			if (!swapped){
				i = arr.length;
			}
		}
		return new int[] {swaps, steps}; 
	}
	public static int[] selectionSort(double[] nums) {
		double [] arr = Arrays.copyOf(nums, nums.length);

		int swaps = 0; // for swap count
		int steps = 0; // for iterations count

		for (int i = 1; i < arr.length; i++){
			int minIndex = i;
			for (int j = 0; j < arr.length; j++){
				steps++;
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			
				double temp = arr[j];
				arr[j] = arr [j + 1];
				arr [j + 1] = temp;
				swaps += 3;
			}
		}
		return new int[] {swaps, steps}; 
	}
	public static int[] insertionSort(double[] nums) {
		double [] arr = Arrays.copyOf(nums, nums.length);

		int swaps = 0; // for swap count
		int steps = 0; // for iterations count

		for (int i = 1; i < arr.length; i++){
			double key = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > key) {
				steps++;
				arr [j + 1] = arr [j];
				swaps++;
				j--;
			}
			arr[j + 1] = key;
			swaps++; 
 		}
		return new int[] {swaps, steps}; 
	}
	// Question 2
	public static String leastSwaps(double[] nums) {
		int [] bubbleSwaps = bubbleSort(nums);
		int [] selectionSwaps = selectionSort(nums);
		int [] insertionSwaps = insertionSort(nums);

		int minSwaps = Math.min(bubbleSwaps[0], Math.min(selectionSwaps[0], insertionSwaps[0]));
		
		if (bubbleSwaps[0] == minSwaps){
			return "Bubble";
		}
		else if (insertionSwaps[0] == minSwaps) {
			return "Insertion";
		}
		else {
			return "Selection";
		}
		
	}
	// Question 3
	public static String leastIterations(double[] nums) {
		int [] bubbleSteps = bubbleSort(nums);
		int [] selectionSteps = selectionSort(nums);
		int [] insertionSteps = insertionSort(nums);

		int minSteps = Math.min(bubbleSteps[1], Math.min(selectionSteps[1], insertionSteps[1]));
		
		if (bubbleSteps[1] == minSteps){
			return "Bubble";
		}
		else if (insertionSteps[1] == minSteps) {
			return "Insertion";
		}
		else {
			return "Selection";
		}
	}
}
