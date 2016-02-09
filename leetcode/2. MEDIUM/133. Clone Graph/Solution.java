public class Solution{
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode root){
		if(root == null) return null;
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		map.put(root, new UndirectedGraphNode(root.label));
		helper(root, map);
		return map.get(root);
	}

	public void helper(UndirectedGraphNode root, Map<UndirectedGraphNode, UndirectedGraphNode> map){
		for(UndirectedGraphNode neighbor : root.neighbors){
			if(!map.containsKey(neighbor)){
				map.put(neighbor, new UndirectedGraphNode(neighbor.label));
				helper(neighbor, map);
			}
			map.get(root).neighbors.add(map.get(neighbor));
		}
	}
}