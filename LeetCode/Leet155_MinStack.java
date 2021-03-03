class Leet155_MinStack {
    Stack<Integer> stack;
    PriorityQueue<Integer> queue;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        queue = new PriorityQueue<>();
    }
    
    public void push(int x) {
        stack.push(x);
        queue.offer(x);
    }
    
    public void pop() {
        queue.remove(stack.pop());
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return queue.peek();
    }
}

// Way 2 -- keep track of the minium value seen so far, keep adding node to the front and delete from the front to maintain stack operations

class MinStack {
    Node head;
    class Node{
        int value;
        Node next;
        int min;
        public Node(int min){this.min = Integer.MAX_VALUE;}
        public Node(int value, int min){
            this.value = value;
            this.min = Math.min(head.min, min);
        }
    }
    public MinStack() {
        head = new Node(Integer.MAX_VALUE); 
    }
    
    public void push(int x) {
        if(head.next == null)
            head.next = new Node(x,x);
        else{
            Node temp = head.next;
            head.next = new Node(x, Math.min(temp.min,x));
            head.next.next = temp;
            }
    }
    
    public void pop() {
        if(head.next != null)
        head.next = head.next.next;
    }
    
    public int top() {
        return head.next.value;
    }
    
    public int getMin() {
        return head.next.min;
    }
}

