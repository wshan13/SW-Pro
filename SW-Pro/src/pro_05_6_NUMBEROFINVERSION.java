import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pro_05_6_NUMBEROFINVERSION {

	static int N;		// 순열의 길이
	static int[] D;	// 순열의 원소배열
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_05_6_NUMBEROFINVERSION.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); 
		D = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N ; i++) {
			D[i] = Integer.parseInt(st.nextToken());
		}
		
		int inversionCnt = 0;
		for(int i = 0 ; i < N-1 ; i++) {
			for(int j = i+1 ; j < N ; j++) {
				System.out.println(i + " - " + j + " 구간 검사");
				if(D[i] > D[j]) {
					inversionCnt++;
				}
			}
		}
		
		System.out.print(inversionCnt);
	}
}