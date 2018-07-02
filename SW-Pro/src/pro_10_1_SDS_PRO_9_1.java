import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class pro_10_1_SDS_PRO_9_1 {
	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("pro_10_1_SDS_PRO_9_1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		double x[] = new double[N];
		double y[] = new double[N];
		
		for(int i = 0; i < N; i++) {
			String[] splits = br.readLine().split(" ");
				x[i] = Double.parseDouble(splits[0]);
				y[i] = Double.parseDouble(splits[1]);
		}
		
		double area1 = 0,area2 = 0;
		
		for(int i = 0; i < N; i++) {
			area1 += x[i] * y[(i!=N-1)?(i+1):0];
			area2 += y[i] * x[(i!=N-1)?(i+1):0];
		}
		System.out.println(Math.abs(area1-area2) / 2);
	}
}