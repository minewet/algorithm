import java.util.*;
import java.io.*;

public class boj4354 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		while(true) {
			String s = br.readLine();
			int len = s.length();
			if(s.equals(".")) break;
			int f[] = new int[s.length()];
			for(int j=0, i=1; i<len; i++) {
				while(j>0 && s.charAt(i)!=s.charAt(j)) j= f[j-1];
				if(s.charAt(i)==s.charAt(j)) f[i]= ++j;
			}
			int ans=1;
			// n>1의 a^n으로 이루어져 있을 경우 s에 대해 최장 접두사=접미사는 a^(n-1)임
			// 이를 이용하면 len(a)= len(s)-len(접두사)
			
			if(len % (len-f[len-1])==0) {
				ans = len / (len - f[len-1]);
			}
			System.out.println(ans);
		}
	}
}


