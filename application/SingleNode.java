package application;

public class SingleNode<T> {
private T element;
private SingleNode<T> next;
public SingleNode(T element) {
	this.element=element;
}
public T getElement() {
	return element;
}
public void setElement(T element) {
	this.element = element;
}
public SingleNode<T> getNext() {
	return next;
}
public void setNext(SingleNode<T> next) {
	this.next = next;
}
@Override
public String toString() {
	return "SingleNode [element=" + element + ", next=" + next + "]";
}

}
