import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2884 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        if(M<60 && M >= 45){
            System.out.println(H + " " + (M-45));
        }else if(M<45){
            M -= 45;
            if(M < 0) {
                if(H ==0 ) H=24;
                H -= 1;
                M = 60+M;
                System.out.println(H + " " + M);
            }
        }
        
    }
}