public class Solution{
	public int searchInsert(int[] A, int target){
		int low = 0, high = A.length - 1;
		while(low <= high){
			int mid = low + (high - low) / 2;	// 避免overflow
			if(A[mid] == target) return mid;
			else if(A[mid] > target) high = mid - 1;
			else low = mid + 1;
		}
		return low;
	}
}