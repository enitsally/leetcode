package kthLargestNumber;

public class Heap {

	class Node {
		int data;

		public Node(int key) {
			data = key;
		}

		public int getKey() {
			return data;
		}

		public void setKey(int id) {
			data = id;
		}

	}

	Node[] heapArray;
	int maxSize;
	int currentSize;

	public Heap(int mx) {
		maxSize = mx;
		currentSize = 0;
		heapArray = new Node[maxSize];
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

	public boolean insert(int key) {
		if (currentSize == maxSize)
			return false;
		Node newNode = new Node(key);
		heapArray[currentSize] = newNode;
		trickleUp(currentSize++);
		return true;
	}

	public void trickleUp(int index) {
		int parent = (index - 1) / 2;
		Node bottom = heapArray[index];

		while (index > 0 && heapArray[parent].getKey() < bottom.getKey()) {
			heapArray[index] = heapArray[parent];
			index = parent;
			parent = (parent - 1) / 2;
		}

		heapArray[index] = bottom;
	}

	public Node remove() {
		Node root = heapArray[0];
		heapArray[0] = heapArray[--currentSize];
		trickleDown(0);
		return root;
	}

	public void trickleDown(int index) {
		int largerChild;
		Node top = heapArray[index];
		while (index < currentSize / 2) {
			int leftChild = 2 * index + 1;
			int rightChild = leftChild + 1;

			if (rightChild < currentSize
					&& heapArray[leftChild].getKey() < heapArray[rightChild]
							.getKey()) {
				largerChild = rightChild;
			} else
				largerChild = leftChild;

			if (top.getKey() >= heapArray[largerChild].getKey()) {
				break;
			}

			heapArray[index] = heapArray[largerChild];
			index = largerChild;
		}

		heapArray[index] = top;

	}

	public void displayHeap() {
		System.out.print("heapArray: "); // array format
		for (int m = 0; m < currentSize; m++)
			if (heapArray[m] != null)
				System.out.print(heapArray[m].getKey() + " ");
			else
				System.out.print("-- ");
		int nBlanks = 32;
		int itemsPerRow = 1;
		int column = 0;
		int j = 0; // current item

		while (currentSize > 0) // for each heap item
		{
			if (column == 0) // first item in row?
				for (int k = 0; k < nBlanks; k++)
					// preceding blanks
					System.out.print(' ');
			// display item
			System.out.print(heapArray[j].getKey());

			if (++j == currentSize) // done?
				break;

			if (++column == itemsPerRow) // end of row?
			{
				nBlanks /= 2; // half the blanks
				itemsPerRow *= 2; // twice the items
				column = 0; // start over on
				System.out.println(); // new row
			} else
				// next item on row
				for (int k = 0; k < nBlanks * 2 - 2; k++)
					System.out.print(' '); // interim blanks
		}
	}

	public static void main(String[] args) {
		Heap h = new Heap(7);
		h.insert(3);
		h.insert(2);
		h.insert(1);
		h.insert(5);
		h.insert(6);
		h.insert(4);
		h.insert(7);
		h.displayHeap();
//		System.out.println(h.heapArray[1].getKey());
	}

}
