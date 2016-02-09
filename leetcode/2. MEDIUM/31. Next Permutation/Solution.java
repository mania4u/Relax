/*
	非常神奇的算法：从右向左扫描，为的是找到两样东西：
	1. 最后一个升序的点
	2. 和第一个降序的位置相比，从已扫描部分找到第一个比这个降序点大的位置
	于是将降序点和这个在扫描部分第一个比降序点大的点进行互换，
	然后以升序点为基准的右半部分（即扫描部分进行排序），进行互换，
	这道题最巧妙的方法就是利用了从右向左是升序的特点来进行交换，
	因为这样能保证交换之后，肯定比原来的数大，且又是比原来数大的数里最小的那个，
	这是因为交换之后，扫描部分从最大变成最小
*/

public class Solution{
	public void nextPermutation(int[] num){
		if(num == null || num.length < 2) return;

		int i = num.length - 1;
		while(i > 0 && num[i] <= num[i - 1]) i--;
		if(i > 0){
			int j = num.length - 1;
			while(j >= 1 && num[j] <= num[i - 1]) j--;
			swap(num, i - 1, j);
		}
		sort(num, i);
	}

	public static void swap(int[] A, int i, int j){
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	public static void sort(int[] A, int i){
		int j = A.length - 1;
		while(i < j){
			swap(A, i++, j--);
		}
	}
}