package application;
import java.util.Comparator;
import java.util.Iterator;

/*public class LinkedList<T> implements Iterable<T>{
private SingleNode<T> first,last;
private int count=0;

public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
//T
@SuppressWarnings("unchecked")
public SingleNode<T> getFirst() {
	return (SingleNode<T>) first.getElement();
}
public T get(int index) {
    if (index < 0 || index >= count) {
        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    SingleNode<T> current = first;
    for (int i = 0; i < index; i++) {
        if (current == null) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        current = current.getNext();
    }

    return current.getElement();
}
public T get(T vertixCity) {
    SingleNode<T> current = first;
    while (current != null) {
        // Assuming T is VertixCity or a class that contains VertixCity
        if (current.getElement() instanceof VertixCity) {
            VertixCity currentVertixCity = (VertixCity) current.getElement();
            if (currentVertixCity.equals(vertixCity)) {
                return current.getElement();
            }
        }
        current = current.getNext();
    }

    return null; // VertixCity not found in the list
}


public Object getLast() {
	return last.getElement();
}
public void addFirst(T element) {
	if(first == null) {
		first = last = new SingleNode<>(element);
	}
	else {
		SingleNode<T> temp = new SingleNode<>(element);
		temp.setNext(first);
		first = temp;
	}
	count ++;
}
public void addLast(T element) {
	if(count == 0)
		first = last = new SingleNode<>(element);
	else {
		SingleNode<T> temp = new SingleNode<>(element);
		last.setNext(temp);
		last = temp;
	}
	count++;
}
public void add(T element , int index) {
	if(count ==0)
		first = last = new SingleNode<>(element);
	if(index <= 0 || count < index)
		addLast(element);
	else {
		SingleNode<T> current =first;
		for(int i=0;i<index - 1; i++) {
			current = current.getNext();
		}
		SingleNode<T> temp = new SingleNode<>(element);
		temp.setNext(current.getNext());
		current.setNext(temp);
	}
	count++;
}
public boolean removeFirst() {
	if(count ==0) {
		return false;
	}else {
		SingleNode<T> temp = first;
		first = first.getNext();
		temp.setNext(null);
	}
	count --;
	return true;
}
public T removeLast() {
    if (count == 0) {
        return null;
    }

    T removedElement;
    
    if (count == 1) {
        removedElement = first.getElement();
        first = last = null;
    } else {
        SingleNode<T> current = first;
        SingleNode<T> previous = null;

        while (current.getNext() != null) {
            previous = current;
            current = current.getNext();
        }

        removedElement = last.getElement();
        previous.setNext(null);
        last = previous;  // Update the last attribute
    }

    count--;
    return removedElement;
}



public boolean remove(int index) {
	SingleNode<T> prev = null;
	if(index == 1)
		return removeFirst();
	if(index == count)
		return (boolean) removeLast();
	if(index <= 0 || index > count)
		return false;
	else {
		SingleNode<T> current = first;
		for(int i =0;i< index;i++) {
			prev = current;
			current = current.getNext();
		}
		prev.setNext(current.getNext());
		current.setNext(null);
	}
	count--;
	return true;
}
public boolean remove (T element) {
	if(count ==0) 
		return false;
		if(element.equals(first.getElement()))
			return removeFirst();
		if(element.equals(last.getElement()))
			return (boolean) removeLast();
		else {
			SingleNode<T> current =first.getNext();
			for(int i=1;i<count-1;i++) {
			//	System.out.println(i+" "+current.getElement());
				if(current.getElement().equals(element))
					return remove(i);
				current = current.getNext();
			}
			count --;
			return false;
		}
}
public int size() {
    return count;
}
//bubble sort
public void sort(Comparator<T> comparator) {
    boolean swapped;
    do {
        swapped = false;
        SingleNode<T> current = first;
        SingleNode<T> next = first.getNext();

        while (next != null) {
            if (comparator.compare(current.getElement(), next.getElement()) > 0) {
                // Swap elements
                T temp = current.getElement();
                current.setElement(next.getElement());
                next.setElement(temp);
                swapped = true;
            }

            current = next;
            next = next.getNext();
        }
    } while (swapped);
}
private class LinkedListIterator implements Iterator<T> {
    private SingleNode<T> current = first;

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        T element = current.getElement();
        current = current.getNext();
        return element;
    }
}

@Override
public Iterator<T> iterator() {
	// TODO Auto-generated method stub
	return new LinkedListIterator();
}

}*/
