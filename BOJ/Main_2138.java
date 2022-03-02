import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2138 {
	static int n, cnt1, cnt2;
	static int [] arr1, arr2, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		String s1 = br.readLine();
		String s2 = br.readLine();
		arr1 = new int[n];
		arr2 = new int[n];
		res = new int[n];
		for(int i =0; i<n; i++) {
			arr1[i] = s1.charAt(i)-'0';
			arr2[i] = s1.charAt(i)-'0';
			res[i] = s2.charAt(i)-'0';
		}
		
		
		turn(arr1, 0);
		++cnt1;
		
		for(int i=1; i<n; i++) {
			if(arr1[i-1] != res[i-1]) {
				turn(arr1, i);
				++cnt1;
			}
			if(arr2[i-1] != res[i-1]) {
				turn(arr2, i);
				++cnt2;
			}
		}
		
		int a = 0, b=0, last=0;;
		int turnNum1=Integer.MAX_VALUE, turnNum2=Integer.MAX_VALUE;
		for(int i = 0; i<n; i++) {
			if(arr1[i] != res[i]) ++a; 
			if(arr2[i] != res[i]) ++b;	
		}
		if(a==0) turnNum1 = cnt1;
		if(b==0) turnNum2 = cnt2;
		last = Math.min(turnNum1, turnNum2);
		if(last == Integer.MAX_VALUE) last = -1;
		System.out.println(last);

	}
	
	static void turn(int arr[], int idx) {
		for(int i=idx-1; i<=idx+1; i++) {
			if(i>=0 && i<n) {
				arr[i] = arr[i]== 1 ? 0 : 1;
			}
		}
	}

}
