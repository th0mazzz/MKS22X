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
}
