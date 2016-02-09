// 递归方法

public class Solution{
	public int reverseBits(int n){
		int i = 0, res = 0;
		while(i < 32){
			res = (res << 1) + ((n >> i) & 1);
			i++;
		}
		return res;
	}
}