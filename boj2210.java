import java.util.*;
import java.io.*;

public class boj2210 {
	
	public static int n;
	public static int adj[][];
	public static boolean contain[];
	public static int dist[];
	public static int ans=0;
	
	public static void update(int v) {
		for(int i=0; i<n; i++) {
			if(!contain[i]) {
				if(adj[v][i]!=0 && (dist[i]==-1 || dist[i]>adj[v][i]))
					dist[i]=adj[v][i];
			}
		}
	}
	
	public static int mindist() {
		int min=-1;
		for(int i=1; i<=n; i++) {
			if(!contain[i]) {
				min= i;
				break;
			}
		}
		for(int i=0; i<n; i++) 
			System.out.print(dist[i]+" ");
		System.out.print("min: "+min);
		
		System.out.println();
		for(int i=min+1;i<=n; i++) {
			if(!contain[i] && dist[i]<dist[min]) {
				min= i;
			}
		}
		return min;
	}
	
	public static void prim(int v) {
		for(int i=1; i<=n; i++) {
			dist[i]=-1;
		}
		contain[v]=true;
		update(v);
		
		for(int i=1; i<=n; i++) {
			int nxt= mindist();
			contain[nxt]= true;
			ans+=dist[nxt];
			update(nxt);
		}	
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		adj=new int[n+1][n+1];
		for(int i=0; i<m; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine()," ");	
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			int c= Integer.parseInt(st.nextToken());
			adj[a][b]=c;
		}
		
		contain= new boolean[n+1];
		dist= new int[n+1];
		
		prim(1);
		System.out.println(ans);
	}
}
