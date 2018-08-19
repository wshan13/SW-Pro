import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pro_04_5_SDS_PRO_3_5 {

	static int N;				// ������ ����
	static int Q;				// ������ ����
	static int[] sequence;	// ���� N�� ����
	static boolean debug = false;
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_04_5_SDS_PRO_3_5.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());		// ������ ����
		Q = Integer.parseInt(br.readLine());		// ������ ����

		StringTokenizer st;
		int[][] queryInfo = new int[3][Q];
		for(int i = 0 ; i < Q ; i++) {
			 st = new StringTokenizer(br.readLine(), " ");
			 queryInfo[0][i] = Integer.parseInt(st.nextToken());
			 queryInfo[1][i] = Integer.parseInt(st.nextToken());
			 queryInfo[2][i] = Integer.parseInt(st.nextToken());
		}
		
		sequence = new int[N+1];
		for(int i = 1 ; i <= N ; i++) {
			sequence[i] = i;	// �ʱ�ȭ
		}
		if(debug) printArray();

		int idx_start = 0;
		int idx_end = 0;
		long sum = 0;
		boolean t = false;
		
		for(int i = 0 ; i < Q ; i++) {
			if(debug) System.out.println(queryInfo[0][i] + " " + queryInfo[1][i] + " " + queryInfo[2][i]);
			 if(queryInfo[0][i] == 0) {	// �� ����
				 // �����ҷ��� ���� ��ġ�� ������ �������� ������ sum���� �������ش�.
				 if(t && idx_start <= queryInfo[1][i] && queryInfo[1][i] <= idx_end) {
					 sum = sum - sequence[queryInfo[1][i]];
					 sum = sum + queryInfo[2][i];
				 }
				 sequence[queryInfo[1][i]] = queryInfo[2][i];
			 }

			 if(queryInfo[0][i] == 1) {	// ������( queryInfo[1][i] ~ queryInfo[2][i] )
				 if(i == 0) {
					 sum = sumInteval(queryInfo[1][i], queryInfo[2][i]);
					 t = true;
				 } else {
					 if(queryInfo[1][i] < idx_start) {	// �������� �������� ���� ���� ������ �����ش�.
						 if(debug) System.out.println("** 1");
						 for(int x = queryInfo[1][i] ; x < idx_start ; x++) {
							 sum += sequence[x];
						 }
					 }
					 if(idx_start < queryInfo[1][i]) {	// �������� ���������� ���� ���� ������ ���ش�.
						 if(debug) System.out.println("** 2");
						 for(int x = idx_start+1 ; x <= queryInfo[1][i] ; x++) {
							 sum -= sequence[x];
						 }
					 }
					 if(queryInfo[2][i] < idx_end) {	// �������� �������� ���� ���� ������ ���ش�.
						 if(debug) System.out.println("** 3");
						 for(int x = queryInfo[2][i] ; x < idx_end ; x++) {
							 sum -= sequence[x];
						 }
					 }
					 if(idx_end < queryInfo[2][i]) {	// �������� ���������� ���� ���� ������ �����ش�.
						 if(debug) System.out.println("** 4");
						 for(int x = idx_end+1 ; x <= queryInfo[2][i] ; x++) {
							 sum += sequence[x];
						 }
					 }
				 }
				 
				 idx_start = queryInfo[1][i];
				 idx_end = queryInfo[2][i];
				 System.out.println(sum);
			 }
		}
		//printArray();		
	}
	
	static int sumInteval(int start, int end) {
		int result = 0;
		for(int i = start ; i <= end ; i++) {
			result += sequence[i];
		}
		return result;
	}
	
	static void printArray() {
		System.out.print("sequence : ");
		for(int i = 1 ; i <= N ; i++) {
			System.out.print(sequence[i] + " ");
		}
		System.out.println("");
	}
}