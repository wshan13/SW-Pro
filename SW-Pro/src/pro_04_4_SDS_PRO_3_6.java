import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * [����]
 * ������ N�� �־�����. Ȧ����° ���� �־��� ������, ���ݱ��� �־��� ���� �߾Ӱ��� ���ϴ� ���α׷��� �ۼ��Ͽ���.
 * ���� ��� 1, 4, 5, 3, 6�� �־����ٸ�, ù��° ���� 1�� �Է¹��� �� �߾Ӱ��� 1�̰�, �� ��° ���� 5�� �Է¹��� �������� �߾Ӱ��� 4�̰�, �ټ���° ���� 6�� �Է¹��� �������� �߾Ӱ��� 4�̹Ƿ� 1, 4, 4�� ������� ����ϴ� ���̴�.
 * 
 * [�Է�]
 * ù ��° �ٿ� �־����� ������ ���� N�� �־�����. (1 �� N �� 99,999, N�� Ȧ��)
 * �� ��° �ٺ��� N���� �ٿ� ���� �� �ٿ� �ϳ��� ������ �־�����. (1 �� �־����� ���� �� 1,000,000,000)
 * 
 * [���]
 * Ȧ����° ���� �Է¹��� ������ �� ������ �Է¹��� �������� �߾Ӱ��� �� �ٿ� �ϳ��� ����Ѵ�.
 * 
 * [����]
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

		N = Integer.parseInt(br.readLine()); // �迭�� ũ��

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// printArray(arr);
		// System.out.println("");

		int mid = arr[0];

		bw.write(mid + "\n");

		for (int i = 1; i < N; i++) {

			// System.out.println(arr[i] + " ó��" );
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
					// System.out.println("upper�� ŭ. mid -> lower queue, upper queue's min -> mid");
					lower.add(mid);
					mid = upper.poll();
				} else if (upper.size() < lower.size()) {
					// System.out.println("lower�� ŭ. mid -> upper queue, lower queue's max -> mid");
					upper.add(mid);
					mid = lower.poll();
				} else if (upper.size() == lower.size()) {
					// System.out.println("������ ����.. ");
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