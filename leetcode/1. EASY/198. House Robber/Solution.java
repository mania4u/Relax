// 推导公式就是比较n+(n-2)和n-1

public class Solution{
	public int rob(int[] nums) {
        int h1 = 0;
        int h2 = 0;
        for(int n : nums){
            int temp = h1;
            h1 = Math.max(h1, h2);
            h2 = n + temp;
        }
        return Math.max(h1, h2);
    }
}