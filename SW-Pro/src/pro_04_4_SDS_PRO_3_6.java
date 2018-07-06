import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Stack;

public class pro_04_4_SDS_PRO_3_6 {

	static int N; 
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
		System.out.println(0 + " : " + mid);
		Stack<Integer> lower = new Stack<Integer>();
		Stack<Integer> upper = new Stack<Integer>();
		
		System.out.println(upper);
		System.out.println(mid);
		System.out.println(lower);
		System.out.println("");

		for(int i = 1 ; i < N ; i++) {
			if(arr[i] < mid) {
				if(lower.empty()) {
					lower.add(arr[i]);
				} else {
					if(arr[i] > lower.peek()) {
						lower.add(arr[i]);	
					}
				}
			}
			
			if(arr[i] > mid) {
				if(upper.empty()) {
					upper.add(arr[i]);
				} else {
					if(arr[i] < upper.peek()) {
						upper.add(arr[i]);	
					}
				}
			}
			
			if(i > 1 && i%2 == 0) {
				if(lower.size() < upper.size()) {
					System.out.println(upper);
					System.out.println(mid);
					System.out.println(lower);
					System.out.println("upper가 큼. 데이터 확인");
					if(upper.peek() > mid) {
						lower.push(mid);
						mid = upper.pop();
					}
				}
				if(lower.size() > upper.size()) {
					System.out.println(upper);
					System.out.println(mid);
					System.out.println(lower);
					System.out.println("lower가 큼. 데이터 확인");
					if(lower.peek() < mid) {
						upper.push(mid);
						mid = lower.pop();
					}
				}
			}
			

			System.out.println(upper);
			System.out.println(mid);
			System.out.println(lower);
			System.out.println("");

			if(i%2 == 0) {
				System.out.println(i + " : " + mid);
			}
		}

	}
	
	static void printArray(int[] tmp) {
		for(int i = 0 ; i < N ; i++) {
			System.out.println(tmp[i]);
		}
	}
}