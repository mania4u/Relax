/*
	利用TreeSet的值插入进去，默认进行升序排序的特点
	floor()表示以nums[ind]+t为底，也就是小于nums[ind]+t里值里最大的那个数
	ceiling()表示以nums[ind]-t为顶，也就是大于num[ind]-t里值里最小的那个数
	复杂度为nlogk，logk是因为整棵树高度为k，进行二叉查找
*/
public class Solution{
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t){
		if(nums == null || nums.length == 0)
			return false;

		final TreeSet<Integer> values = new TreeSet<>();
		for(int ind = 0; ind < nums.length; ind++){
			Integer floor = values.floor(nums[ind] + t);
			Integer ceil = values.ceiling(nums[ind] - t);
			if((floor != null && floor >= nums[ind]) 
			|| (ceil != null && ceil <= nums[ind])){
			// 内层括号里第一个条件用来判断是否存在floor和ceil
			// 内层括号里第二个条件，式子变形floor-nums[ind]>=0，ceil-nums[ind]<=0
			// 至于为什么会存在floor和ceil两个值，是因为不仅需要考虑nums[i]-nums[j]还要考虑nums[j]-nums[i]
				return true;
			}
			values.add(nums[ind]);
			if(ind >= k)
			// 因为Indice之差已经不可能小于k，即移除
				values.remove(nums[ind - k]);
		}
		return false;
	}
}