import java.util.*;

public class SortSelection {
	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			nums.add(console.nextInt());
		}
		System.out.println("selectionSort");

		System.out.println(nums.toString());
		for (int i = 0; i < 9; i++) {
			List<Integer> sublist = nums.subList(i, 10);
			int min = Collections.min(sublist);
			int min_index = sublist.indexOf(min) + i;
			Collections.swap(nums, i, min_index);
			System.out.println(nums.toString());
		}		
		System.out.println();
	}
}