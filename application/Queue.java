package application;
import java.util.Comparator;
import java.util.LinkedList;

/*import java.util.Arrays;

public class Queue {
private int front,rear,capacity;
private Object [] qu;
public Queue(int capacity) {
	this.capacity=capacity;
	qu = new Object[capacity];
	front = rear = capacity-1;
}
public int getFront() {
	return front;
}
public void setFront(int front) {
	this.front = front;
}
public int getRear() {
	return rear;
}
public void setRear(int rear) {
	this.rear = rear;
}
public int getCapacity() {
	return capacity;
}
public void setCapacity(int capacity) {
	this.capacity = capacity;
}
public Object[] getQu() {
	return qu;
}
public void setQu(Object[] qu) {
	this.qu = qu;
}
public boolean isEmpty() {
	return front == rear;
}
public boolean isFull() {
	if(nextRear()==front)
		return true;
	return false;
}
public int nextRear() {
	if(rear == capacity-1)
		return 0;
	return rear++;
}
public int nextFront() {
	if(front == capacity-1)
		return 0;
	return front++;
}
public void enQueue(Object o,double priorty) {
	if(isFull()) {
		System.out.println("Queue is Full");
		return;
	}
	rear = nextRear();
	qu[rear]=new QueueElement(o, priorty);
}
public Object deQueue() {
	if(isEmpty()) {
		System.out.println("Queue is full");
		return null;
	}
	else {
		Object temp=qu[front];
		front = nextFront();
		return temp;
	}
	
}
public void printQueue() {
	if(isEmpty())
		System.out.println("Queue is Empty");
	else {
		if(front <= rear) {
			for(int i=front;i<=rear;i++)
				System.out.println(qu[i]+"");
		}else {
			for(int i=front;i<capacity;i++)
				System.out.println(qu[i]+"");
			for(int i=front;i<=rear;i++)
				System.out.println(qu[i]+"");
		}
	}
}
public void clear() {
    front = 0;
    rear = 0;
    for(int i = 0; i < capacity; i++) {
        qu[i] = null;
    }
}
@Override
public String toString() {
	return "Queue [front=" + front + ", rear=" + rear + ", capacity=" + capacity + ", qu=" + Arrays.toString(qu) + "]";
}
public boolean contains(Object o) {
	for(int i = front; i != rear; i = (i + 1) % capacity) {
		if(qu[i].equals(o)) {
			return true;
		}
	}
	return false;
}
}*/

public class Queue<T> {
    private LinkedList<T> elements;
    private Comparator<T> comparator;

    public Queue() {
        this.elements = new LinkedList<>();
        this.comparator = null; // or set it to a default comparator if needed
    }

    // Constructor with a Comparator
    public Queue(Comparator<T> comparator) {
        this(); // Call the no-argument constructor to initialize other variables
        this.comparator = comparator;
    }

    public void enQueue(T element) {
        elements.add(element);
        if (comparator != null) 
            elements.sort( comparator);
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        return elements.removeLast();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
  
}
