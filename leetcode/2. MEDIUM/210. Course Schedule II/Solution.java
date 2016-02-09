/*
	和courses schedule的代码总体结构一样，只需要多定义一个输出的数组
	由入度为0的顶点（也就是没有前置课程的课）开始，逐一放到order数组
*/

public class Solution{
	public class Digraph{
		private int v, e;
		private List<Integer>[] adj;
		private int[] indegree;
		private Queue<Integer> q;

		public Digraph(int n, int[][] edges){
			v = n;
			e = edges.length;
			adj = (List<Integer>[]) new List[v];
			for(int i = 0; i < v; i++)
				adj[i] = new ArrayList<Integer>();
			indegree = new int[v];
			for(int i = 0; i < e; i++){
				int a = edges[i][1];
				int b = edges[i][0];
				adj[a].add(b);
				indegree[b]++;
			}
		}

		public int[] topologicalOrder(){
			q = new LinkedList<Integer>();
			for(int i = 0; i < v; i++)
				if(indegree[i] == 0)
					q.add(i);

			int count = 0;
			int[] order = new int[v];
			while(!q.isEmpty()){
				int a = q.poll();
				order[count++] = a;
				for(int b : adj[a])
					if(--indegree[b] == 0)
						q.add(b);
			}
			if(count < v) return new int[0];
			else return order;
		}
	}

	public int[] findOrder(int numCourses, int[][] prerequisites){
		Digraph g = new Digraph(numCourses, prerequisites);
		return g.topologicalOrder();
	}
}