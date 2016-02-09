/*
	这个算法基于快速排序，复杂度O(n)，难点在于理解i和m这两个标记的意义
	i用来标记第一个比nums[j]大的数，m用来标记快排里最左用来参考的nums[0]
	nums[0]和parti意义是不一样的，parti是作为最初参考值，这个值是不能变的
	之所以需要m是因为由于swap()方法后，nums[0]的值已经改变，
	所以需要一个flag来标记最初的参考值nums[0]
*/
public class Solution{
	public int findKthLargest(int[] nums, int k){
		return findK(nums, nums.length - k, 0, nums.length - 1);
	}

	private int findK(int[] nums, int k, int start, int end){
		int parti = nums[start], i = start, m = start;
		for(int j = start + 1; j <= end; j++){
			if(nums[j] > parti)
				continue;
			if(nums[j] <= parti){
				swap(nums, ++i, j);
				if(nums[j] != parti)
					swap(nums, m++, i);
			}
		}
		if(k >= m && k <= i)
			return nums[k];
		else if(k < m)
			return findK(nums, k, start, m - 1);
		else 
			return findK(nums, k, i + 1, end);
	}

	private void swap(int[] nums, int a, int b){
		if(a == b) return;
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}