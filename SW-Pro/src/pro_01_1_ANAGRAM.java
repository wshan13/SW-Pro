import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class pro_01_1_ANAGRAM {
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("pro_01_1_ANAGRAM.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s1 = br.readLine();
		String s2 = br.readLine();
		br.close();
		
		char[] chr_s1 = s1.toCharArray();
		char[] chr_s2 = s2.toCharArray();
		
		int[] s1_idx = new int[256];
		int[] s2_idx = new int[256];
		
		// char�� �ش��ϴ� ���� i�� �ش� ��ġ�� ī��Ʈ�� �Ѵ�.
		for(int i = 0 ; i < chr_s1.length ; i++) {
			s1_idx[chr_s1[i]]++;
		}
		
		// s2�� ��쵵 ���� s1�� ���̸�ŭ�� ī��Ʈ�� �Ѵ�.
		for(int i = 0 ; i < chr_s1.length ; i++) {
			s2_idx[chr_s2[i]]++;
		}
		
		//printArray(s1_idx);
		//printArray(s2_idx);
		
		int result = 0;
		//System.out.println(compare(s1_idx, s2_idx));
		if(compare(s1_idx, s2_idx)) {
			result++;
		}
		
		// sliding windows�� �̿��� ������ �ε������� ������ �и鼭 �߰��Ǵ� ���ڿ� ������ ���ڸ� ī��Ʈ �Ѵ�
		for(int j = chr_s1.length ; j < chr_s2.length ; j++) {
			//System.out.println(j + "�߰�, " + (j-chr_s1.length) + "����");
			//System.out.println(chr_s2[j] + "�߰�, " + chr_s2[j-chr_s1.length] + "����");
			s2_idx[chr_s2[j]]++;
			s2_idx[chr_s2[j-chr_s1.length]]--;
			//System.out.println(compare(s1_idx, s2_idx));
			if(compare(s1_idx, s2_idx)) {
				result++;
			}
		}
		
		System.out.print(result);

	}
	
	static boolean compare(int[] s1, int[] s2) {
		for(int i = 0 ; i < 256 ; i++) {
			if(s1[i] != s2[i]) {
				return false;
			}
		}
		return true;
	}
	
	static void printArray (char[] chr) {
		int len = chr.length;
		for(int i = 0 ; i < len ; i++) {
			System.out.print(chr[i] + " ");
		}
		System.out.println("");
	}

	static void printArray (int[] idx) {
		int len = idx.length;
		for(int i = 0 ; i < len ; i++) {
			System.out.print(idx[i] + " ");
		}
		System.out.println("");
	}

}
