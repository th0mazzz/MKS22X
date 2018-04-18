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
		System.out.println(index);
		token = token + express.charAt(index);
		index++;
		
	    }
	    System.out.println("token: " + token);
	    
	    tokens[arrayIndex] = token;
	    arrayIndex++;
	}

	for(int index = 0; index < tokens.length; index++){
	    System.out.print(tokens[index] + ", ");
	}

	return 0.0;
    }
    
    public static void main(String[] args){

	String a = "8 2 + 99 9 - * 2 + 9 -";
	System.out.println("\n\n\n" + eval(a));
	
    }
    
}
