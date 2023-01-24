import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
        
public class Main {
	static int N;
	static int[][] stat;
	static boolean[] visit;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	N = Integer.parseInt(br.readLine());
    	visit = new boolean[N];
    	stat = new int[N][N];
    	
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		for (int j = 0; j < N; j++) {
    			stat[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	
		getStatDifference(0, 0);
		System.out.println(min);
	}
	
	static void getStatDifference(int start, int r) {
		if (r == N/2) {
			getMinimumValue();
			return;
		}
		
		for (int i = start; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				getStatDifference(i + 1, r + 1);
				visit[i] = false;
			}
		}
	}
	
	static void getMinimumValue() {
		int startStat = 0;
		int lankStat = 0;
		
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				if (visit[i] && visit[j]) {
					startStat += (stat[i][j] + stat[j][i]);
				}
				else if (!visit[i] && !visit[j]) {
					lankStat += (stat[i][j] + stat[j][i]);
				}
			}
		}
		
		int difference = Math.abs(startStat - lankStat);
		
		if (difference == 0) {
			System.out.println(difference);
			System.exit(0);
		}
		
		min = Math.min(min, difference);
	}
	
}