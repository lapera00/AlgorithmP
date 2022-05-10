import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3238 {

	static long result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t =0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			long n = Long.parseLong(st.nextToken());
			long r = Long.parseLong(st.nextToken());
			long p = Long.parseLong(st.nextToken());
			
			result = 1;
			nCr(n, r, p);
			
			sb.append("#").append(t+1).append(" ").append(result).append("\n");
		}

		System.out.println(sb);
	}

	private static void nCr(long n, long r,long p) {
		if(r==0) result = 1L;
		
		long [] fac = new long[(int) p];
		fac[0] = 1;
		
		for(int i=1; i<p; i++) {
			fac[i] = fac[i-1] * i % p;
		}
		
		int tempN, tempR;
		
		while(n>0 || r> 0) {
			tempN = (int) (n % p);
			tempR = (int) (r % p);
			
//			(fac[tempN] * power(fac[tempR], p-2,p ) % p * power(fac[tempN-tempR], p-2, p) % p) %p
//			long a = fac[tempN] * power(fac[tempR], p-2,p ) % p;
//			long b = power(fac[tempN-tempR], p-2, p) % p ;
//			result = (a * b) % p;
			// 뤼카의정리
			//nCr = (n! mod p)*((r! mod p)*((n-r)! mod p))^(p-2) (mod p)
			//(n! mod p)  *
			//((r! mod p)*((n-r)! mod p))^(p-2) (mod p)
			
			if(tempN < tempR) {
                result = 0;
                break;
            }
			
			result = result * fac[tempN] % p;
			for(int i = 0; i<p-2; i++) {
				result = result * fac[tempR] % p * fac[tempN-tempR] % p;
			}
			
			n /= p;
			r /= p;
					
		}


		
	}
/*
	private static long power(long x, long y, long p) {
		long res = 1L;
		x = x % p;
		
		while(y>0) {
			if(y%2 == 1) res = (res*x)%p;
			y = y>>1;
			x=(x*x)%p;
		}
		return res;
	}
*/
}
