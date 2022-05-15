import java.io.*;
import java.util.*;

public class boj1275{
	// 구간합 => 세그먼트 트리로 풀이
	public static long[] arr;
	public static long[] tree;
	
	public static long init(int start, int end, int cur) {
		if(start==end) return tree[cur]=arr[start];
		else{
			int mid = (start+end)/2;
			return tree[cur]=init(start,mid,cur*2)
					+init(mid+1,end,cur*2+1);
		}
	}
	
	public static void update(int start, int end, int cur, int idx, long num) {
		// idx 위치 원소에 +num만큼 업데이트
		// 트리  cur(현재 위치)노드로부터 계속 내려가며 구간합 업데이트, 이때 cur위치는 start~end까지의 구간합 저장
		if(idx<start || idx>end) return;
		else {
			// idx가 해당 범위에 있을때 현재 노드를 업데이트하고 자식 노드로 내려감
			tree[cur]+=num;
			if(start==end) return;
			int mid = (start+end)/2;
			update(start, mid, cur*2, idx, num);
			update(mid+1, end, cur*2+1, idx, num);
		}
	}
	public static long sum(int start, int end, int cur, int left, int right) {
		// left~right까지의 구간합
		// 현재 cur위치(start~end까지의 값 저장)
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
		int qr = Integer.parseInt(st.nextToken());
		arr = new long[n+1];
		tree = new long[4*(n+1)];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}		
		init(1,n, 1);
		
		while(qr-->0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(x>y) { //x<y가 보장이 안됨
				int tmp=x;
				x=y;
				y=tmp;
			}
			long diff = (long)b-arr[a];
			System.out.println(sum(1,n, 1, x,y));
			update(1,n, 1, a, diff);
			arr[a]+=diff;
		}
	}
}
