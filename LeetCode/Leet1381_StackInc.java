class Leet1381_StackInc {
    public Node head ,tail;
    private static int length =0;
    int copy = 0;
    class Node{
        Node next;
        Node prev;
        int val;
        public Node(){}
        public Node(int x){
            this.val = x;
        }
    }
// ["CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"]
// [[3],           [1],    [2],   [],   [2],  [3],   [4],    [5,100],   [2,100],    [],    [],   [],   []]
//  103 202 201      
    public CustomStack(int maxSize) {
        length = maxSize;
        copy = maxSize;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    public void add(int x){
        Node n = new Node(x);
        Node temp = head.next;
        head.next = n;
        n.prev = head;
        n.next = temp;
        temp.prev = n;
    }
    public int delete(){
        int x = head.next.val;
        head.next = head.next.next;
        head.next.prev = head;
        return x;
    }
    public void inc(int k, int value){
        Node ptr = tail.prev;
        while(k > 0 && ptr != null){
            ptr.val += value;
            ptr = ptr.prev;
            k--;
        }
    }
    
    public void push(int x) {
        if(length > 0){
            length--;
            add(x);
        }
    }
    
    public int pop() {
        if(length != copy){
            length++;
            return delete();
        }
        return -1;
    }
    
    public void increment(int k, int val) {
        inc(k, val);
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
