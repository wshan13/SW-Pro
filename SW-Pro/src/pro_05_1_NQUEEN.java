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

		N = Integer.parseInt(br.readLine());		// 퀸의 개수 

		chessArray = new int[N][N];
		a = new int[N];		isUsed= new int[N];	
		f2(0);
		
	}
	
	/**
	 * N개의 숫자를 배열하는 모든 경우의 수를 탐색할 때 활용
	 * 모든 순열을 각 경우에 매칭 시켜 봄으로써 활용 가능
	 * @param w
	 */
	static void f2(int w) {
		if(w == N) {
			printArray(a);
			return;
		}
		
		for(int i = 0 ; i < N ; i++) {
			if(isUsed[i] == 1) {	// 사용했던 숫자면 패스 
				continue;
			}

			a[w] = i+1;	isUsed[i] = 1;	// 현재숫자 기입하고 사용여부 1처리
			f2(w+1);							// 숫자증가하여 재귀호출
			a[w] = 0;	isUsed[i] = 0;		// 초기화 
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
	 * N개의 물건이 있을 때 가능한 모든 사용하고 사용하지 않은 물건의 경우의 수를 구하는 방법
	 * (1이면 사용 / 0이면 사용 x)
	 * N중 중첩 for문을 활용해야 하기 때문에 재귀를 활용
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