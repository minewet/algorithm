import java.io.*;
import java.util.*;
public class boj11049 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][2];
        for(int i=0; i<n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());	
        	arr[i][0]= Integer.parseInt(st.nextToken());
        	arr[i][1]= Integer.parseInt(st.nextToken());
        }
        int dp[][] = new int[n][n]; // i~j ÀÎµ¦½º ¹üÀ§¿¡¼­ Çà·Ä °ö¼À ¿¬»ê È½¼ö ÃÖ¼Ú°ª
        for(int j=1; j<n; j++) {
        	for(int i=0; i+j<n; i++) {
        		for(int k=i; k<i+j; k++) {
        			if(dp[i][i+j]==0) dp[i][i+j]= dp[i][k]+dp[k+1][i+j]+ arr[i][0]*arr[k][1]*arr[i+j][1];
        			else dp[i][i+j]= Math.min(dp[i][i+j], dp[i][k]+dp[k+1][i+j]+ arr[i][0]*arr[k][1]*arr[i+j][1]);
        		}
        	}
        }
        System.out.println(dp[0][n-1]);  
	}
}
