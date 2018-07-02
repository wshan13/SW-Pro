import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pro_07_3_SDS_PRO_10_3 {

	static int N;
	static int M;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_07_3_SDS_PRO_10_3.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 행성의 개수 N
		M = Integer.parseInt(st.nextToken()); // 워프장치의 개수 M

		short[][] warpInfo = new short[N+1][N+1];

		int x, y, v;
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			warpInfo[x][y] = (short) v;
		}
		//printWarpInfo(warpInfo);
		
		long[] D = new long[N+1];	// N번 행성에 도달하는 최소의 시간
		D[1] = 0;
		for(int i = 2 ; i < N+1 ; i++) {
			D[i] = 100000;
		}
		
		for(int i = 2 ; i <= M ; i++) {
			//System.out.println("D[" + i + "]");
			for(int j = 1 ; j < i ; j++) {
				//System.out.println("  D[" + j + "] + " + warpInfo[j][i]);
				D[i] = Math.min(D[i], D[j] + warpInfo[j][i]);
			}
		}
		System.out.print(D[N]);
		
	}
	
	static void printWarpInfo(int[][] warpInfo) {
		for(int i = 1 ; i <= M ; i++) {
			for(int j = 1 ; j <= M ; j++) {
				System.out.print(warpInfo[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
}