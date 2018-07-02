import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class pro_06_3_DOWNHILL {

	static int N;
	static int M;
	static int[][] moves = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("pro_06_3_DOWNHILL.txt"));
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();

		int[][] maps = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				maps[i][j] = sc.nextInt();
			}
		}
		sc.close();

		// �湮�Ѱ� ó���� ���� -1�� �ʱ�ȭ
		int[][] dp = new int[M][N];
		for (int[] arr : dp)
			Arrays.fill(arr, -1);

		// �������� Ȯ��
		dp[M - 1][N - 1] = 1;

		findWay(maps, dp, 0, 0);

		System.out.print(dp[0][0]);

	}

	public static int findWay(int[][] maps, int[][] dp, int x, int y) {

		// ���� ����
		if (x == M - 1 && y == N - 1)
			return 1;

		// �̹� ó���� ��
		if (dp[x][y] >= 1 )
			return dp[x][y];

		// �湮 ó��
		if (dp[x][y] == -1) {
			dp[x][y] = 0;
		}

		for (int i = 0; i < moves.length; i++) {

			int nextX = x + moves[i][0];
			int nextY = y + moves[i][1];

			if (0 <= nextX && nextX < maps.length && 0 <= nextY && nextY < maps[0].length && maps[x][y] > maps[nextX][nextY]) {
				dp[x][y] += findWay(maps, dp, nextX, nextY);
			}
		}

		return dp[x][y];
	}
}