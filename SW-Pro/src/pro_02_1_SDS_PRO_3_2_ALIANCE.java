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

		int N = Integer.parseInt(br.readLine());		// 낙성마을 사람의 수 
		int Q = Integer.parseInt(br.readLine());		// 질의의 수
		
		root = new int[N+1];	// 사람별로 root를 저장할 배열 
		initArray(root);
		
		int result = 0;
		StringTokenizer st = null;
		
		for(int i = 0 ; i < Q ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int queryType = Integer.parseInt(st.nextToken());
			int person_a = Integer.parseInt(st.nextToken());
			int person_b = Integer.parseInt(st.nextToken());
			
			if(queryType == 0) {
				setAlianceRelation(person_a, person_b);	// 동맹관계 세팅 
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
	 * x가 속한 집합의 대표값 반환
	 * @param x
	 * @return
	 */
	static int find(int x) {
		if(root[x] == x) {
			return x;
		}
		return root[x] = find(root[x]);	// 좌표압축(중요!!!)
	}
	
	/**
	 *  동맹관계 세팅 = Union 연산
	 * @param person_a
	 * @param person_b
	 */
	static void setAlianceRelation(int person_a, int person_b) {
		
		int root_a = find(person_a);
		int root_b = find(person_b);
		
		if(root_a == root_b) {
			return;
		}
		
		root[root_b] = root_a;		// b의 root값에 a의 root값으로 교체한다. 
	}
	
	/**
	 * 두 사람의 동맹관계인가? = 두 사람의 root가 동일한가?
	 * @param person_a
	 * @param person_b
	 * @return
	 */
	static int getAlianceRelation(int person_a, int person_b) {
		return find(person_a) == find(person_b) ? 1 : 0;
	}
	
	/**
	 * root 배열을 초기화 한다. 
	 * @param arr
	 */
	static void initArray(int[] arr) {
		int len = arr.length;
		for(int i = 1 ; i < len ; i++) {
			arr[i] = i;
		}
	}
	
	/**
	 * root 배열을 출력한다.
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