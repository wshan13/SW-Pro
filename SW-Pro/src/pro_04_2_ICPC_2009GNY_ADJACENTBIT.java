import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * [문제]
 * 0과 1로 이루어진 수열 S가 주어진다. S의 첫 수를 s_1, 마지막 수를 s_N이라고 할 때, S의 인접한 비트의 개수는 다음과 같이 구할 수 있다.
 *  - s_1 x s_2 + s_2 x s_3 + s_3 x s4 + ... + s(N-1) x s_N
 * 
 * 위의 식을 이용하면 수열 S에서 인접한 1의 개수를 구할 수 있다. 예를들어, 011101101의 인접한 비트의 개수는 3이 되고, 111101101은 4, 010101010은 0이 된다.
 * 수열 S의 크기 N과 K가 주어졌을 때, 인접한 비트의 개수가 k인 수열 S의 개수를 구하는 프로그램을 작성하시오.
 * 
 * 예를 들어, N이 5이고, K가 2이면, 수열 S가 될 수 있는 수열은 다음과 같이 6가지가 있다.
 * 1.11100
 * 2.01110
 * 3.00111
 * 4.10111
 * 5.11101
 * 6.11011
 * 
 * [입력]
 * 첫 번째 줄에 테스트 케이스의 수 T가 주어진다. (1 ≤ T ≤ 1,000)
 * 각 테스트 케이스의 첫 번째 줄에 세 정수 t, N, K가 공백으로 분리되어 주어진다. t는 테스트 케이스의 번호이다. (1 ≤ N ≤ 100)
 * 
 * [출력]
 * 각 테스트 케이스에 대해 테스트 케이스 번호와 인접한 비트의 개수가 k인 수열 S의 개수를 사이에 공백을 두고 한 줄에 하나씩 출력한다.
 * 이 값은 2,147,483,647보다 작거나 같다.
 * 
 * [풀이 정리]
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