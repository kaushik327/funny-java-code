import java.util.*;

public class SortInsertion {
	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);

		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = console.nextInt();
		}

		System.out.println("insertionSort");
		System.out.println(Arrays.toString(arr));

		for (int i = 1; i < 10; i++) {
			int n = arr[i];

			for (int j = i - 1; j >= 0 && arr[j] > n; j--) {
				arr[j+1] = arr[j];
				arr[j] = n;
			}
			System.out.println(Arrays.toString(arr));
		}

		System.out.println();
	}
}