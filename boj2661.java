import java.io.*;

public class boj2661 {
	public static int n;
	public static String ans;
	public static boolean fin=false;

	// 앞에서부터 숫자 하나씩 늘려가면서 조건(맨 뒤 i자리 숫자가 그 앞의 i자리 숫자와 동일한 부분이 있는지, i: 1~절반까지)에 해당하는지 확인하여 n자리 완성
	public static void check(String s) {
		//s: 확인할 숫자, level은 s.length(): 1~n까지
		
		for(int i=1; i<=s.length()/2; i++) {
			String a = s.substring(s.length()-i,s.length());
			String b = s.substring(s.length()-2*i, s.length()-i);
			if(a.equals(b)) {
				return;
			}
		}
		
		if(s.length()==n) { // n자리 모두 완성시 답 도출
			ans=s;
			fin=true;
		}
		else {
			for (int i=1; i<=3 && !fin; i++) // 다음자리에 대해 숫자 (1~3)넣어 확인
	            check(s+i);
		}	
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		n= Integer.parseInt(br.readLine());
		
		for (int i=1; i<=3 && !fin; i++) // 다음자리에 대해 숫자 (1~3)넣어 확인
            check(""+i);
		System.out.println(ans);
	}
}
