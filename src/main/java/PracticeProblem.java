public class PracticeProblem {
	
	public static void main(String args[]) {
	}
	// Question 1
	public static int[] bubbleSort(double[] nums) {
		int swaps = 0; // for swap count
		int steps = 0; // for iterations count
		
		boolean swapped = true;

		for (int i = 0; i < nums.length && swapped; i++){
			swapped = false; 
			for (int j = 0; j < nums.length - i - 1; j++){
				if (nums[j] > nums [j + 1]){
					double temp = nums [j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
					swaps+= 3;
					swapped = true;
				}
				steps++;
			}
			if (!swapped){
				//i = nums.length;
				break;
			}
		}
		return new int[] {swaps, steps}; 
	}
	public static int[] selectionSort(double[] nums) {

		int swaps = 0; // for swap count
		int steps = 0; // for iterations count

		for (int i = 0; i < nums.length - 1; i++){
			int minIndex = i;
			for (int j = i+1; j < nums.length; j++){
				if (nums[j] < nums[minIndex]) {
					minIndex = j;
					swaps++;
				}
				steps++;
			}
				double temp = nums[i];
				nums[i] = nums [minIndex];
				nums [minIndex] = temp;
				swaps += 3;
		}
		return new int[] {swaps, steps}; 
	}
	public static int[] insertionSort(double[] nums) {

		int swaps = 0; // for swap count
		int steps = 0; // for iterations count

		for (int i = 1; i < nums.length; i++){
			double key = nums[i];
			int j = i - 1;
			swaps++;
			while (j >= 0 && key < nums[j]) {
				steps++;
				nums [j + 1] = nums [j];
				swaps++;
				j--;
			}
			nums[j + 1] = key;
			swaps++; 
 		}
		return new int[] {swaps, steps}; 
	}
	// Question 2
	public static String leastSwaps(double[] nums) {
		double[] nums1 = new double[nums.length];
		double[] nums2 = new double[nums.length];
		double[] nums3 = new double[nums.length];

		for(int i = 0; i < nums.length; i++){
			nums1[i] = nums[i];
			nums2[i] = nums[i];
			nums3[i] = nums[i];
		}

		int [] bubbleSwaps = bubbleSort(nums1);
		int [] selectionSwaps = selectionSort(nums2);
		int [] insertionSwaps = insertionSort(nums3);

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
		double[] nums1 = new double[nums.length];
		double[] nums2 = new double[nums.length];
		double[] nums3 = new double[nums.length];

		for(int i = 0; i < nums.length; i++){
			nums1[i] = nums[i];
			nums2[i] = nums[i];
			nums3[i] = nums[i];
		}

		int [] bubbleSteps = bubbleSort(nums1);
		int [] selectionSteps = selectionSort(nums2);
		int [] insertionSteps = insertionSort(nums3);

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
