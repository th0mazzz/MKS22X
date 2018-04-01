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
	    this.next = newNode;
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
		returnString = returnString + current.data + ", ";
		current = current.next;
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
	Node current = first;
	for(int counter = 0; counter != n; counter++){
	    current = current.next;
	}
	return current.data;
    }

    public void set(int index, int value){ //Make sure of return type
	Node current = first;
	for(int counter = 0; counter != index; counter++){
	    current = current.next;
	}
	current.data = value;
    }

    

    private Node getNode(int index){
	Node current = first;
	for(int i = 0; i < index; i++){
	    current = current.getNext();
	}
	return current;
    }

    public boolean add(Integer value){
	if(size == 0){
	    Node beginning = new Node(value, null, first);
	    first = beginning;
	    last = beginning;
	    size++;
	    return true;
	}else{ //needs prev
	    Node ending = new Node(value, last, null);
	    last.setNext(ending);
	    last = ending;
	    size++;
	    return true;
	}
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
	    }
	}
	
    }
		    
    

}
