import java.util.*;

public class SortBubble {
	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		int[] nums = new int[10];
		for (int i = 0; i < 10; i++) {
			nums[i] = console.nextInt();
		}
		System.out.println("bubbleSort");
		System.out.println(Arrays.toString(nums));
		for (int i = 9; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (nums[j] > nums[j+1]) {
					nums = swap(nums, j, j+1);
				}
			}
			System.out.println(Arrays.toString(nums));
		}
		System.out.println();
	}

	public static int[] swap(int[] arr, int a, int b) {
		int temp = arr[b];
		arr[b] = arr[a];
		arr[a] = temp;
		return arr;
	}
}