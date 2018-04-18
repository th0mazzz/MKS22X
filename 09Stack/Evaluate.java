public class Evaluate{

    public static double eval(String express){

	int numTokens = 1;
	for(int index = 0; index < express.length(); index++){
	    if(express.charAt(index) == ' '){
		numTokens++;
	    }
	}
	
	String[] tokens = new String[numTokens];
	int arrayIndex = 0;

	for(int index = 0; index < express.length(); index++){
	    String token = "";
	    while(index < express.length() && express.charAt(index) != ' '){
		
		token = token + express.charAt(index);
		index++;
		
	    }
	    
	    tokens[arrayIndex] = token;
	    arrayIndex++;
	}

	Stack<Double> stackie = new Stack<>();
	double answer = 0.0;
	
	for(int index = 0; index < tokens.length; index++){
	    if(!((tokens[index].equals("+") ||
		  (tokens[index].equals("-")) ||
		  (tokens[index].equals("*")) ||
		  (tokens[index].equals("/")) ||
		  (tokens[index].equals("%"))))){

		stackie.push(Double.parseDouble(tokens[index]));
		
	    }else{

		if(tokens[index].equals("+")){
		    stackie.push(stackie.pop() + stackie.pop());
		}
		if(tokens[index].equals("-")){
		    double second = stackie.pop();
		    stackie.push(stackie.pop() - second);
		}
		if(tokens[index].equals("*")){
		    stackie.push(stackie.pop() * stackie.pop());
		}
		if(tokens[index].equals("/")){
		    double second = stackie.pop();
		    stackie.push(stackie.pop() / second);
		}
		if(tokens[index].equals("%")){
		    double second = stackie.pop();
		    stackie.push(stackie.pop() % second);
		}
		
	    }
	}

	
	return stackie.pop();
    }
    
    public static void main(String[] args){

	String a = "8 2 + 99 9 - * 2 + 9 -";
	System.out.println("\n\n\n" + eval(a)); //893.0

	System.out.println(eval("10 2.0 +")); //30.0
	System.out.println(eval("11 3 - 4 + 2.5 *")); //12.0
	
    }
    
}
