import java.util.*;
import java.lang.*;

public class SortMerge {
	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);

		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = console.nextInt();
		}

		System.out.println("mergeSort");
		System.out.println(Arrays.toString(arr));	
		System.out.println(Arrays.toString(sort(arr)));

	}

	public static int[] sort(int[] arr) {
	
		if (arr.length == 1) return arr;

		int m = arr.length / 2;

		int[] l_arr = Arrays.copyOfRange(arr, 0, m);
		int[] r_arr = Arrays.copyOfRange(arr, m, arr.length);

		return merge(sort(l_arr), sort(r_arr));

	}

	public static int[] merge(int[] l, int[] r) {


		int l_len = l.length;
		int r_len = r.length;

		if (l_len == 0) return r;
		if (r_len == 0) return l;

		int l_first = l[0];
		int r_first = r[0];

		int[] merged = new int[l_len + r_len];

		if (l_first < r_first) {	
			l = Arrays.copyOfRange(l, 1, l_len);
			merged[0] = l_first;
		} else {	
			r = Arrays.copyOfRange(r, 1, r_len);
			merged[0] = r_first;
		}

		System.arraycopy(merge(l, r), 0, merged, 1, l_len + r_len - 1);

		return merged;
	
	}
}