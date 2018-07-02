import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class pro_02_2_SDS_PRO_3_4_TOWER {

	static int[] postion;
	static Stack<Integer> stack_position = new Stack<Integer>();
	static Stack<Integer> stack_height = new Stack<Integer>();
	static int min_postion;
	static int tmp;
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_02_2_SDS_PRO_3_4_TOWER.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());		// 탑의  수 
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		postion = new int[N];
		for(int i = 0 ; i < N ; i++) {
			postion[i] = Integer.parseInt(st.nextToken());
			if(i > 0 && postion[i-1] < postion[i]) {	// 현재 값이 이전값보다 크다면 기존값을 제거
				stack_position.pop();
				stack_height.pop();
			}
			stack_position.add(i);
			stack_height.add(postion[i]);
		}
		
		tmp = stack_position.firstElement();
		System.out.println(stack_position);
		System.out.println(stack_height);
		
		for(int j = 0 ; j < N ; j++) {
			//bw.write(getTowerNum(j) + " ");
			bw.write(getTowerNum2(j) + " ");
		}

		bw.flush();
		bw.close();
	}

	static int getTowerNum(int towerNum) {

		for(int j = towerNum-1 ; j >= 0 ; j--) {
			System.out.println(j + "(" + postion[j] + ")" + " ← " + towerNum + "(" + postion[towerNum] + ") 비교 ");
			if(postion[j] >= postion[towerNum]) {
				return j+1;
			} 
		}
		return 0;
	}
	
	
	static int getTowerNum2(int towerNum) {
		
		for(int j = towerNum-1 ; j >= tmp ; j--) {
			System.out.println(j + "(" + postion[j] + ")" + " ← " + towerNum + "(" + postion[towerNum] + ") 비교 ");
			if(postion[j] >= postion[towerNum]) {
				return j+1;
			} 
		}
		return 0;
	}
	
}