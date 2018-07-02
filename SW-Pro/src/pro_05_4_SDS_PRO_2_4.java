import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class pro_05_4_SDS_PRO_2_4 {

	static int N;
	static int[] s;
	static int[][] cnt;
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_05_4_SDS_PRO_2_4.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); 
		s = new int[N];
		cnt = new int[N][2];
		
		for(int i = 0 ; i < N ; i++) {
			s[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(s);
		//printArray();
		
		cnt[0][0] = s[0]; cnt[0][1] = 1; int cnt_idx = 0; 
		
		for(int i = 1 ; i < N ; i++) {
			if(s[i-1] == s[i]) {
				cnt[cnt_idx][1] += 1;
			} else {
				cnt_idx++;
				cnt[cnt_idx][0] = s[i];
				cnt[cnt_idx][1] = 1;
			}
		}
		//printArray2();
		
		Arrays.sort(cnt, new Comparator<int []>() {
			@Override
			public int compare(int[] i1, int[] i2) {
				if(i1[1] == i2[1]) {
					return i1[0] > i2[0] ? 1 : -1;
				} else {
					return i1[1] < i2[1] ? 1 : -1;
				}
			}
		});
		
		//printArray2();
		
		System.out.print(cnt[0][0]);
	}
	
	static void printArray() {
		for(int i = 0 ; i < N ; i++) {
			System.out.print(s[i] + " ");
		}
		System.out.println("");
	}
	
	static void printArray2() {
		for(int i = 0 ; i < N ; i++) {
			System.out.println("{" + cnt[i][0] + " , " + cnt[i][1] + "}");
		}
		System.out.println("");
	}

}