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

		// �÷��̵� �ͼ��� �ٸ� ������ ���� ���������� �� �� �ִ� ��쵵 ǥ��
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
			// ������ ���� ���� ���õ鿡 ����, � ���� i�� �Բ� ������� �ٸ� ���õ��� ���� �� �� �ּ� ������� �������� ����
			// ������ ������ �޴� ���ô� cost�� 0���� �����Ͽ� ����
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
	
