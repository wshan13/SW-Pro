import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

/**
 * http://blog.naver.com/PostView.nhn?blogId=kks227&logNo=220791188929
 * 
 * @author wshan
 *
 */
public class pro_04_4_SDS_PRO_3_6 {

	static int N; 
	static Deque<Integer> lower = new ArrayDeque<>();
	static Deque<Integer> upper = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_04_4_SDS_PRO_3_6.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());		// 배열의 크기 

		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//printArray(arr);
		//System.out.println("");
		
		int mid = arr[0];
		
		//System.out.println(mid);
		
		for(int i = 1 ; i < N ; i++) {

			System.out.println(arr[i] + " 처리" );
			if(mid < arr[i]) {
				setUpperValue(arr[i]);
			} else {
				setLowerValue(arr[i]);
			}
			
			System.out.println("upper queue : " + upper);
			System.out.println("mid : " + mid);
			System.out.println("lower queue : " + lower);
			
			if(i > 1) {
				if(upper.size() > lower.size()) {
					System.out.println("upper가 큼. mid -> lower queue, upper queue's min -> mid");
					setLowerValue(mid);
					mid = upper.pollFirst();
					System.out.println("upper queue : " + upper);
					System.out.println("mid : " + mid);
					System.out.println("lower queue : " + lower);
					System.out.println("");
				} else if(upper.size() < lower.size()) {
					System.out.println("lower가 큼. mid -> upper queue, lower queue's max -> mid");
					setUpperValue(mid);
					mid = lower.pollLast();
					System.out.println("upper queue : " + upper);
					System.out.println("mid : " + mid);
					System.out.println("lower queue : " + lower);
					System.out.println("");
				} else if(upper.size() == lower.size()) {
					System.out.println("사이즈 동일.. ");
					System.out.println("");
				}
				
				//System.out.println(mid);
			}
			System.out.println("");
					
		}

	}
	
	static void setUpperValue(int val) {
			if(upper.isEmpty()) {
				upper.add(val);
				return;
			}

			if(val < upper.peekFirst()) {
				upper.addFirst(val);
			}
			
			if(val > upper.peekLast()) {
				upper.addLast(val);
			}
	}
	
	static void setLowerValue(int val) {
		if(lower.isEmpty()) {
			lower.add(val);
			return;
		}
		
		if(val < lower.peekFirst()) {
			lower.addFirst(val);
		}
		
		if(val > lower.peekLast()) {
			lower.addLast(val);
		}
}
	
	static void printArray(int[] tmp) {
		for(int i = 0 ; i < N ; i++) {
			System.out.println(tmp[i]);
		}
	}
}