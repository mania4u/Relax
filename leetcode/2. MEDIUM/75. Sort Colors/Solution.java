// �ǳ�����ķ���������Ҫ����ÿ���һ�α�����
public class Solution{
	public void sortColors(int[] nums){
		int zeroPosition = 0;
		int onePosition = 0;
		int twoPosition = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == 2){
				nums[twoPosition++] = 2;
			}else if(nums[i] == 1){
				nums[twoPosition++] = 2;
				nums[onePosition++] = 1;
			}else{
				nums[twoPosition++] = 2;
				nums[onePosition++] = 1;
				nums[zeroPosition++] = 0;
			}
		}
	}
}