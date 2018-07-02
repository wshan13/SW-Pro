import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class pro_01_2_SORTED_ARRAY {
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_01_2_SORTED_ARRAY.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int[] arrA = new int[n];
		int[] arrB = new int[m];

		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < n ; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < m ; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		
		for(int i = 0 ; i < n ; i ++) {
			for(int j = 0 ; j < m ; j ++) {
				System.out.println("arrA[" + i + "] + arrB[" + j + "] == X, " + arrA[i] + " + " + arrB[j] + " == " + X);
				if(arrA[i] + arrB[j] == X) {
					result++;
				}
			}
		}

		bw.write(result + "");
		bw.flush();
		bw.close();
	}
}
