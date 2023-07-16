package netflix;

import java.util.HashMap;
import java.util.Map;

public class Feature6 {
	public static void main(String[] args) {
		LFUCache cache = new LFUCache(2);
		System.out.print("The most frequently watched titles are: (key, value)\n");
		cache.Set(1, 1);
		cache.Set(2, 2);
		cache.print();
		cache.Get(1);
		cache.Set(3, 3);
		cache.print();
		cache.Get(2);
		cache.Set(4, 4);

		cache.Get(1);
		cache.Get(3);
		cache.Get(4);
		cache.print();
	}
}

class LFUCache {
	int capacity;
	int size;
	int minFreq;

	HashMap<Integer, LinkedListNodeFeature6> keyDict;

	HashMap<Integer, MyLinkedListFeature6> freqDict;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.minFreq = 0;
		keyDict = new HashMap<Integer, LinkedListNodeFeature6>(capacity);
		freqDict = new HashMap<Integer, MyLinkedListFeature6>(capacity);
	}

	LinkedListNodeFeature6 Get(int key) {
		if (!keyDict.containsKey(key)) {
			return null;
		}

		LinkedListNodeFeature6 temp = this.keyDict.get(key);
		this.freqDict.get(temp.freq).deleteNode(temp);
		if (this.freqDict.get(this.keyDict.get(key).freq) == null) {
			this.freqDict.remove(this.keyDict.get(key).freq);
			if (this.minFreq == this.keyDict.get(key).freq) {
				this.minFreq += 1;
			}
		}
		this.keyDict.get(key).freq += 1;
		if (!this.freqDict.containsKey(this.keyDict.get(key).freq)) {
			this.freqDict.put(this.keyDict.get(key).freq, new MyLinkedListFeature6());
		}
		this.freqDict.get(this.keyDict.get(key).freq).append(this.keyDict.get(key));
		return this.keyDict.get(key);
	}

	void Set(int key, int value) {
		if (this.Get(key) != null) {
			this.keyDict.get(key).val = value;
			return;
		}
		if (this.size == this.capacity) {
			this.keyDict.remove(this.freqDict.get(this.minFreq).head.key);
			this.freqDict.get(this.minFreq).deleteNode(this.freqDict.get(this.minFreq).head);
			if (this.freqDict.get(this.minFreq) == null) {
				this.freqDict.remove(this.minFreq);
			}
			this.size -= 1;
		}
		this.minFreq = 1;
		this.keyDict.put(key, new LinkedListNodeFeature6(key, value, this.minFreq));
		if (!this.freqDict.containsKey(this.keyDict.get(key).freq)) {
			this.freqDict.put(this.keyDict.get(key).freq, new MyLinkedListFeature6());
		}
		this.freqDict.get(this.keyDict.get(key).freq).append(this.keyDict.get(key));
		this.size++;
	}

	void print() {
		for (Map.Entry<Integer, LinkedListNodeFeature6> entry : keyDict.entrySet()) {
			System.out.print("(" + entry.getKey() + ", " + entry.getValue().val + ")");
		}
		System.out.println("");
	}
}
