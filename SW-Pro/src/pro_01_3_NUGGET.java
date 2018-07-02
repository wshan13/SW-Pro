import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class pro_01_3_NUGGET {
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_01_3_NUGGET.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		
		int[] arrA = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N ; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		
		bw.write(result + "");
		bw.flush();
		bw.close();
	}
}