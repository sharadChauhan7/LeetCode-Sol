class LRUCache {
    class Node{
        int val;
        int key;
        Node next;
        Node prev;

        public Node(int key,int val){
            this.val=val;
            this.key=key;
            this.next=null;
            this.prev=null;
        }
    }
    private Node head;
    private Node tail;
    public int cap=0;
    static int size=0;
    HashMap<Integer,Node> map;

    public LRUCache(int capacity) {
        this.map=new HashMap();
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
        this.cap =capacity;
        this.size=0;
    }
    
    private void addNode(Node node){
            head.next.prev=node;
            node.next=head.next;
            node.prev=head;
            head.next=node;
            return;
    }
    private void removeNode(Node node){
        node.next.prev=node.prev;
        node.prev.next=node.next;
        return;
    }
    public int get(int key) {
    
        if(map.containsKey(key)){
            Node curr = map.get(key);
            moveToHead(curr);
            return curr.val;
        }
        return -1;
    }
    private void moveToHead(Node node){
        this.removeNode(node);
        this.addNode(node);
        return;
    }
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node ans =map.get(key);
            moveToHead(ans);
            ans.val = value;
            ans.key=key;
            return;
        }
        if(size<cap){
            Node top = new Node(key,value);
            map.put(key,top);
            addNode(top);
        }
        else{
            map.remove(tail.prev.key);
            removeNode(tail.prev);
            // Adding Element
            Node top = new Node(key,value);
            map.put(key,top);
            addNode(top);
        }
        size++;
        return;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */