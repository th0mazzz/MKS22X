import java.util.LinkedList;
public class Stack<Type>{

    LinkedList<Type> list;
    
    public Stack(){
	list = new LinkedList<Type>();
    }

    public Type pop(){
	return list.removeLast();
    }

    public void push(Type element){
	list.add(element);
    }

    public String toString(){
	String returnString = "[";
	for(int index = 0; index < list.size(); index++){
	    returnString = returnString + list.get(index) + ", ";
	}
	if(returnString.equals("[")){
	    return "[]";
	}
	returnString = returnString.substring(0, returnString.length() - 2);
	return returnString + "]";
    }

    public static void main(String[] args){
	Stack<String> a = new Stack<>();
	System.out.println(a);
	a.push("Apple");
	System.out.println(a);
	a.push("Banana");
	a.push("Corn");
	System.out.println(a);
	System.out.println(" - " + a.pop());
	System.out.println(a);
	System.out.println(" - " + a.pop());
	System.out.println(" - " + a.pop());
	System.out.println(a);
    }
}
