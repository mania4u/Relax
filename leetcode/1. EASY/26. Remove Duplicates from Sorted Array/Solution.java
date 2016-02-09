import java.util.*;

public class Solution {
	public int removeDuplicates(int[] A) {
		HashSet<Integer> set = new HashSet<Integer>();
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (!set.contains(A[i])) {
				set.add(A[i]);
				A[count++] = A[i];
			}
		}
		return count;
	}
}