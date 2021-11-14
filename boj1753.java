import java.io.*;
import java.util.*;
class pair implements Comparable<pair>{
	int v;
	int w;
	public pair(int v, int w) {
		this.v=v;
		this.w=w;
	}
	
	@Override
	public int compareTo(pair target) {
		if(this.w < target.w) return -1;
        else if(this.w > target.w) return 1;
        return 0;
	}
	
}

public class boj1753 {

	public static void main(String... args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine()," "); 
      int V= Integer.parseInt(st.nextToken());
      int E= Integer.parseInt(st.nextToken());
      int start=Integer.parseInt(br.readLine());
      
      ArrayList<ArrayList<pair>> adj= new ArrayList<>();
      int [] dist= new int[V+1];
      boolean visited[]= new boolean[V+1];
      
      for(int i=0;i<=V;i++) {
    	 adj.add(new ArrayList<pair>());
      }

      for(int i=0; i<E;i++) {
    	  st = new StringTokenizer(br.readLine()," "); 
    	  int u=Integer.parseInt(st.nextToken());
    	  int v=Integer.parseInt(st.nextToken());
    	  int w=Integer.parseInt(st.nextToken());
    	  adj.get(u).add(new pair(v,w));
      }
      
      PriorityQueue<pair> pq = new PriorityQueue<pair>();
      pq.add(new pair(start,0));
      while(!pq.isEmpty()) {
    	  pair cur = pq.poll();
    	  visited[cur.v]=true;
    	  for(pair nxt: adj.get(cur.v)) {
    		  if(visited[nxt.v]) continue;
    		  if (dist[nxt.v] != 0 && dist[nxt.v] < cur.w + nxt.w) continue;
    		  dist[nxt.v]= cur.w+nxt.w;
    		  pq.add(new pair(nxt.v, nxt.w));
    	  }
      }
   
      for(int i=1; i<=V;i++) {
    	  if(i==start || dist[i]!=0)
    		  System.out.println(dist[i]);
    	  else
    		  System.out.println("INF");
      }
      
   }
}