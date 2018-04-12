import java.util.Iterator;
public class MyLinkedListImproved<Type extends Comparable<Type>> implements Iterable<Type>{

    //NODE CLASS
    private class Node{

	private Node next;
	private Node prev;
	private Type data;
	
	public Node(Type data, Node prev, Node next){
	    this.next = next;
	    this.prev = prev;
	    this.data = data;
	}

	public Node getNext(){return this.next;}
	public Node getPrev(){return this.prev;}
	public Type getValue(){return this.data;}

	public Node setNext(Node newNode){
	    Node old = this.next;
	    this.next = newNode;
	    return old;
	}
	
	public Node setPrev(Node newNode){
	    Node old = this.prev;
	    this.prev = newNode;
	    return old;
	}
	
	public Type setValue(Type newData){
	    Type old = this.data;
	    this.data = newData;
	    return old;
	}

	public String toString(){
	    return data + "";
	}
       
    }
    //NODE CLASS
    
    //ITERATOR STUFF

    public Iterator<Type> iterator(){
	return new ListIterator();
    }

    private class ListIterator implements Iterator<Type>{

	Node current;
	
	public ListIterator(){
	    current = first;
	}
	
	public boolean hasNext(){
	    if(current != null){
		return true;
	    }
	    return false;
	}

	public Type next(){
	    if(hasNext()){
		Type returnValue = current.getValue();
		current = current.getNext();
		return returnValue;
	    }
	    return null;
	}
	
    }
    //ITERATOR STUFF
    
    private Node first;
    private Node last;
    private int size;

    private Node getNode(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	Node current = first;
	for(int i = 0; i < index; i++){
	    current = current.getNext();
	}
	return current;
    }
    
    public MyLinkedListImproved(){
	first = null;
	last = null;
	size = 0;
    }

    public String toString(){
	String returnString = "[";
	if(size() > 0){
  	    Node current = first;
	    while(current != null){
		returnString = returnString + current.getValue() + ", ";
		current = current.getNext();
	    }
	    returnString = returnString.substring(0, returnString.length() - 2);
	}
	return returnString + "]";
    }

    public void clear(){
	first = null;
	last = null;
	size = 0;
    }
    
    public int size(){
	return size;
    }
    
    public Type get(int n){
	if(n < 0 || n >= size()){
	    throw new IndexOutOfBoundsException();
	}
	Node current = getNode(n);
	return current.getValue();
    }

    public void set(int index, Type value){ //Make sure of return type
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	Node current = getNode(index);
	current.setValue(value);
    }

    public int indexOf(Type value){
	for(int index = 0; index < size(); index++){
	    Node current = getNode(index);
	    if(value.equals(current.getValue())){
		return index;
	    }
	}
	return -1;
    }

    public boolean add(Type value){
	if(size == 0){
	    Node beginning = new Node(value, null, first);
	    first = beginning;
	    last = beginning;
	    size++;
	}else{
	    Node ending = new Node(value, last, null);
	    last.setNext(ending);
	    last = ending;
	    size++;
	}
	return true;
    }
    
    public void add(int index, Type value){ //Beware empty lists and start/end nodes

	if(index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
	}
	
	if(size() == 0){ //handles empty lists
	    Node beginning = new Node(value, null, first);
	    first = beginning;
	    last = beginning;
	    size++;
	}else{
	    if(index <= 0){
		Node beginning = new Node(value, null, first);
		first.setPrev(beginning);
		beginning.setNext(first);
		first = beginning;
		size++;
	    }
	    else{
		if(index >= size()){
		    Node ending = new Node(value, last, null);
		    last.setNext(ending);
		    ending.setPrev(last);
		    last = ending;
		    size++;
		}
		else{
		    Node before = getNode(index - 1);
		    Node after = getNode(index);
		    Node insert = new Node(value, before, after);
		    before.setNext(insert);
		    after.setPrev(insert);
		    insert.setPrev(before);
		    insert.setNext(after);
		    size++;
		}
	    }
	}
    }
		    
    public boolean remove(Type value){
	for(int index = 0; index < size(); index++){
	    Node current = getNode(index);
	    if(value.equals(current.getValue())){
		if(index == 0){
		    Node before = current.getPrev();
		    Node after = current.getNext();
		    after.setPrev(before);
		    first = after;
		    current.setNext(null);
		    current.setPrev(null);
		    size--;
		    return true;
		}else{
		    if(index == size() - 1){
			Node before = current.getPrev();
			Node after = current.getNext();
			before.setNext(after);
			last = before;
			current.setNext(null);
			current.setPrev(null);
			size--;
			return true;
		    }
		    else{
			Node before = current.getPrev();
			Node after = current.getNext();
			before.setNext(after);
			after.setPrev(before);
			current.setNext(null);
			current.setPrev(null);
			size--;
			return true;
		    }
		}
	    }
	}
	return false;
    }

    public boolean remove(int targetIndex){

	if(targetIndex < 0 || targetIndex >= size()){
	    throw new IndexOutOfBoundsException();
	}
	
	Node current = getNode(targetIndex);
	if(targetIndex == 0){
	    Node after = current.getNext();
	    after.setPrev(null);
	    first = after;
	    current.setNext(null);
	    size--;
	    return true;
	}else{
	    if(targetIndex == size() - 1){
		Node before = current.getPrev();
		before.setNext(null);
		last = before;
		current.setPrev(null);
		size--;
		return true;
	    }
	    else{
		Node before = current.getPrev();
		Node after = current.getNext();
		before.setNext(after);
		after.setPrev(before);
		current.setNext(null);
		current.setPrev(null);
		size--;
		return true;
	    }
	}
    }
    
    public int max(){ //return the index of the largest value or -1 if empty
	int maxIndex = 0;
	if(size() == 0){
	    return -1;
	}
	if(size() == 1){
	    return 0;
	}
	else{
	    for(Type n : this){
		if(n.compareTo(get(maxIndex)) > 0){
		    maxIndex = indexOf(n);
		}
	    }
	}
	return maxIndex;
    }

    public int min(){ //return the index of the smallest value or -1 if empty
	int minIndex = 0;
	if(size() == 0){
	    return -1;
	}
	if(size() == 1){
	    return 0;
	}
	else{
	    for(Type n : this){
		if(n.compareTo(get(minIndex)) < 0){
		    minIndex = indexOf(n);
		}
	    }
	}
	return minIndex;
    }

    public void extend(MyLinkedListImproved<Type> other){ //SHOULD TEST
        last.setNext(other.getNode(0));
	if(other.size() != 0){
	    other.getNode(0).setPrev(last);
	}
	other.clear();
    }
}
