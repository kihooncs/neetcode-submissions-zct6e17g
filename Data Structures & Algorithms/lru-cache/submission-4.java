class LRUCache {
    private Node lru;
    private Node mru;
    private HashMap<Integer, Node> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.lru = new Node(-1, -1);
        this.mru = new Node(-1, -1);
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.mru.prev = this.lru;
        this.lru.next = this.mru;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {

        if (this.map.containsKey(key)) {
           Node node = this.map.get(key);
            remove(node);
        }
        Node node = new Node(key, value);
        this.map.put(key, node);
        insert(node);
        if (map.size() > capacity) {
            Node del = this.lru.next;
            this.lru.next = this.lru.next.next;
            del.next.prev = this.lru;
            map.remove(del.key);
        }
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node) {
        Node prev = this.mru.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.mru;
        this.mru.prev = node;
    }
}

public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
