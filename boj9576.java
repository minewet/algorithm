import java.util.*;
import java.io.*;

public class boj9576 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n= Integer.parseInt(st.nextToken());
			int m= Integer.parseInt(st.nextToken());
			int book[][] = new int[m][2];
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				book[i][0]= Integer.parseInt(st.nextToken());
				book[i][1]= Integer.parseInt(st.nextToken());
			}
			Arrays.sort(book, new Comparator<int[]>() {
		        @Override
		        public int compare(int[] o1, int[] o2) {
		        	if(o1[1]==o2[1]) 
		        		return o1[0]-o2[0];
		        	return o1[1]-o2[1];
		        }
		    });
			boolean visit[] = new boolean[n+1];
			int ans=0;
			for(int i=0; i<m; i++) {
				for(int j=book[i][0]; j<=book[i][1]; j++) {
					if(!visit[j]) {
						visit[j]=true;
						ans++;
						break;
					}
				}			
			}
			System.out.println(ans);
		}
	}
}
