import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] array;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		array = new int[n][n];
		dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());


			for (int j = 0; j < i+1; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		for (int i = 0; i < n; i++) {
			dp[n-1][i] = array[n-1][i];
		}

		int result = findSum(0, 0);

		System.out.println(result);

	}

	static int findSum(int depth, int index) {
		if (depth == n-1) {
			return dp[depth][index];
		}

		if (dp[depth][index] == 0) {
			dp[depth][index] = Math.max(findSum(depth+1, index), findSum(depth+1, index+1)) + array[depth][index];
		}

		return dp[depth][index];
	}

}
