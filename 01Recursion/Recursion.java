public class Recursion{

    public int fact(int n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	if(n == 0){
	    return 1;
	}
	return n * fact(n - 1);
    }

    public int fib(int n){
	return fibHelp(n, 0);
    }
    
    public int fibHelp(int n, int sum){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	if(n == 0){
	    return sum;
	}
	if(n == 1){
	    return sum;
	}
	return fibHelp(n - 1, sum);
    }



    
    public static void main(String[] args){
	Recursion r = new Recursion();
	System.out.println(r.fact(0) + " Expect 1");
	System.out.println(r.fact(1) + " Expect 1");
	System.out.println(r.fact(2) + " Expect 2");
	System.out.println(r.fact(3) + " Expect 6");
	System.out.println(r.fact(4) + " Expect 24");

	System.out.println("---------------");
	
	System.out.println(r.fib(0) + " Expect 0");
	System.out.println(r.fib(1) + " Expect 1");
	System.out.println(r.fib(2) + " Expect 1");
	System.out.println(r.fib(3) + " Expect 2");
	System.out.println(r.fib(4) + " Expect 3");
	System.out.println(r.fib(5) + " Expect 5");
	System.out.println(r.fib(6) + " Expect 8");
	System.out.println(r.fib(7) + " Expect 13");
	System.out.println(r.fib(8) + " Expect 21");
    }
}
