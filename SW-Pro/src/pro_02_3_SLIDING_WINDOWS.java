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
		int N = Integer.parseInt(st.nextToken());	// �迭�� ũ��
		int K = Integer.parseInt(st.nextToken());	// �κй迭�� ũ��
		
		int[] dataArray = new int[N]; 
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N ; i++) {
			dataArray[i] = Integer.parseInt(st.nextToken());
		}

		// �ʱⰪ ����
		int[] dataArrayInit = Arrays.copyOf(dataArray, K);
		Arrays.sort(dataArrayInit);
		int min = getMin(dataArrayInit);
		int max = getMax(dataArrayInit);
		int sum = getSum(dataArrayInit);
		bw.write(min + " " + max + " " + sum + "\n");

		// sliding window ó��
		int pop;	// ������ �� 
		int push;	// ������ ��
		
		for(int x = 1 ; x <= N-K ; x++) {

			pop = dataArray[x-1];		// ������ �� 
			push = dataArray[x+K-1];	// ������ ��
			
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
		
		if(currMin <= pop) {	// ������ ���� ���� �ּҰ� ���� ũ�� ����
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