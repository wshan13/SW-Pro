import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
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
		
		// �ʱⰪ deque�� ����
		Deque<Integer> minDeque = new ArrayDeque<>();
		minDeque.push(min);
		Deque<Integer> maxDeque = new ArrayDeque<>();
		maxDeque.push(max);

		// sliding window ó��
		int pop;	// ������ �� 
		int push;	// ������ ��
		
		for(int x = 1 ; x <= N-K ; x++) {

			pop = dataArray[x-1];		// ������ �� 
			push = dataArray[x+K-1];	// ������ ��
			
			min = getMin(minDeque, pop, push);
			max = getMax(maxDeque, pop, push);
			sum = sum-pop+push;
			
			bw.write(min + " " + max + " " + sum + "\n");
		}

		bw.flush();
		bw.close();
	}
	
	static int getMin(int[] arr) {
		return arr[0];
	}
	
	static int getMin(Deque<Integer> minDeque, int pop, int push) {
		System.out.println("minDeque : " + minDeque);
		System.out.println("out : " + pop);
		System.out.println("in : " + push);

		// ���� ù��° ���� ������ ������ ũ�� ����ؼ� �����ϰ�
		while(!minDeque.isEmpty() && minDeque.peekFirst() > push) {
			minDeque.removeFirst();
		}
		
		// ������ ���� ���� ���ʿ� �ִ´�.
		minDeque.addFirst(push);
		
		System.out.println("minDeque : " + minDeque);
		System.out.println("minDeque lowest : " + minDeque.peekFirst());

		return minDeque.peekFirst();
	}
	
	static int getMax(int[] arr) {
		return arr[arr.length-1];
	}
	
	static int getMax(Deque<Integer> maxDeque, int pop, int push) {
		//System.out.println("out : " + pop);
		//System.out.println("in : " + push);
		//System.out.println("maxDeque : " + maxDeque);
		//System.out.println("maxDeque highest : " + maxDeque.peekLast());
		
		if(maxDeque.peekLast() < push) {
			maxDeque.removeLast();
			maxDeque.addLast(push);
		} else {
			if(maxDeque.peekFirst() < push) {
				maxDeque.removeFirst();
			}
			maxDeque.addFirst(push);
		}

		if(maxDeque.peekLast() == pop) {
			maxDeque.removeLast();
		}
		
		return maxDeque.peekLast();
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