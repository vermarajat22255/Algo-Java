import java.util.HashMap;

public class LRUCache {
    final Node head = new Node();
    final Node tail = new Node();

    /**************************************************************/
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public String toString() {
            return this.prev.val + "<- " + this.val + "->" + this.next.val;
        }
    }

    /*************************************************************/

    HashMap<Integer, Node> cache;
    int capacity = 0;

    public LRUCache(int capacity) {
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node != null) {
            remove(node);
            add(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) { // already there
            remove(node);
            node.val = value;
            add(node); // bring to front
        } else {
            if (cache.size() == capacity) {
                cache.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node temp = new Node();
            temp.key = key;
            temp.val = value;
            add(temp);
            cache.put(key, temp);
        }
    }

    public void remove(Node n) {
        Node back = n.prev;
        Node forw = n.next;
        back.next = forw;
        forw.prev = back;
    }

    public void add(Node n) {
        Node temp = head.next;
        head.next = n;
        n.prev = head;
        n.next = temp;
        temp.prev = n;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */