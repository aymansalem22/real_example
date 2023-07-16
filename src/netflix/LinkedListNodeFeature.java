package netflix;

//using at Class Feature5
public class LinkedListNodeFeature {
	public int key;
	public int data;
	public LinkedListNodeFeature next;
	public LinkedListNodeFeature prev;

	public LinkedListNodeFeature(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}

	public LinkedListNodeFeature(int key, int data) {
		this.key = key;
		this.data = data;
		this.next = null;
		this.prev = null;
	}

	public LinkedListNodeFeature(int data, LinkedListNodeFeature next) {
		this.data = data;
		this.next = next;
		this.prev = null;
	}

	public LinkedListNodeFeature(int data, LinkedListNodeFeature next, LinkedListNodeFeature prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

}
