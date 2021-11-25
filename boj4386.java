import java.util.*;
import java.io.*;

class ve implements Comparable<ve>{
	int v;
	double e;
	
	public ve(int v, double e) {
		this.v=v;
		this.e=e;
	}
	@Override
	public int compareTo(ve o) {
		if(this.e==o.e) return this.v-o.v;
		return Double.compare(this.e, o.e);
	}
}
public class boj4386 {
	
	public static void main(String... args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());

	    double[][] v = new double[n][2];
	    for(int i=0; i<n;i++) {
	    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
	    	v[i][0]= Double.parseDouble(st.nextToken());
	    	v[i][1]= Double.parseDouble(st.nextToken());
	    }
	    
	    double[][] e = new double[n][n];
	    for(int i=0; i<n; i++) {
	    	for(int j=0; j<n; j++) {
	    		e[i][j]= Math.pow(v[i][0]-v[j][0],2) + Math.pow(v[i][1]-v[j][1],2);
	    		e[i][j]= Math.sqrt(e[i][j]);		
	    	}
	    }
	    
	    PriorityQueue<ve> pq = new PriorityQueue<ve>();
	    boolean visited[] = new boolean[n];
	    int cnt=0;
	    double cost=0;
	    
	    visited[0]= true;
	    for(int i=0; i<n; i++) {
	    	pq.add(new ve(i, e[0][i]));
	    }
	    
	    while(!pq.isEmpty()) {
	    	ve cur= pq.poll();
	    	if(!visited[cur.v]) {
	    		cnt++;
	    		visited[cur.v]=true;
	    		cost+= cur.e;
	    		
	    		if(cnt==n) break;
	    		for(int i=0; i<n; i++) {
	    			if(!visited[i]) {
	    				pq.add(new ve(i, e[cur.v][i]));
	    			}
	    		}
	    	}
	    }
	    System.out.printf("%.2f", cost);
	}    
}
