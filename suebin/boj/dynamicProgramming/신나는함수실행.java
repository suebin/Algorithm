import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
        
public class Main {
	static int[][][] dp = new int[21][21][21];

	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder result = new StringBuilder();
    	
    	while (true) {
    		st = new StringTokenizer(br.readLine());
    		
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		
    		if (a == -1 && b == -1 && c == -1)
    			break;
    		
    		result.append("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c) + "\n");
    	}
    	
    	System.out.println(result);
	}
	
	static int w(int a, int b, int c) {
		if (0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20 && dp[a][b][c] != 0) {
				return dp[a][b][c];
		}
		
		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		else if (a > 20 || b > 20 || c > 20) {
			return dp[20][20][20] = w(20, 20, 20);
		}
		else if (a < b && b < c) {
			return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
		}
		
		return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
	}
}