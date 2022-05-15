import java.io.*;
import java.util.*;

public class boj20305 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int mod = (int)1e9+7;
		int n= Integer.parseInt(br.readLine());
		int fibo[] = new int[n+2];
		fibo[1]= 1;
		for(int i=2; i<=n+1; i++) {
			fibo[i]=(fibo[i-2]+fibo[i-1])%mod;
		}
		
		//수열 1~n 
		int seq[] = new int[n+1];
			
		int q= Integer.parseInt(br.readLine());
		while(q-->0) { // 쿼리에 대해 l~r까지 각각 더해주면 연산이 너무 많아짐
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			// 각 쿼리에 대해 seq[l], seq[l+1]부분에 각각 F_1, F_2을  넣고 나중에 한꺼번에 수열에 대해  seq[i]=seq[i-1]+seq[i-2] 피보나치로 합함
			// 이때 seq[l+1]부분의 경우 피보나치로 합하면서 seq[l-1]에는 없지만 seq[l]에 더해진 F_1이 함께 더해지는데 이를 미리 빼 상쇄시킴
			seq[l] = (seq[l]+fibo[1])%mod;
			if(l+1<=n) seq[l+1] = (seq[l+1]-fibo[1]+fibo[2])%mod;
			// seq[r+1]부분부터는 더해지는게 없음
			// 근데 seq[r+1]의 경우 seq[r-1],seq[r]로부터 각각 F_r-l,F_r-l+1 결과적으로 F_r-l+2가 더해졌으므로 이를 미리 빼 상쇄시킴
			// seq[r+2]의 경우 seq[r+1]은 상쇄시켰으므로 seq[r]의 F_r-l+1 만 미리 빼 상쇄시킴
			if(r+1<=n) seq[r+1] = (seq[r+1]-fibo[r-l+2]+mod)%mod;
			if(r+2<=n) seq[r+2] = (seq[r+2]-fibo[r-l+1]+mod)%mod;
		}
		
		for(int i=2; i<=n; i++) {
			seq[i]+=(seq[i-1]+seq[i-2])%mod;
			seq[i]%=mod;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		
		for(int i=1; i<=n; i++) {
			bw.write(seq[i]+" ");
		}
		bw.flush();
		bw.close();
	}
}
