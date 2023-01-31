import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	
    	int[] array = new int[n];
    	int[] dp = new int[n];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < n; i++) {
    		array[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	dp[0] = array[0];
    	int max = array[0];
    	
    	for (int i = 1; i < n; i++) {
    		dp[i] = Math.max(dp[i-1] + array[i], array[i]);
    		max = Math.max(dp[i], max);
    	}
    	
    	System.out.println(max);
	}
}