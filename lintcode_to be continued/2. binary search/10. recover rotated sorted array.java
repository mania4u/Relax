public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        // 下面这种reverse方式，在链表里也会经常使用到
        // 有关排序数组的reverse，下面的方法可以算是一个模版
        for(int i = 0; i < nums.size() - 1; i++){
            if(nums.get(i) > nums.get(i + 1)){
                reverse(nums, 0, i);
                reverse(nums, i + 1, nums.size() - 1);
                reverse(nums, 0, nums.size() - 1);
                return;
            }
        }
    }
    
    private void reverse(ArrayList<Integer> nums, int start, int end){
        for(int i = start, j = end; j > i; i++, j--){
            int tmp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, tmp);
        }
    }
}