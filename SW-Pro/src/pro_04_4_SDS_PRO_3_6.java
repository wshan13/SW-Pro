import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pro_04_4_SDS_PRO_3_6 {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_04_4_SDS_PRO_3_6.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());		// 배열의 크기 

		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(arr[0]);
		
		int[] tmp = Arrays.copyOf(arr, 3);
		Arrays.sort(tmp);
		System.out.println(tmp[1]);
		
		for(int i = 3 ; i < N ; i = i+2) {
			//System.out.println(i + ", " + arr[i] + ", "+arr[i+1]+"삽입");
			//printArray(tmp);
			tmp = insert(arr[i], arr[i+1], tmp);
			System.out.println(tmp[1]);
		}
	}
	
	static int[] insert(int x, int y, int[] source) {
		
		int[] tmp = new int[source.length+2];
		
		for(int i = 0 ; i < 3 ; i++) {
			tmp[i] = source[i];
		}
		
		tmp[3] = x;
		tmp[4] = y;
		
		Arrays.sort(tmp);
		
		return new int[] {tmp[1], tmp[2], tmp[3]};
	}
	
	static void printArray(int[] tmp) {
		System.out.println("[" + tmp[0] + ", " + tmp[1] + ", " + tmp[2] + "]");
	}
}