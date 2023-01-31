import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] costs;
	static int[][] dp;

	final static int red = 0;
	final static int green = 1;
	final static int blue = 2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
	
		costs = new int[N][3]; 
		dp = new int[N][3];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			costs[i][red] = Integer.parseInt(st.nextToken());
			costs[i][green] = Integer.parseInt(st.nextToken());
			costs[i][blue] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][red] = costs[0][red];
		dp[0][green] = costs[0][green];
		dp[0][blue] = costs[0][blue];
		
		int result = Math.min(Math.min(getCost(N-1, red), getCost(N-1, green)), getCost(N-1, blue));
		System.out.println(result);
	}
	
	static int getCost(int N, int color) {
		if(dp[N][color] == 0) {
			
			if (color == red) {
				dp[N][red] = Math.min(getCost(N-1, green), getCost(N-1, blue)) + costs[N][red];
			}
			if (color == green) {
				dp[N][green] = Math.min(getCost(N-1, red), getCost(N-1, blue)) + costs[N][green];
			}
			if (color == blue) {
				dp[N][blue] = Math.min(getCost(N-1, red), getCost(N-1, green)) + costs[N][blue];
			}
			
 		}
		
		return dp[N][color];
	}
}