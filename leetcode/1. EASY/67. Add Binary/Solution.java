public class Solution{
	public String addBinary(String a, String b){
		int carry = 0;
		StringBuilder res = new StringBuilder();
		char aNum[] = a.toCharArray();	// output in array
		char bNum[] = b.toCharArray();	// output in array
		for(int i = aNum.length - 1, j = bNum.length - 1; i >= 0 || j >= 0; i--, j--){
			// judge the digit if it is empty. output '1' and '0'
			int aTmp = i >= 0 ? aNum[i] == '1' ? 1 : 0 : 0;
			// judge the digit if it is empty. output '1' and '0'
			int bTmp = j >= 0 ? bNum[j] == '1' ? 1 : 0 : 0;
			int val = (aTmp + bTmp + carry) % 2;	// digit calculation
			carry = (aTmp + bTmp + carry) / 2;		// carry calculation
			res.append((char)(val + '0'));		// ASCII code: int + '0' = char
		}
		if(carry == 1)		// the overflow situation
			res.append((char)(carry + '0'));
		return res.reverse().toString();	// the result is from right to left, but the left to right one is the answer
	}
}