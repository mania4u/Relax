/*
	Time complexity: O(N), memory: O(N)
	利用hashset的contains()方法，缺点是比较占空间
*/

public class Solution{
	public boolean containsDuplicate(int[] nums){
		final Set<Integer> distinct = new HashSet<Integer>();
		for(int num : nums){
			if(distinct.contains(num)){
				return true;
			}
			distinct.add(num);
		}
		return false;
	}
}