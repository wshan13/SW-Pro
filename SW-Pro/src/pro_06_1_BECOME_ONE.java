import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class pro_06_1_BECOME_ONE {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_06_1_BECOME_ONE.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());		// �¾��̰� ���� ��

        int[] D = new int[N+1];	// i�� ����� �ּ��� Ƚ�� �迭
        
        for(int i=2 ; i <= N ; i++){
        	// Ư�� ��쿡 -1�� ���� �ǰ� �������� �ص� �Ǵ� ��찡 �߻��ؼ� �񱳸� �ؾ���
        	// ���� -1�� �׻󻩰� %2, %3�� ���ؼ� ���� ������ �����Ѵ�.
        	D[i] = D[i-1] + 1;
    		//System.out.println("D[" + i + "] = D[" + (i-1) + "] + 1 = " + D[i]);

    		if(i % 2 == 0 && D[i] > D[i/2]+1) {
        		D[i] = D[i/2] + 1; 
        		//System.out.println("D[" + i + "] = D[" + i/2 + "] + 1 = " + D[i] + " <  ����");
        	}

    		if(i % 3 == 0 && D[i] > D[i/3]+1) {
        		D[i] = D[i/3] + 1;
        		//System.out.println("D[" + i + "] = D[" + i/3 + "] + 1 = " + D[i] + " <  ����");
        	}
        }
        
        System.out.print(D[N]);
	}
}