public class MyLinkedList{

    //NODE CLASS
    private class Node{

	private Node next;
	private Node prev;
	private int data;
	
	public Node(int data, Node next){
	    this.next = next;
	    this.data = data;
	}

	public Node getNext(){return this.next;}
	public Node getPrev(){return this.prev;}
	public int getValue(){return this.data;}

	public void setNext(Node newNode){this.next = newNode;}
	public void setPrev(Node newNode){this.next = newNode;}
	public void setValue(int newData){this.data = newData;}

	public String toString(){
	    return data + "";
	}
       
    }
    //NODE CLASS
    
    private Node first;
    private Node last;
    private int length;
    
    public MyLinkedList(){
	first = null;
	last = null;
	length = 0;
    }

    public String toString(){
	String returnString = "";
	Node current = first;
	while(current.next != null){
	    returnString = returnString + current.data;
	    current = current.next;
	}
	return returnString;
    }

    public int get(int n){
	Node current = first;
	for(int counter = 0; counter != n; counter++){
	    current = current.next;
	}
	return current.data;
    }

    public void set(int index, int value){
	Node current = first;
	for(int counter = 0; counter != index; counter++){
	    current = current.next;
	}
	current.data = value;
    }

    public int size(){
	return length;
    }

    // getNode
    //private Node getNode(int index){
	
    //}
    // getNode

    public void add (int index, int value){ //Beware empty lists and start/end nodes
	if(index == 0){
	    Node beginning = new Node(value, first);
	    first = beginning;
	}
	else{
	    if(index == this.size() - 1){
		Node ending = new Node(value, null);
		ending.setPrev(last);
		last = ending;
	    }
	    else{
		Node current = first;
		for(int i = 0; i < index; i++){
		    current = current.getNext();
		}
		    
	    }
	}
    }
		    
    

}
