import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class pro_01_1_ANAGRAM {
	
	static int compareSize = 0;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_01_1_ANAGRAM.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s1 = br.readLine();
		String s2 = br.readLine();
		
		char[] chr_s1 = s1.toCharArray();
		Arrays.sort(chr_s1);
		
		compareSize = s1.length();
		int pos_end = s2.length();
		char[] tmp = null;
		
		int result = 0;
		for(int i = 0 ; i <= pos_end - compareSize ; i++) {
			tmp = s2.substring(i, i+compareSize).toCharArray();
			Arrays.sort(tmp);
		}

		bw.write(result + "");
		bw.flush();
		bw.close();
	}
}
