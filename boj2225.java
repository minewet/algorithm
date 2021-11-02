import java.io.*;
import java.util.*;
public class boj2225 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int dp[][] = new int[n+1][k+1]; // k∞≥∑Œ n¿ª ∏∏µÍ
        for(int i=0; i<=n; i++) dp[i][1]=1;
        for(int i=0; i<=n; i++) {
        	for(int j=1; j<=k; j++) {
        		for(int m=0; m<=i; m++)
            		dp[i][j] = (dp[i][j]+dp[i-m][j-1])%1000000000;
        	}
        }
        System.out.println(dp[n][k]);
	}
}
