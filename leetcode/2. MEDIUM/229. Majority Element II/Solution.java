/*
	又是一个非常牛逼的算法，首先要搞清楚最多可能产生几个要求的值
	注意"more than n/3(下限) times"，其实也就是大于等于n/3(上限)，最多只可能有两个
	所以下面的循环里只定义了两个变量，n1,n2用来表示次数最多的两个数,c1,c2用来存储两者的次数
	当出现第三个不同的值的时候，将之前最多次数的两个数所记录的次数递减，其实就是抵消

*/
public class Solution{
	public List<Integer> majorityElement(int[] nums){
		List<Integer> res = new ArrayList<Integer>();
		if(nums == null) return res;

		int n1 = 0, n2 = 0;
		int c1 = 0, c2 = 0;
		for(int i = 0; i < nums.length; i++){
			int n3 = nums[i];
			if(c1 > 0 && c2 > 0){
				if(n3 != n1 && n3 != n2){
					c1--;
					c2--;
				}else if(n3 == n1){
					c1++;
				}else{ 
					c2++;
				}
			}else if(c1 > 0){
				if(n3 == n1){
					c1++;
				}else{
					n2 = n3;
					c2++;
				}
			}else if(c2 > 0){
				if(n3 == n2){
					c2++;
				}else{
					n1 = n3;
					c1++;
				}
			}else{
				n1 = n3;
				c1++;
			}
		}
		c1 = c2 = 0;
		// 此处因为已经找到频率最高的两个数，所以先清理这两个数对应的次数，重新记数
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == n1){
				c1++;
			}else if(nums[i] == n2){
				c2++;
			}
		}
		if(c1 > nums.length / 3){
		// 可能存在次数最高但达不到nums.length/3的情况，所以需要再判断
			res.add(n1);
		}
		if(c2 > nums.length / 3){
			res.add(n2);
		}
		return res;
	}
}