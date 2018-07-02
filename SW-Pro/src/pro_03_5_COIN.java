import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pro_03_5_COIN {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_03_5_COIN.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] coinArray = new int[N];
		for(int i = 0 ; i < N ; i++) {
			coinArray[i] = Integer.parseInt(st.nextToken());
		}
		
		int W = Integer.parseInt(br.readLine());
		
		int[] dp = new int[W+1];		// dp[i] = i 잔돈을 내주는 최소 동전의 수 
		for(int i = 1 ; i <= W ; i++) {
			dp[i] = Integer.MAX_VALUE-1;		// dp[0] = 0, dp[1] = 무한값을 초기값 설정 필요
		}
		
		// dp [ i ] = min ( dp [ i - c [ j ] ] + 1 ]
		for(int i = 1 ; i <= W ; i++) {
			for(int j = 0 ; j < N ; j++) {
				//System.out.println(i + "잔돈, " + coinArray[j] + "원");
				if(i < coinArray[j]) {
					continue;
				}
				//System.out.println(" dp[" + i + "] " + dp[i] + ", dp[" + i + " - " + coinArray[j] + "] : " + dp[i - coinArray[j]]);
				dp[i] = Math.min(dp[i], dp[i - coinArray[j]]+1);
			}
			//System.out.println("→" + dp[i]);
			//System.out.println("");
		}
		System.out.print(dp[W]);
	}
}