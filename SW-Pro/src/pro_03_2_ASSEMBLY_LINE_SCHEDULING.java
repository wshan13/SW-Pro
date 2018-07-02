import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class pro_03_2_ASSEMBLY_LINE_SCHEDULING {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_03_2_ASSEMBLY_LINE_SCHEDULING.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());	// 라인별 공정의 갯수
		int e1 = Integer.parseInt(st.nextToken());	// 진입 시간
		int e2 = Integer.parseInt(st.nextToken());	// 진입 시간
		int x1 = Integer.parseInt(st.nextToken());	// 마무리 시간
		int x2 = Integer.parseInt(st.nextToken());	// 마무리 시간

		int[] S1 = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < n ; i++) {
			S1[i] = Integer.parseInt(st.nextToken());
		}

		int[] S2 = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < n ; i++) {
			S2[i] = Integer.parseInt(st.nextToken());
		}

		int[] t1 = new int[n-1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < n-1 ; i++) {
			t1[i] = Integer.parseInt(st.nextToken());
		}

		int[] t2 = new int[n-1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < n-1 ; i++) {
			t2[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		bw.write(answer + "\n");

		bw.flush();
		bw.close();
	}

	static void printArray(int[] arr) {
		int len = arr.length;
		for(int i = 0 ; i < len ; i++) {
			System.out.print (arr[i] + " ");
		}
		System.out.println("");
	}
}