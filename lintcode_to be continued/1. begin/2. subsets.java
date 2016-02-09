class Solution{
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
    	if(nums == null || nums.length == 0)
    		return new ArrayList<ArrayList<Integer>>();

    	Arrays.sort(nums);

    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	res.add(new ArrayList<Integer>());

    	for(int i : nums){
    		ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();
    		for(ArrayList<Integer> sub : res){
    			ArrayList<Integer> s = new ArrayList<Integer>(sub);
    			s.add(i);
    			tmp.add(s);
    		}
    		res.addAll(tmp);
    	}
    	return res;
	}
}