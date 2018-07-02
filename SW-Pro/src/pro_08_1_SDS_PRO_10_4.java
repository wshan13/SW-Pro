import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class pro_08_1_SDS_PRO_10_4 {

	static int N;
	static int M;
	static int[] root;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_08_1_SDS_PRO_10_4.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());		// ������ �� N
		M = Integer.parseInt(br.readLine());		// ���� �ĺ��� �� M
		
		int[][] costInfo = new int[M+1][3];

		StringTokenizer st;
		for(int i = 1 ; i <= M ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());	// s�� ����
			int e = Integer.parseInt(st.nextToken());	// e�� ����
			int c = Integer.parseInt(st.nextToken());	// c : s~e ���� �Ǽ����
			costInfo[i][0] = s;
			costInfo[i][1] = e;
			costInfo[i][2] = c;
		}
		
		Arrays.sort(costInfo, new Comparator<int[]>() {
			@Override
			public int compare(int[] arg1, int[] arg2) {
				return arg1[2] > arg2[2] ? 1 : -1;
			}
		});

		//printCostInfoArray(costInfo);
		
		root = new int[N+1]; 
		for(int i = 1 ; i <= N ; i++) {
			root[i] = i;
		}
		
		int minCost = 0;
		
		for(int i = 1 ; i <= M ; i++) {
			//System.out.print(costInfo[i][0] + " -  " + costInfo[i][1] + " [" + costInfo[i][2] + "] ����");
			int pa = find(costInfo[i][0]);
			int pb = find(costInfo[i][1]);
			
			if(pa == pb) {	// �θ� �����ϸ� �н��ϰ�
				//System.out.println(" pass");
				continue;
			}
			
			root[pb] = pa;	// b�� �θ��� pa(a�� �θ�)�� ����
			minCost += costInfo[i][2];	// ����ջ�
			//System.out.println(" choose");
		}
		

		System.out.print(minCost);
	}
	
	/** 
	 * �θ� ã�� �Լ�
	 * @param x
	 * @return
	 */
	static int find(int x) {
		if(x == root[x]) {
			return x;
		} 
		return root[x] = find(root[x]);
	}
	
	static void printCostInfoArray(int[][] costInfo) {
		System.out.println("CostInfoArray = { ");
		for(int i = 1 ; i <= M ; i++) {
			System.out.println(" { " + costInfo[i][0] + ", " + costInfo[i][1] + ", " + costInfo[i][2] + " }");
		}
		System.out.println("} ");
	}
}