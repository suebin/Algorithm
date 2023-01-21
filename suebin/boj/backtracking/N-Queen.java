import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
        
public class Main {
	static int N;
	static int[] queenPlace;
	static int count = 0;
    
	public static void main(String[] args) throws IOException {
    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	queenPlace = new int[N];
    	findNQueen(0);	
    	System.out.println(count);
    }
    
	
    public static void findNQueen(int depth) {
    	if (depth == N) {
    		count++;
    		return;
    	}
    	
    	for (int i = 0; i < N; i++) {
    		queenPlace[depth] = i;
    		
    		if (getPossibillity(depth)) {
        		findNQueen(depth+1);
        	}
    	}
   
    }
    
    public static boolean getPossibillity(int column) {
    	for (int i = 0; i < column; i++) {
    		if (queenPlace[column] == queenPlace[i])
    			return false;
    		
    		if (Math.abs(column - i) == Math.abs(queenPlace[column] - queenPlace[i]))
    			return false;
    	}
    	
    	return true;
    }
}