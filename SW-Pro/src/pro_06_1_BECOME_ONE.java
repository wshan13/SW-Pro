import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class pro_06_1_BECOME_ONE {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_06_1_BECOME_ONE.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());		// 태양이가 가진 수

        int[] D = new int[N+1];	// i를 만드는 최소의 횟수 배열
        
        for(int i=2 ; i <= N ; i++){
        	// 특정 경우에 -1을 빼도 되고 나눗셈을 해도 되는 경우가 발생해서 비교를 해야함
        	// 먼저 -1을 항상빼고 %2, %3을 비교해서 값이 적으면 갱신한다.
        	D[i] = D[i-1] + 1;
    		//System.out.println("D[" + i + "] = D[" + (i-1) + "] + 1 = " + D[i]);

    		if(i % 2 == 0 && D[i] > D[i/2]+1) {
        		D[i] = D[i/2] + 1; 
        		//System.out.println("D[" + i + "] = D[" + i/2 + "] + 1 = " + D[i] + " <  갱신");
        	}

    		if(i % 3 == 0 && D[i] > D[i/3]+1) {
        		D[i] = D[i/3] + 1;
        		//System.out.println("D[" + i + "] = D[" + i/3 + "] + 1 = " + D[i] + " <  갱신");
        	}
        }
        
        System.out.print(D[N]);
	}
}