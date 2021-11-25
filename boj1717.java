import java.util.*;
import java.io.*;

public class boj1717 {
	public static int parent[];
	public static int find(int child) {
		if(parent[child]==child) return child;
		else return parent[child]= find(parent[child]);
	}

	public static void main(String... args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine()," ");
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    
	    parent = new int[n+1];
	    for(int i=0; i<n+1; i++) parent[i]= i;
	    
	    for(int i=0; i<m; i++) {
	    	st = new StringTokenizer(br.readLine()," ");
	    	int mode = Integer.parseInt(st.nextToken());
	    	int a = Integer.parseInt(st.nextToken());
	    	int b = Integer.parseInt(st.nextToken());
	    	
	    	a= find(a);
	    	b= find(b);
	    	
	    	if(mode==0) {
	    		if(a!=b) parent[a]=b;
	    	}
	    	
	    	else {
	    		if(a==b) System.out.println("YES");
	    		else System.out.println("NO");
	    	}
	    }
	}
}
