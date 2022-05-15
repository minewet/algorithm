import java.io.*;
import java.util.*;

public class boj12837 {
	// ������ => ���׸�Ʈ Ʈ���� Ǯ��
	public static long[] tree;
	
	public static void update(int start, int end, int cur, int idx, int num) {
		// idx ��ġ ���ҿ� +num��ŭ ������Ʈ
		// Ʈ��  cur(���� ��ġ)���κ��� ��� �������� ������ ������Ʈ, �̶� cur��ġ�� start~end������ ������ ����
		if(idx<start || idx>end) return;
		else {
			// idx�� �ش� ������ ������ ���� ��带 ������Ʈ�ϰ� �ڽ� ���� ������
			tree[cur]+=num;
			if(start==end) return;
			int mid = (start+end)/2;
			update(start, mid, cur*2, idx, num);
			update(mid+1, end, cur*2+1, idx, num);
		}
	}
	public static long sum(int start, int end, int cur, int left, int right) {
		// left~right������ ������
		// ���� cur��ġ(start~end������ �� ����)
		if(left>end || right<start) return 0; 
		if(left<=start && end<=right) return tree[cur]; 	
		int mid = (start+end)/2;
		return sum(start, mid, cur*2, left, right)
				+sum(mid+1, end, cur*2+1, left, right);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		tree = new long[4*n];
		
		int qr = Integer.parseInt(st.nextToken());
		while(qr-->0) {
			st = new StringTokenizer(br.readLine());
			int opt =  Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			if(opt==1) { //���׸�Ʈ Ʈ�� ����
				int x = Integer.parseInt(st.nextToken());
				update(1,n, 1, p,x);
			}
			else if(opt==2) { // ���׸�Ʈ Ʈ�� ��ȯ
				int q = Integer.parseInt(st.nextToken());
				System.out.println(sum(1,n, 1, p,q));
			}
		}
	}
}
