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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList();
        }
        int level = 0;
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        queue.add(root);
        while (!(queue.isEmpty())) {
            int size = queue.size();
            LinkedList list = new LinkedList<Integer>();
            for (int i = 0; i < size; i++) {
                if (level % 2 == 0) {
                    TreeNode first = queue.remove();
                    if (first.left != null) {
                        queue.add(first.left);
                    } 
                    
                    if (first.right != null) {
                        queue.add(first.right);
                    }
                    list.add(first.val);
                } else {
                    TreeNode last = queue.removeLast();
                    if (last.right != null) {
                        queue.addFirst(last.right);
                    }
                    if (last.left != null) {
                        queue.addFirst(last.left);
                    }
                    list.add(last.val);
                }
            }
            wrapList.add(list);
            level = level + 1;
        }
        return wrapList;
    }
}

/*
103. Binary Tree Zigzag Level Order Traversal
Medium

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
*/