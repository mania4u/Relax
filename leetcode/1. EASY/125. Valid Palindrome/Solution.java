public class ValidPalindrome {
	public boolean isPalindrome(String s) {

		if (s == null)
			return false;
		char[] chars = s.toCharArray();
		int i = 0;
		int j = s.length() - 1;

		while (i < j) {
			while (i < s.length() - 1 && !isAlphaandNum(chars[i]))		// 若不是字母和数字，往后找
				i++;
			char left = chars[i];
			while (j > 0 && !isAlphaandNum(chars[j]))					// 若不是字母和数字，往前找
				j--;
			char right = chars[j];

			if (i >= j)
				break;

			if (!isSame(left, right))
				return false;
			i++;	// 这里的i++和j--是char是字母或者数字的时候继续找的表示，上面的i++和j--是跳过非字母和数字的字符的意思
			j--;
		}
		return true;
	}

	public boolean isAlphaandNum(char a) {
		if ((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z') || a >= '0' && a <= '9')
			return true;
		return false;
	}

	public boolean isSame(char a, char b) {
		if (Character.toLowerCase(a) == Character.toLowerCase(b) || a == b)
			return true;
		return false;
	}
}