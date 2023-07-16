package netflix;

public class MyLinkedListFeature6 {

	public LinkedListNodeFeature6 head;
	public LinkedListNodeFeature6 tail;

	public MyLinkedListFeature6() {
		this.head = null;
		this.tail = null;
	}

	public void append(LinkedListNodeFeature6 node) {
		node.next = null;
		node.prev = null;
		if (this.head == null) {
			this.head = node;
		} else {
			this.tail.next = node;
			node.prev = this.tail;
		}
		this.tail = node;
	}

	public void deleteNode(LinkedListNodeFeature6 node) {
		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			this.head = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		} else {
			this.tail = node.prev;
		}
		node.next = null;
		node.prev = null;
	}

}
