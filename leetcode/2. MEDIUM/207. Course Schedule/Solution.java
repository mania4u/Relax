/*
	这道选课题的实质就是拓扑排序，判断是否图内有环。
	当图内存在环，必然会有死循环，那什么情况下不会有环呢？
	拓扑就是通过剥离一个个入度为0，
	用来查看剩下的点里面是否还存在入度为0的顶点
	如果能将所有顶点剥离则说明，则说明此图满足拓扑排序
	可以参考：http://blog.csdn.net/lisonglisonglisong/article/details/45543451
*/
public class Solution{
	public class Digraph{
		private int v, e;
		private List<Integer>[] adj;
		private int[] indegree;		// 每个顶点的入度
		private Queue<Integer> q;

		public Digraph(int n, int[][] edges){
			v = n;
			e = edges.length;
			adj = (List<Integer>[]) new List[v];	
			// 注意这里的初始化写法，里面的Integer作为后续的index
			for(int i = 0; i < v; i++)
				adj[i] = new ArrayList<Integer>();
			indegree = new int[v];
			for(int i = 0; i < e; i++){
				int a = edges[i][1];
				int b = edges[i][0];
				adj[a].add(b);	// 这里说明edge a->b
				indegree[b]++;
				// 每出现[b, a]，说明b是终点，也就是b的入度+1
			}
		}

		public boolean hasTopologicalOrder(){
			q = new LinkedList<Integer>();
			for(int i = 0; i < v; i++)
				if(indegree[i] == 0)	
				// 添加所有入度为0的定点
					q.add(i);
			int count = 0;	// 从队列q中提取出顶点次数
			while(!q.isEmpty()){
				int a = q.poll();
				count++;
				for(int b : adj[a]){
					if(--indegree[b] == 0)	
					// --indegree[b]表示此时入度为1，将要变成入度为0的顶点
					// 这个顶点就是将先前入度为0的顶点去除后，新添加的入度为0的点
						q.add(b);	// 由于入度为0，所以需要重新放到队列q中
					// 也是从这里可以看出，这个方法并不是遍历到底的DFS，而是BFS
				}
			}
			if(count < v) return false;
			else return true;	// 如果所有保存在队列q的顶点都被取出，则满足拓扑
		}
	}

	public boolean canFinish(int numCourses, int[][] prerequisites){
		Digraph g = new Digraph(numCourses, prerequisites);
		return g.hasTopologicalOrder();
	}
}