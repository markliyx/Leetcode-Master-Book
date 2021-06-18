/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        queue.add(dummy);
        while (!(queue.isEmpty())) {
            int num = queue.size();
            LinkedList<Integer> list = new LinkedList<Integer>();
            for (int i = 0; i < num; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                    list.add(node.left.val);
                }
                
                if (node.right != null){
                    queue.add(node.right);
                    list.add(node.right.val);
                }
            }
            if (!(list.isEmpty())) {
                res.add(list);
            }
        }
        return res;
    }
}

/*
102. Binary Tree Level Order Traversal
Medium

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
*/