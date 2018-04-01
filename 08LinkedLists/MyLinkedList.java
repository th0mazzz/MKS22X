public class MyLinkedList{

    //NODE CLASS
    private class Node{

	private Node next;
	private Node prev;
	private Integer data;
	
	public Node(Integer data, Node prev, Node next){
	    this.next = next;
	    this.prev = prev;
	    this.data = data;
	}

	public Node getNext(){return this.next;}
	public Node getPrev(){return this.prev;}
	public Integer getValue(){return this.data;}

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
	
	public Integer setValue(Integer newData){
	    Integer old = this.data;
	    this.data = newData;
	    return old;
	}

	public String toString(){
	    return data + "";
	}
       
    }
    //NODE CLASS
    
    private Node first;
    private Node last;
    private int size;

    private Node getNode(int index){
	Node current = first;
	for(int i = 0; i < index; i++){
	    current = current.getNext();
	}
	return current;
    }
    
    public MyLinkedList(){
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
	//will fill in when remove is written
    }
    
    public int size(){
	return size;
    }
    
    public Integer get(int n){
	Node current = getNode(n);
	return current.getValue();
    }

    public void set(int index, int value){ //Make sure of return type
	Node current = getNode(index);
	current.setValue(value);
    }

    public int indexOf(Integer value){	
	for(int index = 0; index < size(); index++){
	    Node current = getNode(index);
	    if(value.equals(current.getValue())){
		return index;
	    }
	}
	return -1;
    }

    public boolean add(Integer value){ //EXCEPTIONS AND PREVS
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
    
    public void add (int index, Integer value){ //Beware empty lists and start/end nodes

	//NEED TO WORK ON PREVS
	//ALSO THROW INDEXOUTOFBOUNDSEXCEPTIONS
	
	if(size() == 0){ //handles empty lists
	    Node beginning = new Node(value, null, first);
	    first = beginning;
	    last = beginning;
	    size++;
	}else{
	    if(index <= 0){ //beware empty lists with no 1 element (for setPrev)
		Node beginning = new Node(value, null, first);
		first = beginning;
		size++;
	    }
	    else{
		if(index >= size()){
		    Node ending = new Node(value, last, null);
		    last.setNext(ending);
		    last = ending;
		    size++;
		}
		else{
		    Node before = getNode(index - 1);
		    Node after = getNode(index);
		    Node insert = new Node(value, before, after);
		    before.setNext(insert);
		    after.setPrev(insert);
		    size++;
		}
	    }
	}
    }
		    
    public boolean remove(Integer value){ //EXCEPTIONS
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
		    return true;
		}else{
		    if(index == size() - 1){
			Node before = current.getPrev();
			Node after = current.getNext();
			before.setNext(after);
			last = before;
			current.setNext(null);
			current.setPrev(null);
			return true;
		    }
		    else{
			Node before = current.getPrev();
			Node after = current.getNext();
			before.setNext(after);
			after.setPrev(before);
			current.setNext(null);
			current.setPrev(null);
			return true;
		    }
		}
	    }
	}
	return false;
    }

    public boolean remove(int targetIndex){
	Node current = getNode(targetIndex);
	if(targetIndex == 0){
	    Node after = current.getNext();
	    after.setPrev(null);
	    first = after;
	    current.setNext(null);
	    return true;
	}else{
	    if(targetIndex == size() - 1){
		Node before = current.getPrev();
		before.setNext(null);
		last = before;
		current.setPrev(null);
		return true;
	    }
	    else{
		Node before = current.getPrev();
		Node after = current.getNext();
		before.setNext(after);
		after.setPrev(before);
		current.setNext(null);
		current.setPrev(null);
		return true;
	    }
	}
    }
}
