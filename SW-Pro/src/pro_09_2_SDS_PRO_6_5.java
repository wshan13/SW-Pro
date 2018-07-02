import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class pro_09_2_SDS_PRO_6_5 {

	static int N;
	static int K;
	static int[][] stone;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_09_2_SDS_PRO_6_5.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());	// 보석 개수
		K = Integer.parseInt(st.nextToken());	// 가방 개수
		
		stone = new int[N][2];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			stone[i][0] = Integer.parseInt(st.nextToken());	// Mi	: 보석 무게
			stone[i][1] = Integer.parseInt(st.nextToken());	// Vi	: 보석 가격
		}
		
		Arrays.sort(stone, new Comparator<int[]>() {
			@Override
			public int compare(int[] args1, int[] args2) {
				return args1[1] < args2[1] ? 1 : -1;
			}
		});
		
		printArray();
		
		Stack<int[]> stack = new Stack<int[]>();
		for(int i = 0 ; i < N ; i++) {
			stack.push(stone[i]);
		}
		
		int[] bag = new int[K];
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			bag[i] = Integer.parseInt(st.nextToken());	// Ki	: 가방에 담을 수 있는 최대 무게
		}
		
		Arrays.sort(bag);

		int result = 0;
		
		// 가방 순서대로 체크
		for(int i = 0 ; i < K ; i++) {
			System.out.println(bag[i] + "가방 확인");
			
			for(int j = 0 ; j < N ; j++) {
				System.out.println(stone[j][0] + ", " + stone[j][1] + " 보석 확인");
				if(stone[j][0] < bag[i] && stone[j][1] != Integer.MAX_VALUE) {		// 가방이 더 크면 담는다.
					result += stone[j][1];
					System.out.println(stone[j][0] + ", " + stone[j][1] + " 보석 담기**");
					stone[j][1] = Integer.MAX_VALUE;
					break;
				}
			}
		}
		
		System.out.print(result);
	}
	
	static void printArray() {
		for(int i = 0 ; i < N ; i++) {
			System.out.println(stone[i][0] + " " + stone[i][1]);
		}
		System.out.println("");
	}
}