import java.util.*;
import java.io.*;

public class boj3584 {
	public static int parent[];
	public static boolean visit[];
	
	public static int lca(int a, int b) {
		visit[a]= true;
		while(a!=parent[a]) {
			a= parent[a];
			visit[a] = true;
		}
		while(b!=parent[b]) {
			b=parent[b];
			if(visit[b]==true) return b;		
		}
		return b;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
			int n = Integer.parseInt(br.readLine());
			parent = new int[n+1];
			visit = new boolean[n+1];
			for(int i=1; i<=n; i++) parent[i]= i;
			for(int i=0; i<n-1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				parent[b]=a;		
			}		
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(lca(a,b));
		}
	}
}
