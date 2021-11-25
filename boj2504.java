import java.util.*;
import java.io.*;

public class boj2504 {
	public static void main(String... args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s= br.readLine();
		Stack <Character> st = new Stack<Character>();
		int ans=0;
		int tmp=1;
;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='(') {
				st.push(s.charAt(i));
				tmp*=2;
			}
			else if(s.charAt(i)=='[') {		
				st.push(s.charAt(i));
				tmp*=3;	
			}
			else if(s.charAt(i)==')'){
				if(st.isEmpty() || st.pop()!='(') {
					ans=0;
					break;
				}
				if(s.charAt(i-1)=='(') ans+=tmp;
				tmp/=2;
			}
			else{
				if(st.isEmpty() || st.pop()!='[') {
					ans=0;
					break;
				}
				if(s.charAt(i-1)=='[') ans+=tmp;
				tmp/=3;
			}
		}
		if(!st.isEmpty()) ans=0;
		System.out.println(ans);
	}
}
