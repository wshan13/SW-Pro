import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * [문제]
 * 정수가 N개 주어진다. 홀수번째 수가 주어질 때마다, 지금까지 주어진 수의 중앙값을 구하는 프로그램을 작성하여라.
 * 예를 들어 1, 4, 5, 3, 6가 주어진다면, 첫번째 수인 1을 입력받을 때 중앙값이 1이고, 세 번째 수인 5를 입력받을 때까지의 중앙값이 4이고, 다섯번째 수인 6을 입력받을 때까지의 중앙값이 4이므로 1, 4, 4를 순서대로 출력하는 것이다.
 * 
 * [입력]
 * 첫 번째 줄에 주어지는 정수의 개수 N이 주어진다. (1 ≤ N ≤ 99,999, N은 홀수)
 * 두 번째 줄부터 N개의 줄에 걸쳐 각 줄에 하나씩 정수가 주어진다. (1 ≤ 주어지는 정수 ≤ 1,000,000,000)
 * 
 * [출력]
 * 홀수번째 수를 입력받을 때마다 그 때까지 입력받은 정수들의 중앙값을 한 줄에 하나씩 출력한다.
 * 
 * [참고]
 * http://blog.naver.com/PostView.nhn?blogId=kks227&logNo=220791188929
 * 
 */
public class pro_04_4_SDS_PRO_3_6 {

	static int N;
	static PriorityQueue<Integer> upper = new PriorityQueue<>(10, new Comparator<Integer>() {
		@Override
		public int compare(Integer arg1, Integer arg2) {
			return arg1.compareTo(arg2);
		}
	});
	static PriorityQueue<Integer> lower = new PriorityQueue<>(10, new Comparator<Integer>() {
		@Override
		public int compare(Integer arg1, Integer arg2) {
			return arg2.compareTo(arg1);
		}
	});

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_04_4_SDS_PRO_3_6.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine()); // 배열의 크기

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// printArray(arr);
		// System.out.println("");

		int mid = arr[0];

		bw.write(mid + "\n");

		for (int i = 1; i < N; i++) {

			// System.out.println(arr[i] + " 처리" );
			if (mid < arr[i]) {
				upper.add(arr[i]);
			} else {
				lower.add(arr[i]);
			}

			// System.out.println("upper queue : " + upper);
			// System.out.println("mid : " + mid);
			// System.out.println("lower queue : " + lower);

			if (i % 2 == 0) {
				if (upper.size() > lower.size()) {
					// System.out.println("upper가 큼. mid -> lower queue, upper queue's min -> mid");
					lower.add(mid);
					mid = upper.poll();
				} else if (upper.size() < lower.size()) {
					// System.out.println("lower가 큼. mid -> upper queue, lower queue's max -> mid");
					upper.add(mid);
					mid = lower.poll();
				} else if (upper.size() == lower.size()) {
					// System.out.println("사이즈 동일.. ");
				}
				// System.out.println("upper queue : " + upper);
				// System.out.println("mid : " + mid);
				// System.out.println("lower queue : " + lower);
				bw.write(mid + "\n");
			}
			// System.out.println("");
		}

		bw.flush();
		bw.close();
	}

	static void printArray(int[] tmp) {
		for (int i = 0; i < N; i++) {
			System.out.println(tmp[i]);
		}
	}
}