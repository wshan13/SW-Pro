import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pro_02_3_SLIDING_WINDOWS {

	static int[] postion;
	static int[] answer;
	static int min_postion;
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_02_3_SLIDING_WINDOWS.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	// 배열의 크기
		int K = Integer.parseInt(st.nextToken());	// 부분배열의 크기
		
		int[] dataArray = new int[N]; 
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N ; i++) {
			dataArray[i] = Integer.parseInt(st.nextToken());
		}

		// 초기값 세팅
		int[] dataArrayInit = Arrays.copyOf(dataArray, K);
		Arrays.sort(dataArrayInit);
		int min = getMin(dataArrayInit);
		int max = getMax(dataArrayInit);
		int sum = getSum(dataArrayInit);
		bw.write(min + " " + max + " " + sum + "\n");

		// sliding window 처리
		int pop;	// 나가는 값 
		int push;	// 들어오는 값
		
		for(int x = 1 ; x <= N-K ; x++) {

			pop = dataArray[x-1];		// 나가는 값 
			push = dataArray[x+K-1];	// 들어오는 값
			
			min = getMin(min, pop, push);
			max = getMax(min, pop, push);
			sum = sum-pop+push;
			
			bw.write(min + " " + max + " " + sum + "\n");
		}

		bw.flush();
		bw.close();
	}
	
	static int getMin(int[] arr) {
		return arr[0];
	}
	
	static int getMin(int currMin, int pop, int push) {
		
		if(currMin <= pop) {	// 나가는 값이 현재 최소값 보다 크면 무시
			return currMin;
		} else {
			
		}
		return currMin;
	}
	
	static int getMax(int[] arr) {
		return arr[arr.length-1];
	}
	
	static int getMax(int currMax, int pop, int push) {
		return currMax;
	}
	
	static int getSum(int[] arr) {
		int len = arr.length;
		int sum = 0;
		
		for(int i = 0 ; i < len ; i++) {
			sum += arr[i];
		}
		return sum;
	}
}