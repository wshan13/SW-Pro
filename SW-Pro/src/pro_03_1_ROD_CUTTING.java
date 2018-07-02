import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class pro_03_1_ROD_CUTTING {

	static int[] p;
	static int[] r;
	static int N;
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_03_1_ROD_CUTTING.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// 막대기의 길이 

		p = new int[N+1];			// 값어치 배열
		r = new int[N+1];			// 최대값 배열
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1 ; i <= N ; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		for(int x = 1 ; x <= N ; x++) {
			answer = dp(x);
		}
		bw.write(answer + "\n");

		bw.flush();
		bw.close();
	}
	
	
	static int dp(int x) {
		int max_r = -1;
		//System.out.println(x + " 호출");
		//System.out.println(" max { ");
		for(int i = 1 ; i <= x ; i++) {
			//System.out.println("  p[" + i + "] + r[" + (x-i) + "] = " + (p[i] + r[x-i]));
			if(max_r < p[i] + r[x-i]) {
				max_r = p[i] + r[x-i];
			}
		}
		r[x] = max_r; 
		//System.out.println(" }  : " + max_r);
		
		return max_r;
	}
}