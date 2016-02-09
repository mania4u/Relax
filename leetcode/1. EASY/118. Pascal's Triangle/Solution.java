public class Solution{
	public List<List<Integer>> generate(int numRows){
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		if(numRows <= 0){
			return triangle;
		}
		for(int i = 0; i < numRows; i++){
			List<Integer> row = new ArrayList<Integer>();
			for(int j = 0; j < i + 1; j++){
				if(j == 0 || j == i){		// add "1" at the beginning and the ending of array
					row.add(1);
				}else{
					row.add(triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j));		// add the previous level elements together
				}
			}
			triangle.add(row);
		}
		return triangle;
	}
}