package LeetCode;

import java.util.HashMap;

public class LRUCache {	
	public static void main (String[] args) {
		LRUCache lru = new LRUCache(3);
		lru.set(1, 1);
		lru.set(2, 2);
		lru.set(3, 3);
		System.out.print(lru.get(1));
		lru.set(4, 4);
		System.out.print(lru.get(2));
		
	}
	
	HashMap<Integer, CacheEntry> map;
	CacheEntry head, tail;
	int capacity;
	
    public LRUCache(int capacity) {
        this.capacity = capacity;
    	map = new HashMap<Integer, CacheEntry>();
        head = new CacheEntry(-1, -1);
        tail = new CacheEntry(1, 1);
        head.next = tail;
        tail.pre = head;
        
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
        	CacheEntry entry = map.get(key);
        	moveToHead(entry);
        	return entry.getValue();
        } 
        return -1;
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
        	CacheEntry entry = map.get(key);
        	entry.setValue(value);
        	map.put(key, entry);
        	moveToHead(entry);
        } else {
        	CacheEntry newEntry = new CacheEntry(key, value);
        	if (map.size() >= capacity) {
        		int removeKey = removeTail();
        		map.remove(removeKey);
        	}
        	map.put(key, newEntry);
        	addToHead(newEntry);
        }
    }
    
    public int removeTail () {
    	CacheEntry entry = tail.pre;
    	tail.pre.pre.next = tail;
    	tail.pre = tail.pre.pre;
    	entry.next = null;
    	entry.pre = null;
    	return entry.getKey();
    }
    public void moveToHead (CacheEntry entry) {
    	if (entry == head.next) {
    		return;
    	}
    	entry.pre.next = entry.next;
    	entry.next.pre = entry.pre;
    	entry.next = head.next;
    	head.next.pre = entry;
    	head.next = entry;
    }
    public void addToHead (CacheEntry entry) {
    	entry.next = head.next;
    	head.next.pre = entry;
    	entry.pre = head;
    	head.next = entry;
    }
}

class CacheEntry {
	int key;
	int value;
	CacheEntry next;
	CacheEntry pre;
	
	CacheEntry (int key, int value) {
		this.key = key;
		this.value = value;
		next = null;
		pre = null;
	}
	int getValue () {
		return value;
	}
	void setValue (int value) {
		this.value = value;
	}
	int getKey () {
		return key;
	}
	
}
