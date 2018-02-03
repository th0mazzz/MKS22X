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
	return fibHelp(n, 0, 0, 1);
    }
    
    public int fibHelp(int n, int sum, int num1, int num2){
	if(n == 0){
	    return sum;
	}
	if(n == 1 || n == 2){
	    return sum + 1;
	}
	int temp = num1;
	num1 = num2;
	num2 = temp + num2;
	
	return fibHelp(n - 1, sum + num1, num1, num2);
	    
    }

    public double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	if(n == 0){
	    return 0.0;
	}
	return sqrtHelp(n, 1.0);
    }

    public double sqrtHelp(double n, double guess){
	if(Math.abs(((guess * guess) / n) - 1) < 0.000001){
	    return Math.round(guess * 10000.0) / 10000.0;
	}
	guess = ((n / guess) + guess) / 2;
	return sqrtHelp(n, guess);
    }

    
    public static void main(String[] args){
	Recursion r = new Recursion();
	System.out.println("---Factorial---");
	System.out.println(r.fact(0) + " Expect 1");
	System.out.println(r.fact(1) + " Expect 1");
	System.out.println(r.fact(2) + " Expect 2");
	System.out.println(r.fact(3) + " Expect 6");
	System.out.println(r.fact(4) + " Expect 24");

	System.out.println("---Fibonacci---");
	
	System.out.println(r.fib(0) + " Expect 0");
	System.out.println(r.fib(1) + " Expect 1");
	System.out.println(r.fib(2) + " Expect 1");
	System.out.println(r.fib(3) + " Expect 2");
	System.out.println(r.fib(4) + " Expect 3");
	System.out.println(r.fib(5) + " Expect 5");
	System.out.println(r.fib(6) + " Expect 8");
	System.out.println(r.fib(7) + " Expect 13");
	System.out.println(r.fib(8) + " Expect 21");

	System.out.println("---Square Root---");

	System.out.println(r.sqrt(0) + " Expect 0");
	System.out.println(r.sqrt(1) + " Expect 1");
	System.out.println(r.sqrt(2) + " Expect 1.4142");
	System.out.println(r.sqrt(3) + " Expect 1.7321");
	System.out.println(r.sqrt(4) + " Expect 2");
	
	System.out.println(r.sqrt(5) + " Expect 2.2361");
	System.out.println(r.sqrt(6) + " Expect 2.4495");
	System.out.println(r.sqrt(7) + " Expect 2.6458");
	System.out.println(r.sqrt(8) + " Expect 2.8284");
	System.out.println(r.sqrt(9) + " Expect 3");
	
    }
}
