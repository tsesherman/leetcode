import java.util.Stack;
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
        List<Stack<ListNode>> groupsToReverse = new ArrayList<>();
        List<ListNode> remainingNodes = new ArrayList<>();
        ListNode resultRootNode = null;
        if (head == null) {
            return null;
        }
        
        organizeDraftListNode(head, k, groupsToReverse, remainingNodes);
        
        List<Integer> values = orderValues(groupsToReverse, remainingNodes);
        ListNode lastNode = null;
        for (int i = values.size() - 1; i >= 0; i--) {
            ListNode node = new ListNode(values.get(i),lastNode);
            if (i == 0) {
                resultRootNode = node;
            }
            lastNode = node;
        }
        
        //printListNodes(resultRootNode);
        //printInts(values);
        //System.out.println("the groups: ");
        //printGroups(groupsToReverse);
        //printRemaining(remainingNodes);
        return resultRootNode;
    }
    
    private void organizeDraftListNode(
        ListNode head,
        int k,
        final List<Stack<ListNode>> groupsToReverse,
        final List<ListNode> remainingNodes) {
        Stack<ListNode> reversableListNodes = null;
        ListNode currentNode = head;
        int groupCount = 0;
        while (currentNode != null) {
            if (groupCount == 0) {
               reversableListNodes = new Stack<>();
            }
            remainingNodes.add(currentNode);
            reversableListNodes.push(currentNode);
            groupCount++;
            if (groupCount == k) {
                remainingNodes.clear();
                groupsToReverse.add(reversableListNodes);
                groupCount = 0;
            }
            currentNode = currentNode.next;
        }
    }
    
    private List<Integer> orderValues(List<Stack<ListNode>> groupsToReverse,
                                     List<ListNode> remainingNodes) {
        List<Integer> values = new ArrayList<>();
        for (Stack<ListNode> group : groupsToReverse) {
            ListNode currentNode = null;
            while (!group.empty()) {
                currentNode = group.pop();
                values.add(currentNode.val);
            }
        }
        for (ListNode remainingNode : remainingNodes) {
            values.add(remainingNode.val);
        }
        return values;
    }
    
    private void printInts(List<Integer> ints) {
        for (Integer i : ints) {
            System.out.println(i);
        }
    }
    
    private void printGroups(List<Stack<ListNode>> groups) {
        for (Stack<ListNode> group : groups) {
            printGroup(group);
        }
    }
    
    private void printRemaining(List<ListNode> remaining) {
        System.out.println("remaining");
        for (ListNode node : remaining) {
            System.out.println(node.val);
        }
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