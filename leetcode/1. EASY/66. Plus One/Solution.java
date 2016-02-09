/*
	略脑筋急转弯的题目，for循环没什么好说的。
	因为for循环到"9999"这样的格式就中止，如果此时return digits，那应该返回的是"0000"
	此时for循环中止并跳出，由于只是"plus one"，所以如果之前digits是"9999"，那res必定是"10000"
	这边所以直接新建一个res数组并返回即可
*/

public class Solution{
	public int[] plusOne(int[] digits){
		for(int i = digits.length - 1; i >= 0; i--){
			if(digits[i] == 9){
			    digits[i] = 0;
			}else{
			    digits[i]++;
			    return digits;
			}
		}
		int[] res = new int[digits.length + 1];
		res[0] = 1;
		return res;
	}
}