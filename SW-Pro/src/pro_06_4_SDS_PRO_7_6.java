import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
  
public class pro_06_4_SDS_PRO_7_6 {
  
    public static void main(String[] args) throws Exception {
  
		System.setIn(new FileInputStream("pro_06_4_SDS_PRO_7_6.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
        int N = Integer.parseInt(br.readLine());        // °è´Ü N

        System.out.print(matrix_power(new long[][] { {1, 1}, {1, 0} }, N)[0][0]);

    }
     
    static int fibo2(int x) {
         
        int s0 = 0;
        int s1 = 1;
         
        if(x == 0){ return s0; }
        if(x == 1){ return s1; }
         
        int tmp;
         
        for (int i = 1 ; i <= x ; i++) {
            tmp = (s0 + s1)%1000000007;
            s0 = s1;
            s1 = tmp;
        }
        
        return s1;
    }
    
    static void maxtirx_print(int[][] m) {
    	System.out.println("{ " + m[0][0] + " , " + m[0][1] + " }");
    	System.out.println("{ " + m[1][0] + " , " + m[1][1] + " }");
    	System.out.println("");
    }
    
    static int  _mod = 1000000007;

    static long[][] matrix_power(long[][] m, int n) {
    	
    	if(n == 1) {
    		return new long[][] { {1, 1}, {1, 0} };
    	}
    	
    	long[][] tmp = matrix_power(m, n/2);
    	
		tmp = matrix_multiply(tmp, tmp);

    	if(n%2 == 1) {
    		tmp = matrix_multiply(tmp, new long[][] { {1, 1}, {1, 0} });
    	}
    	
    	return tmp;
    }
    
    static long[][] matrix_multiply(long [][] x, long [][] y) {
    	return new long[][] {
    			{ (x[0][0] * y[0][0]+ x[0][1] * y[1][0]) % _mod, (x[0][0] * y[0][1] + x[0][1] * y[1][1]) % _mod } ,
				{ (x[1][0] * y[0][0]+ x[1][1] * y[1][0]) % _mod, (x[1][0] * y[0][1] + x[1][1] * y[1][1]) % _mod } 
    	};
    }
}
