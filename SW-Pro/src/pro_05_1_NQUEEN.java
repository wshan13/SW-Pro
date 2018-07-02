import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class pro_05_1_NQUEEN {

	static int[][] chessArray;
	static int N;
	static int[] a;
	static int[] isUsed;
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_05_1_NQUEEN.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());		// ���� ���� 

		chessArray = new int[N][N];
		a = new int[N];		isUsed= new int[N];	
		f2(0);
		
	}
	
	/**
	 * N���� ���ڸ� �迭�ϴ� ��� ����� ���� Ž���� �� Ȱ��
	 * ��� ������ �� ��쿡 ��Ī ���� �����ν� Ȱ�� ����
	 * @param w
	 */
	static void f2(int w) {
		if(w == N) {
			printArray(a);
			return;
		}
		
		for(int i = 0 ; i < N ; i++) {
			if(isUsed[i] == 1) {	// ����ߴ� ���ڸ� �н� 
				continue;
			}

			a[w] = i+1;	isUsed[i] = 1;	// ������� �����ϰ� ��뿩�� 1ó��
			f2(w+1);							// ���������Ͽ� ���ȣ��
			a[w] = 0;	isUsed[i] = 0;		// �ʱ�ȭ 
		}
	}
	
	static void printArray(int[] array) {
		for(int i = 0 ; i < N ; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}
	
	static void printArray(int[][] array) {
		int len = array.length;
		for(int i = 0 ; i < len ; i++) {
			for(int j = 0 ; j < len ; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	/**
	 * N���� ������ ���� �� ������ ��� ����ϰ� ������� ���� ������ ����� ���� ���ϴ� ���
	 * (1�̸� ��� / 0�̸� ��� x)
	 * N�� ��ø for���� Ȱ���ؾ� �ϱ� ������ ��͸� Ȱ��
	 * @param w
	 */
	static void f(int w) {
		if(w == N) {
			for(int i = 0 ; i < N ; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println("");
			return;
		}
		for(int i = 0 ; i < 2 ; i++) {
			a[w] = i;
			f(w+1);
		}
	}	
}