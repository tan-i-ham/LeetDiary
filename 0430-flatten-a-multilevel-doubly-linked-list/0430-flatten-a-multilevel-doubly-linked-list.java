/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
// iterate the list
// if a node has child, push the curr.next to the stack
// set curr.next to its child, and the child.prev to curr
// when curr is empty, if stack is not empty, set curr to top element
// until the curr is null and stack is empty, the flatten operation done
class Solution {
    public Node flatten(Node head) {
        Stack<Node> nextNodes = new Stack<>();
        Node curr = head;
        while(curr!=null){  
            if(curr.child!=null){
                if(curr.next!=null){
                    nextNodes.push( curr.next );    
                }
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;                 
            }
            if(curr.next==null && !nextNodes.isEmpty()){
                Node next = nextNodes.pop();
                curr.next = next;
                next.prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}