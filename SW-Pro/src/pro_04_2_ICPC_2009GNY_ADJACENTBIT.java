import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pro_04_2_ICPC_2009GNY_ADJACENTBIT {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_04_2_ICPC_2009GNY_ADJACENTBIT.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCaseCnt = Integer.parseInt(br.readLine());		// 테스트케이스 수 
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());		// 테스트케이스 번호
		int N = Integer.parseInt(st.nextToken());		// 수열의 크기
		int K = Integer.parseInt(st.nextToken());		// 인접한 비트의 개수 		
		
		
	}
}