import java.io.*;
import java.util.*;

public class boj1506 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cost[]= new int[n];
		char adj[][] = new char[n][];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			cost[i]= Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<n; i++) {
			adj[i]= br.readLine().toCharArray();
		}

		// 플로이드 와샬로 다른 지역을 통해 간접적으로 갈 수 있는 경우도 표시
		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(adj[i][k]=='1' && adj[k][j]=='1')
						adj[i][j]='1';
				}
			}
		}
		
		int ans=0;
		for(int i=0; i<n; i++) {
			if(cost[i]==0) continue;
			int lowestCost = cost[i];
			cost[i]=0;
			// 경찰서 통제 밖의 도시들에 한해, 어떤 도시 i와 함께 강연결된 다른 도시들을 묶어 그 중 최소 비용으로 경찰서를 세움
			// 경찰서 통제를 받는 도시는 cost를 0으로 변경하여 제외
            for(int j=i+1; j<n; j++) {
				if(cost[j]!=0 && adj[i][j]=='1' && adj[j][i]=='1') {
					lowestCost= Math.min(lowestCost, cost[j]);
					cost[j]=0;
				}
			}
			ans+=lowestCost;
		}
		
		System.out.println(ans);
	}
}
	
