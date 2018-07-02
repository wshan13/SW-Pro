import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class pro_02_1_SDS_PRO_3_2_ALIANCE {
	
	static int[] root;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_02_1_SDS_PRO_3_2_ALIANCE.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());		// �������� ����� �� 
		int Q = Integer.parseInt(br.readLine());		// ������ ��
		
		root = new int[N+1];	// ������� root�� ������ �迭 
		initArray(root);
		
		int result = 0;
		StringTokenizer st = null;
		
		for(int i = 0 ; i < Q ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int queryType = Integer.parseInt(st.nextToken());
			int person_a = Integer.parseInt(st.nextToken());
			int person_b = Integer.parseInt(st.nextToken());
			
			if(queryType == 0) {
				setAlianceRelation(person_a, person_b);	// ���Ͱ��� ���� 
			}
			
			if(queryType == 1) {
				result = getAlianceRelation(person_a, person_b);
				bw.write(result + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}

	/**
	 * x�� ���� ������ ��ǥ�� ��ȯ
	 * @param x
	 * @return
	 */
	static int find(int x) {
		if(root[x] == x) {
			return x;
		}
		return root[x] = find(root[x]);	// ��ǥ����(�߿�!!!)
	}
	
	/**
	 *  ���Ͱ��� ���� = Union ����
	 * @param person_a
	 * @param person_b
	 */
	static void setAlianceRelation(int person_a, int person_b) {
		
		int root_a = find(person_a);
		int root_b = find(person_b);
		
		if(root_a == root_b) {
			return;
		}
		
		root[root_b] = root_a;		// b�� root���� a�� root������ ��ü�Ѵ�. 
	}
	
	/**
	 * �� ����� ���Ͱ����ΰ�? = �� ����� root�� �����Ѱ�?
	 * @param person_a
	 * @param person_b
	 * @return
	 */
	static int getAlianceRelation(int person_a, int person_b) {
		return find(person_a) == find(person_b) ? 1 : 0;
	}
	
	/**
	 * root �迭�� �ʱ�ȭ �Ѵ�. 
	 * @param arr
	 */
	static void initArray(int[] arr) {
		int len = arr.length;
		for(int i = 1 ; i < len ; i++) {
			arr[i] = i;
		}
	}
	
	/**
	 * root �迭�� ����Ѵ�.
	 * @param arr
	 */
	static void printArray(int[] arr) {
		System.out.println("***********");
		int len = arr.length;
		for(int i = 1 ; i < len ; i++) {
			System.out.println(i + " : " + arr[i]);
		}
		System.out.println("***********");
	}
}