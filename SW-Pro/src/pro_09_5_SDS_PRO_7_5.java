import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pro_09_5_SDS_PRO_7_5 {

	static long a;
	static long m;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_09_5_SDS_PRO_7_5.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		a = Long.parseLong(st.nextToken());	// 정수 a
		m = Long.parseLong(st.nextToken());	// 지수 m
		
		System.out.print(pow(a, m)%mod);
	}
	
	static int mod = 1000000007;
	
	static long pow(long a, long m) {
		
		if(m == 0) {
			return 1;	// 모든 수의 0승은 1
		}
		
		long half = pow(a, m/2);
		long tmp = half*half%mod;
		return m%2 == 0 ? tmp : tmp*a%mod;
	}
}