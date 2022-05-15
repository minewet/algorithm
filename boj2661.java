import java.io.*;

public class boj2661 {
	public static int n;
	public static String ans;
	public static boolean fin=false;

	// �տ������� ���� �ϳ��� �÷����鼭 ����(�� �� i�ڸ� ���ڰ� �� ���� i�ڸ� ���ڿ� ������ �κ��� �ִ���, i: 1~���ݱ���)�� �ش��ϴ��� Ȯ���Ͽ� n�ڸ� �ϼ�
	public static void check(String s) {
		//s: Ȯ���� ����, level�� s.length(): 1~n����
		
		for(int i=1; i<=s.length()/2; i++) {
			String a = s.substring(s.length()-i,s.length());
			String b = s.substring(s.length()-2*i, s.length()-i);
			if(a.equals(b)) {
				return;
			}
		}
		
		if(s.length()==n) { // n�ڸ� ��� �ϼ��� �� ����
			ans=s;
			fin=true;
		}
		else {
			for (int i=1; i<=3 && !fin; i++) // �����ڸ��� ���� ���� (1~3)�־� Ȯ��
	            check(s+i);
		}	
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		n= Integer.parseInt(br.readLine());
		
		for (int i=1; i<=3 && !fin; i++) // �����ڸ��� ���� ���� (1~3)�־� Ȯ��
            check(""+i);
		System.out.println(ans);
	}
}
