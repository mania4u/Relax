/*
	上面调用递归的部分没什么好说的。重点在于levelMaker这个方法。
	注意声明的时候的三个参数，表套表list，结点node，整型level。list用来返回最后所需要输出的结果，level用来表示递归了几层。
	由于level从0开始，而此时list并没有东西添加，于是便new了一个新的链表。
	于是递归左结点和右结点，并且层数+1.
	注意，list()得到的并非单个的元素，而是内层每一level用于记录元素的list。list.size()树一共有多少层，也就是有多少个内层表。
	很显然list.size()永远大于等于level。这边又有一个非常重要的点，list添加元素不需要事先定义个数。
	list.get(list.size()-level-1)表示的是第list.size()-level-1个内层表里添加根节点，很显然这个内层表的输出是倒序的。
	此时再递归的时候，注意，list新增添了内容，是这一层
*/
public class Solution{
	public List<List<Integer>> levelOrderBottom(TreeNode root){
		List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
		levelMaker(wrapList, root, 0);
		return wrapList;
	}

	public void levelMaker(List<List<Integer>> list, TreeNode root, int level){
		if(root == null) return;	// stop the recursion
		if(level == list.size()){		
			list.add(0, new LinkedList<Integer>());
		}
		levelMaker(list, root.left, level+1);
		levelMaker(list, root.right, level+1);
		list.get(list.size()-level-1).add(root.val);	
	}
}