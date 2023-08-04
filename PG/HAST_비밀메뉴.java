import java.util.*;
import java.io.*;

public class HAST_비밀메뉴 {

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken()); 
        int N = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(st.nextToken()); 

        if(N < M){
            System.out.print("normal");
            return;
        }

        int[] key = new int[M];
        int[] input = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++) {
            key[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        for(int i=0; i<N; i++){
            cnt = 0;
            if(input[i] == key[0] && i+M <= N){
                for(int a=i, b=0; b<M; a++, b++ ){
                    if(input[a] == key[b]) ++cnt;
                }
            }
            if(cnt == M) break;
        }

        if(cnt == M) System.out.print("secret");
        else System.out.print("normal");

    }

}


/* ver 2
	public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken()); 
        int N = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(st.nextToken()); 

        if(N < M){
            System.out.print("normal");
            return;
        }

        StringBuilder key = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++) {
            key.append(st.nextToken());
        }
        
        StringBuilder input = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            input.append(st.nextToken());
        }

        int cnt = 0;

        if(input.toString().contains(key.toString())) System.out.println("secret");
        else System.out.println("normal");

    }


*/
