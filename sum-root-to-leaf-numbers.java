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
    public int sumNumbers(TreeNode root) {
        List<Integer> numbers = doGetNumbers(null,root, "");
        int sum = 0;
        for (Integer num : numbers) {
            sum += num;
        }
        return sum;
    }
    
    private List<Integer> doGetNumbers(TreeNode parent, TreeNode node, String numStr) {
        List<Integer> result = new ArrayList<>();
        if (node.left == null && node.right == null) {
            result.add(Integer.parseInt(numStr + Integer.toString(node.val)));
            return result;
        }
        if (node.left != null) {
            result.addAll(doGetNumbers(node, node.left, 
                numStr + Integer.toString(node.val)));
        }
        if (node.right != null) {
            result.addAll(doGetNumbers(node, node.right, 
                numStr + Integer.toString(node.val)));
        }
        if (parent == null) {
            printNumbers(result);
        }
        return result;
    }
    
    private void printNumbers(List<Integer> numbers) {
        for (Integer num : numbers) {
            System.out.println(num);
        }
    }
 
}