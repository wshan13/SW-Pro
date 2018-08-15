import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * x x x x x 0 0 �� ������ ��Ʈ �� ���� x
 * x x x x x 1 0 �� ������ ��Ʈ �� ���� x
 * x x x x x 0 1 �� ������ ��Ʈ �� ���� x
 * x x x x x 1 1 �� ������ ��Ʈ �� ���� o
 * 
 * DP[N][K][E] : ũ�� N, ������ ��Ʈ �� K, E�� ������ DP �迭
 * 
 * ������ ��Ʈ�� 0, 1�� �����Ͽ� �Ʒ��� ���� ����ؾ� ��
 * DP[N][K][0] = DP[N-1][K][0] + DP[N-1][K][1]
 * DP[N][K][1] = DP[N-1][K][0] + DP[N-1][K-1][1]
 *
 */
public class pro_04_2_ICPC_2009GNY_ADJACENTBIT {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_04_2_ICPC_2009GNY_ADJACENTBIT.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCaseCnt = Integer.parseInt(br.readLine());		// �׽�Ʈ���̽� �� 
		
		for(int i = 0 ; i < testCaseCnt ; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int T = Integer.parseInt(st.nextToken());		// �׽�Ʈ���̽� ��ȣ
			int N = Integer.parseInt(st.nextToken());		// ������ ũ��
			int K = Integer.parseInt(st.nextToken());		// ������ ��Ʈ�� ���� 		
			
			int[][][] DP = new int[N+1][K+1][2];
			
			// �ʱⰪ
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