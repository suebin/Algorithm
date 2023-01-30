import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static long[] padovan = new long[101];

	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	StringBuilder result = new StringBuilder();
    	
    	for (int i = 0; i < T; i++) {
    		int N = Integer.parseInt(br.readLine());
    		result.append(getPadovanSequence(N) + "\n");
    	}
    	
    	System.out.println(result);
	}
	
	static long getPadovanSequence(int N) {
		if (padovan[N] != 0) 
			return padovan[N];
		
		padovan[1] = padovan[2] = padovan[3] = 1;
		padovan[4] = 2;
		for (int i = 5; i <= N; i++) {
			padovan[i] = padovan[i-5] + padovan[i-1];
		}
		
		return padovan[N];
	}
}