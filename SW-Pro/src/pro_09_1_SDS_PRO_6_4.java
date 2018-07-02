import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pro_09_1_SDS_PRO_6_4 {

	static int N;
	static int[] H;
	static int[] A;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_09_1_SDS_PRO_6_4.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());		// 풍선의 수
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		H = new int[N+1];
		for(int i = 1 ; i <= N ; i++ ) {
			H[i] = Integer.parseInt(st.nextToken());
		}
		
		A = new int[N+1];		// 화살 높이별 개수 
		
		int result = 0;
		printArray();

		// x 위치부터 좌에서 우로 계산
		for(int x = 1 ; x <= N ; x++) {
			if(A[H[x]] == 0) {		// x 위치에 해당하는 화살이 없으면 쏜다
				A[H[x]]++;	System.out.println(x + ", " + H[x] +" 위치에서 화살 쏘기");
				result++;
			} else {
				System.out.println(x + ", " + H[x] + " 지나가기");
			}
			printArray();
			A[H[x]-1]++;	
			A[H[x]]--;
		}
		
		System.out.print(result);
	}
	
	static void printArray() {
		for(int i = 1 ; i <= N ; i++ ) {
			System.out.print(H[i] + " ");
		}
		System.out.println("");
		for(int i = 1 ; i <= N ; i++ ) {
			System.out.print(A[i] + " ");
		}
		System.out.println("");
		System.out.println("----------");
	}
	
}