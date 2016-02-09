/*
	这道题用的是相互抵消的概念，只要相互能抵消就说明数字相互之间数量至少是相等级以下的，后面多出来的数字就记在count上。
	题目中more than [n/2]这个条件看清，6个数字就需要4个才能算element，5个数字则需要3个才能算
*/

public class Solution{
	public int majorityElement(int[] num){
		int major = num[0], count = 1;
		for(int i = 1; i < num.length; i++){
			if(count == 0){
				count++;
				major = num[i];
			}else if(major == num[i]){
				count++;
			}else count--;
		}
		return major;
	}
}