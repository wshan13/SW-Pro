import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pro_04_2_ICPC_2009GNY_ADJACENTBIT {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_04_2_ICPC_2009GNY_ADJACENTBIT.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCaseCnt = Integer.parseInt(br.readLine());		// �׽�Ʈ���̽� �� 
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());		// �׽�Ʈ���̽� ��ȣ
		int N = Integer.parseInt(st.nextToken());		// ������ ũ��
		int K = Integer.parseInt(st.nextToken());		// ������ ��Ʈ�� ���� 		
		
		
	}
}