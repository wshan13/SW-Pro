import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class pro_03_3_LCS {

	static int len1;
	static int len2;
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_03_3_LCS.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] c1 = br.readLine().toCharArray();	len1 = c1.length+1;	System.out.println(len1);
		char[] c2 = br.readLine().toCharArray();	len2 = c2.length+1;	System.out.println(len2);

		int[][] lcs = new int[len1][len2];
		char[][] way = new char[len1][len2];
		printArray(lcs);
		
		for(int x = 0 ; x < len1 ; x++) {
			for(int y = 0 ; y < len2 ; y++) {
				System.out.println(x + ", " + y);
				if(c1[x] == c2[y]) {
					lcs[x][y] = lcs[x-1][y-1] + 1;
					way[x][y] = '¢Ø';
				} else {
					lcs[x][y] = Math.max(lcs[x-1][y], lcs[x][y-1]);
					way[x][y] = lcs[x-1][y] > lcs[x][y-1] ? '¡ç' : '¡è';
				}
			}
		}
		printArray(lcs);
		printArray(way);
		
		int answer = 0;
		bw.write(answer + "\n");

		bw.flush();
		bw.close();
	}
	
	static void printArray(int[][] lcs) {
		
		for(int x = 0 ; x < len1 ; x++) {
			for(int y = 0 ; y < len2 ; y++) {
				System.out.print(lcs[x][y] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	static void printArray(char[][] lcs) {
		
		for(int x = 0 ; x < len1 ; x++) {
			for(int y = 0 ; y < len2 ; y++) {
				System.out.print(lcs[x][y] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}	
}