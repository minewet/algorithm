import java.io.*;
import java.util.*;
public class boj9024 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine());
		while(t-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n= Integer.parseInt(st.nextToken());
			int k= Integer.parseInt(st.nextToken());
			int arr[]= new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				arr[i]= Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int low=0, high=n-1, min=1000000000, cnt=0;
			while(low<high) {
				int sum=arr[low]+arr[high];
				if(Math.abs(k-sum)<min) {
					min=Math.abs(k-sum);
					cnt=1;
				}
				else if (Math.abs(k-sum)==min) {
					cnt++;
				}
				if(sum<k) low++;	
				else if(sum>k) high--;
				else {
					low++;
					high--;
				}
			}
			System.out.println(cnt);
		}		
	}
}
