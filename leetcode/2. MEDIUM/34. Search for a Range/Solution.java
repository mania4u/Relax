public class Solution{
	public int[] searchRange(int[] A, int target){
		int[] res = new int[2];
		res[0] = -1;
		res[1] = -1;
		helper(A, target, res, 0, A.length - 1);
		return res;
	}

	public void helper(int[] A, int target, int[] res, int start, int end){
		if(start > end) return;
		int mid = start + (end - start) / 2; 	// 避免overflow的写法
		// target正好在中间，这样就往两边延伸
		if(A[mid] == target){
			if(res[0] == -1 || res[0] > mid)
				res[0] = mid;
			if(res[1] == -1 || res[1] < mid)
				res[1] = mid;
			helper(A, target, res, start, mid - 1);
			helper(A, target, res, mid + 1, end);
		}
		// 中间的数字大于target，便在左侧递归寻找
		else if(A[mid] > target){
			helper(A, target, res, start, mid - 1);
		}
		// 中间的数字小于target，便在右侧递归寻找
		else{
			helper(A, target, res, mid + 1, end);
		}
	}
}