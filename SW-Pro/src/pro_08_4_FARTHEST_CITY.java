import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class pro_08_4_FARTHEST_CITY {

	static int N;
	static int[][] distance;
	static boolean[] visited;
	static Stack<Integer> stack ;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_08_4_FARTHEST_CITY.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());		// 도시의 수 N
		distance = new int[N][N]; 
		
		StringTokenizer st;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				distance[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		printArray();
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(i != j) {
					visited = new boolean[N];
					stack = new Stack<Integer>();
					//stack.push(i);
					System.out.println(i + "→" + j + " 가는 방법 구하기");
					dfs(i, j, stack);
				}
			}
		}
	}
	
	/**
	 * x에서 y까지가는 경우
	 * @param x
	 * @param y
	 */
	static void dfs(int x, int y, Stack<Integer> init) {
		System.out.println(" " + x + ", " + y);
		
		for(int i = 0 ; i < N ; i++) {
			if(i != x) {
				System.out.println(" " + i);
			}
		}
	}
	
	static void printArray() {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				System.out.print(distance[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
}