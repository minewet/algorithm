import java.io.*;
import java.util.*;
public class boj1058 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		int dist[][]= new int[n][n];
		
		for(int i=0; i<n; i++) {
			String s= br.readLine();
			for(int j=0; j<s.length();j++) {
				if(i==j) dist[i][j]=0;
				else if(s.charAt(j)=='Y') dist[i][j]=1;
				else dist[i][j]= 100000000;
			}
		}

		
		for(int k=0; k<n; k++) { // 플로이드 와샬
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(k==i || i==j || j==k) continue;
					dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
				}
			}
		}

		int max=0;
		for(int i=0; i<n; i++) {
			int cnt=0;
			for(int j=0; j<n; j++) {
				if(j!=i && dist[i][j]<=2) cnt++;
			}
			if(max<cnt) max=cnt;
		}
		System.out.println(max);
	}
}
