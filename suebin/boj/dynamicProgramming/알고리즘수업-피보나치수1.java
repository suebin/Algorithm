import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
        
public class Main {
	static int[] fibonacci;
	static int recursionCount = 0;
	static int dpCount = 0;
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	fibonacci = new int[n];
    	
    	fib(n);
    	fibonacci(n);
    	
    	System.out.println(recursionCount + " " + dpCount);

	}
	
	static int fib(int n) {
		if (n == 1 || n == 2) {
			recursionCount++;
			return 1;
		}
		
		return fib(n-1) + fib(n-2); 
	}
	
	static int fibonacci(int n) {
		fibonacci[0] = fibonacci[1] = 1;
		
		for (int i = 2; i < n; i++) {
			dpCount++;
			fibonacci[i] = fibonacci[i-2] + fibonacci[i-1];
		}
		
		return fibonacci[n-1];
	}
}