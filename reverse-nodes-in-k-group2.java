/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = null;
        Stack<ListNode> nodeStack = new Stack<>();
        ListNode nd = head;
        while (nd != null) {
            nodeStack.push(nd);
            nd = nd.next;
        }
        
        int numRemainingItems = nodeStack.size() % k;
        int remainItemCount = 0;
        ListNode remainingNode = null;
        while (remainItemCount < numRemainingItems) {
            ListNode currRemainingNode = nodeStack.pop();
            remainingNode = new ListNode(currRemainingNode.val, remainingNode);
            remainItemCount++;
        }
        
        result = remainingNode;
        
        while (nodeStack.size() > 0) {
            result = reverseNodes(result, nodeStack, k);
        }
        
        return result;
    }
    
    private ListNode reverseNodes(ListNode workingResult, Stack<ListNode> nodeStack, int k) {
        Stack<ListNode> reversedNodes = new Stack<>();
        int reverseNodeCount = 0;
        while (reverseNodeCount < k) {
            ListNode node = nodeStack.pop();
            reversedNodes.push(node);
            reverseNodeCount++;
        }
        
        while (reversedNodes.size() > 0) {
            ListNode reversedNode = reversedNodes.pop();
            workingResult = new ListNode(reversedNode.val, workingResult);
        }
        
        return workingResult;
    }
    
    private void printGroup(Stack<ListNode> group) {
        Stack<ListNode> printGroup = (Stack<ListNode>)group.clone();
        int count = 0;
        System.out.println("[");
        while (!printGroup.empty()) {
            if (count > 0) {
                System.out.println(",");
            }
            System.out.println(printGroup.pop().val);
        }
        System.out.println("]");
    }
    
    private void printListNodes(ListNode root) {
        ListNode currentNode = root;
        while (currentNode != null) {
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
    }


}