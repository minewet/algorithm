import java.io.*;
import java.util.*;
public class boj12015 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
	    for(int i=0;i<n;i++) arr[i]= Integer.parseInt(st.nextToken());
	    
	    int ans[] = new int[n];
	    int p=0;
	    ans[0]=arr[0];
	    for(int i=1; i<n; i++) {
	    	if(ans[p]<arr[i]) ans[++p]=arr[i];
	    	else {
	    		//System.out.println("**"+arr[i]+" "+p);
	    		//for(int j=0; j<=p; j++) System.out.print(ans[j]+" ");
	    		//System.out.println();
	    		int low=0, high=p;
	    		while(low<=high) {
	    			int mid=(low+high)/2;
	    			if(ans[mid]<arr[i]) low=mid+1;
	    			else if(ans[mid]>arr[i]) high=mid-1;
	    			else {
	    				low=mid;
	    				break;
	    			}
	    		}
	    		//System.out.println(low);
	    		ans[low]= arr[i];
	    	}
	    }
	    System.out.println(p+1);
	}

}
