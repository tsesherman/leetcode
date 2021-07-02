# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        currNode = head
        nodeStack = []
        result: ListNode = None
        while currNode:
            nodeStack.append(currNode)
            currNode = currNode.next
            
        numRemainingItems = len(nodeStack) % k
        
        result = self.addRemainingItems(result, nodeStack, numRemainingItems)
        
        while len(nodeStack) > 0:
            result = self.getReverseItems(result, nodeStack, k)
        return result        


    def getReverseItems(self, result, nodeStack, k):
        itemcount: int = 0
        kstack = []
        while itemcount < k:
            nd = nodeStack.pop()
            kstack.append(nd)
            itemcount += 1

        print(f"len of ktack is {len(kstack)}")
        while len(kstack) > 0:
            reversedNode = kstack.pop()
            result = ListNode(reversedNode.val, result)
        return result
        
    def addRemainingItems(self, result, nodeStack, numRemainingItems: int):
        itemcount: int = 0
        while itemcount < numRemainingItems:
            nd = nodeStack.pop()
            result = ListNode(nd.val, result)
            itemcount += 1
        return result
