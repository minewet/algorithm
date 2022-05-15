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
		
		//���� 1~n 
		int seq[] = new int[n+1];
			
		int q= Integer.parseInt(br.readLine());
		while(q-->0) { // ������ ���� l~r���� ���� �����ָ� ������ �ʹ� ������
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			// �� ������ ���� seq[l], seq[l+1]�κп� ���� F_1, F_2��  �ְ� ���߿� �Ѳ����� ������ ����  seq[i]=seq[i-1]+seq[i-2] �Ǻ���ġ�� ����
			// �̶� seq[l+1]�κ��� ��� �Ǻ���ġ�� ���ϸ鼭 seq[l-1]���� ������ seq[l]�� ������ F_1�� �Բ� �������µ� �̸� �̸� �� ����Ŵ
			seq[l] = (seq[l]+fibo[1])%mod;
			if(l+1<=n) seq[l+1] = (seq[l+1]-fibo[1]+fibo[2])%mod;
			// seq[r+1]�κк��ʹ� �������°� ����
			// �ٵ� seq[r+1]�� ��� seq[r-1],seq[r]�κ��� ���� F_r-l,F_r-l+1 ��������� F_r-l+2�� ���������Ƿ� �̸� �̸� �� ����Ŵ
			// seq[r+2]�� ��� seq[r+1]�� ���������Ƿ� seq[r]�� F_r-l+1 �� �̸� �� ����Ŵ
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
