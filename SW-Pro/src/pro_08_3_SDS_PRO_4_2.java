import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class pro_08_3_SDS_PRO_4_2 {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_08_3_SDS_PRO_4_2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(br.readLine().split(" ")[0]);
	}
}