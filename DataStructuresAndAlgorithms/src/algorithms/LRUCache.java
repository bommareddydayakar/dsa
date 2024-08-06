package algorithms;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    Node head;
    Node tail;
    Map<Integer, Node> map;
    int capacity, size;
    public LRUCache(int capacity) {
        head = null;
        tail = null;
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        this.size = 0;
    }
    
    public int get(int key) {
        
        System.out.println("++++++++++++++++");
        if(map.containsKey(key)){
            Node temp = map.get(key);
            if(temp == head){
                //do nothing
            }else if(temp == tail){
                tail = temp.prev;
                temp.prev = null;
                
                if(tail == null)
                    tail = head;
                else
                    tail.next = null;

                    
            }else{
                
                if(temp.prev != null)
                    temp.prev.next = temp.next;
                
                if(temp.next != null)
                    temp.next.prev = temp.prev;

                
            }
            temp.next = head;
            head.prev = temp;
            head = temp;
            
            return temp.value;
        }
        return -1;    
    }
    
    public void put(int key, int value) {
       /* Node t = head;
        while(t != null){
            System.out.print("("+t.key+","+t.value+")  -> ");
            t = t.next;
        }
        */
        System.out.println("------");
        if(size < 1){
            Node newNode = new Node(key, value);
            head = newNode;
            tail =newNode;
            ++size;
            map.put(key, newNode);
        }else{
            if(map.containsKey(key)){
                Node temp = map.get(key);
                temp.value = value;
                if(temp == tail)
                	tail = tail.prev;
                if(temp.prev != null)
                    temp.prev.next = temp.next;
                
                if(temp.next != null)
                    temp.next.prev = temp.prev;

                temp.next = head;
                head = temp;
                temp.prev = null;
            }else{
                Node newNode = new Node(key, value);
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
                map.put(key, newNode);

                if(size >= capacity){
                    if(tail != null ){
                        map.remove(tail.key);
                        tail = tail.prev;
                        if(tail == null)
                            tail = head;
                        else
                        	tail.next = null;
                    }
                }else{
                    size++;
                }
            }
        }

        



    }



public static void main(String[] args) {
	LRUCache obj = new LRUCache(2);
	obj.put(2, 1);
	obj.put(1, 1);
	obj.put(2, 3);
	obj.put(4, 1);
	
	System.out.println(obj.get(1));
	
	System.out.println(obj.get(2));
	
	
	
	
}









        
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */