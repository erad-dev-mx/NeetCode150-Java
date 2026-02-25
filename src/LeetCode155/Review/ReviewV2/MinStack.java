package LeetCode155.Review.ReviewV2;

// Out stack needs to support: push, pop, top and getMin
// All in o(1) time

// Push a value onto the stack.
// Each node stores:
//  - its value
//  - the minimum value up to this node
// If the stack is empty:
//  - The minimum is the value itself.
// Otherwise:
//  - The new minimum is min(val, current head.min)

class MinStack {
    // Top of stack
    private Node head;

    public MinStack() {}

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, null);
        } else {
            head = new Node(val, Math.min(val, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    /*
    * val: actual value
    * min: min value up to this node
    * next: reference to next node
    * */
    private class Node {
        int val;
        int min;
        Node next;

        Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
