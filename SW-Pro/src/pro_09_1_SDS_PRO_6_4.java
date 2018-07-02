import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pro_09_1_SDS_PRO_6_4 {

	static int N;
	static int[] H;
	static int[] A;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_09_1_SDS_PRO_6_4.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());		// ǳ���� ��
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		H = new int[N+1];
		for(int i = 1 ; i <= N ; i++ ) {
			H[i] = Integer.parseInt(st.nextToken());
		}
		
		A = new int[N+1];		// ȭ�� ���̺� ���� 
		
		int result = 0;
		printArray();

		// x ��ġ���� �¿��� ��� ���
		for(int x = 1 ; x <= N ; x++) {
			if(A[H[x]] == 0) {		// x ��ġ�� �ش��ϴ� ȭ���� ������ ���
				A[H[x]]++;	System.out.println(x + ", " + H[x] +" ��ġ���� ȭ�� ���");
				result++;
			} else {
				System.out.println(x + ", " + H[x] + " ��������");
			}
			printArray();
			A[H[x]-1]++;	
			A[H[x]]--;
		}
		
		System.out.print(result);
	}
	
	static void printArray() {
		for(int i = 1 ; i <= N ; i++ ) {
			System.out.print(H[i] + " ");
		}
		System.out.println("");
		for(int i = 1 ; i <= N ; i++ ) {
			System.out.print(A[i] + " ");
		}
		System.out.println("");
		System.out.println("----------");
	}
	
}