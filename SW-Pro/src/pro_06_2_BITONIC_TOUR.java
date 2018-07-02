import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pro_06_2_BITONIC_TOUR {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_06_2_BITONIC_TOUR.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());	
		int[][] position = new int[N][2];
		
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			position[i][0] = Integer.parseInt(st.nextToken());
			position[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[][] D = new int[N][2];
		
		System.out.println(dist(position[0], position[1]));
	}
	
	static int dist(int[] x, int y[]) {
		return (x[0]-y[0])*(x[0]-y[0]);
	}
}