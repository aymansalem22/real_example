package netflix;

import java.util.PriorityQueue;

public class Feature3 {

	PriorityQueue<Integer> smallList;
	PriorityQueue<Integer> largeList;

	public Feature3() {
		smallList = new PriorityQueue<>((a, b) -> b - a);
		largeList = new PriorityQueue<>((a, b) -> a - b);
	}

	public void insertNum(int num) {
		if (smallList.isEmpty() || smallList.peek() >= num)
			smallList.add(num);
		else
			largeList.add(num);

		if (smallList.size() > largeList.size() + 1)
			largeList.add(smallList.poll());
		else if (smallList.size() < largeList.size())
			smallList.add(largeList.poll());
	}

	public double findMedian() {
		if (smallList.size() == largeList.size()) {
			return smallList.peek() / 2.0 + largeList.peek() / 2.0;
		}
		return smallList.peek();
	}

	public static void main(String[] args) {
		Feature3 feature3 = new Feature3();
		feature3.insertNum(22);
		feature3.insertNum(35);
		System.out.println("The recommended content will be for ages under: " + feature3.findMedian());
		feature3.insertNum(30);
		System.out.println("The recommender content will be for ages under: " + feature3.findMedian());
		feature3.insertNum(25);
		System.out.println("The recommender content will be for ages under: " + feature3.findMedian());
	}
}
