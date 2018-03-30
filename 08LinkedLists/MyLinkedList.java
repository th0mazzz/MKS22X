public class MyLinkedList{

    //NODE CLASS
    private class Node{

	private Node next;
	private Node prev;
	private Integer data;
	
	public Node(Integer data, Node next){
	    this.next = next;
	    this.data = data;
	}

	public Node getNext(){return this.next;}
	public Node getPrev(){return this.prev;}
	public Integer getValue(){return this.data;}

	public void setNext(Node newNode){this.next = newNode;}
	public void setPrev(Node newNode){this.next = newNode;}
	public void setValue(Integer newData){this.data = newData;}

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

    public int size(){
	return size;
    }

    // getNode
    private Node getNode(int index){ //this method's accuracy is unknown right now
	Node current = first;
	for(int i = 0; i < index; i++){
	    current = current.getNext();
	}
	return current;
    }
    // getNode

    public void add (int index, Integer value){ //Beware empty lists and start/end nodes
	if(index == 0){
	    Node beginning = new Node(value, first);
	    first = beginning;
	    size++;
	}
	else{ //this case needs work
	    if(index == size() - 1){
		Node ending = new Node(value, null);
		ending.setPrev(last);
		last = ending;
		size++;
	    }

	    /*
	    else{ //this case needs work
		Node current = first;
		for(int i = 0; i < index; i++){
		    current = current.getNext();
		}
		    
	    }
	    */
	    
	}
    }
		    
    

}
