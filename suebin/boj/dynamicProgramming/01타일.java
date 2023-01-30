import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int num = 15746;
	static int[] dp;

	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	dp = new int[N+1];
    	
    	
    	System.out.println(getCount(N));
    	
	}
	
	static int getCount(int N) {
		dp[0] = dp[1] = 1 % num;
		
		
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i-2] + dp[i-1];
			dp[i] %= num;
		}
		
		return dp[N];
	}
}