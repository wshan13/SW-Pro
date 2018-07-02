import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pro_04_5_SDS_PRO_3_5 {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_04_5_SDS_PRO_3_5.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());		// 정수의 개수
		int Q = Integer.parseInt(br.readLine());		// 질의의 개수

		StringTokenizer st;
		int[][] queryInfo = new int[3][Q];
		for(int i = 0 ; i < Q ; i++) {
			 st = new StringTokenizer(br.readLine(), " ");
			 queryInfo[0][i] = Integer.parseInt(st.nextToken());
			 queryInfo[1][i] = Integer.parseInt(st.nextToken());
			 queryInfo[2][i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0 ; i < Q ; i++) {
			 System.out.println(queryInfo[0][i] + " " + queryInfo[1][i] + " " + queryInfo[2][i]);
		}
	}
}