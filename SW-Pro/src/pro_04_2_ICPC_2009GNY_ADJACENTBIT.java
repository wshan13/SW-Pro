import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * x x x x x 0 0 → 인접한 비트 수 증가 x
 * x x x x x 1 0 → 인접한 비트 수 증가 x
 * x x x x x 0 1 → 인접한 비트 수 증가 x
 * x x x x x 1 1 → 인접한 비트 수 증가 o
 * 
 * DP[N][K][E] : 크기 N, 인접한 비트 수 K, E로 끝나는 DP 배열
 * 
 * 마지막 비트가 0, 1을 구분하여 아래와 같이 계산해야 함
 * DP[N][K][0] = DP[N-1][K][0] + DP[N-1][K][1]
 * DP[N][K][1] = DP[N-1][K][0] + DP[N-1][K-1][1]
 *
 */
public class pro_04_2_ICPC_2009GNY_ADJACENTBIT {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_04_2_ICPC_2009GNY_ADJACENTBIT.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCaseCnt = Integer.parseInt(br.readLine());		// 테스트케이스 수 
		
		for(int i = 0 ; i < testCaseCnt ; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int T = Integer.parseInt(st.nextToken());		// 테스트케이스 번호
			int N = Integer.parseInt(st.nextToken());		// 수열의 크기
			int K = Integer.parseInt(st.nextToken());		// 인접한 비트의 개수 		
			
			int[][][] DP = new int[N+1][K+1][2];
			
			// 초기값
			DP[1][0][0] =1;
			DP[1][0][1] =1;
			
			for(int n = 2 ; n <= N ; n++) {
				for(int k = 0 ; k <= K ; k++) {
					DP[n][k][0] = DP[n-1][k][0] + DP[n-1][k][1];
					DP[n][k][1] = DP[n-1][k][0] + (k > 0 ? DP[n-1][k-1][1] : 0);
					//System.out.println("DP[" + n + "][" + k + "][0] : " + DP[n][k][0]);
					//System.out.println("DP[" + n + "][" + k + "][1] : " + DP[n][k][1]);
				}
			}

			System.out.println(T + " " + (DP[N][K][0] + DP[N][K][1]));	
		}
	}
}