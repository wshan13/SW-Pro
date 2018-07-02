import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pro_04_3_MAX_SUBARRAY {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_04_3_MAX_SUBARRAY.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());		// 배열의 크기 
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		int sum = 0;
		for(int i = 0 ; i < N ; i++) {
			sum = arr[i];
			for(int j = 1 ; j < N ; j++) {
				if(i < j) {
					System.out.println(i + " ~ " + j + " 계산. \tmax [" + max + "],\tarr["+ j +"] : " + arr[j] + "\tsum[" + sum + "]");
					sum = sum+arr[j];
					if(max < sum) {
						max = sum;
					}
				}
			}
			System.out.println("");
		}
		System.out.print(max);
	}
}