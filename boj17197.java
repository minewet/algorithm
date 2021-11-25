import java.util.*;
import java.io.*;

public class boj17197 {
	public static int parent[];
	public static int find(int x) {
		if(x==parent[x]) return x;
		else return parent[x]=find(parent[x]);
	}
	
	public static void main(String... args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine()," ");
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    	    
	    parent = new int[n];
	    int location[][] = new int[n][2];
	    int rect[][] = new int[n][4];

	    for(int i=0; i<n; i++) {
	    	st = new StringTokenizer(br.readLine()," ");
	    	int x = Integer.parseInt(st.nextToken());
		    int y = Integer.parseInt(st.nextToken());
		    location[i][0]=x;
		    location[i][1]=y;
		    parent[i]=i;
		    
		    rect[i][0]=x;
		    rect[i][1]=x;
		    rect[i][2]=y;
		    rect[i][3]=y;
	    }
	    
	    

	    for(int i=0; i<m; i++) {
	    	st = new StringTokenizer(br.readLine()," ");
	    	int a = Integer.parseInt(st.nextToken())-1;
		    int b = Integer.parseInt(st.nextToken())-1;
	    	a=find(a);
	    	b=find(b);
	    	if(a!=b) {
	    		parent[b]=a;
	    		if(rect[a][0]>rect[b][0]) rect[a][0]=rect[b][0];
	    		if(rect[a][1]<rect[b][1]) rect[a][1]=rect[b][1];
	    		if(rect[a][2]>rect[b][2]) rect[a][2]=rect[b][2];
	    		if(rect[a][3]<rect[b][3]) rect[a][3]=rect[b][3];    		
	    	}
	    }
	    int ans=(int)1e8*4;
	    for(int i=0; i<n; i++) {
	    	if(parent[i]==i) {
	    		int tmp= rect[i][1]-rect[i][0] + rect[i][3] - rect[i][2];
	    		tmp*=2;
	    		if(tmp<ans) ans=tmp;
	    	}
	    }
	    System.out.println(ans);
	}
}

