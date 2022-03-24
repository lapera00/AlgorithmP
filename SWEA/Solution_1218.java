import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1218 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<10; t++) {
			int len = Integer.parseInt(br.readLine());
			String str = br.readLine();

			int check =0;
			Stack<Character> stack = new Stack<Character>();
            for (int i = 0; i < len; i++) {
                char c = str.charAt(i);
                if (c == ')' && !stack.isEmpty() && stack.peek() == '(') stack.pop();
                else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') stack.pop();
                else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') stack.pop();
                else if (c == '>' && !stack.isEmpty() && stack.peek() == '<')  stack.pop();
                else stack.push(c);
            }
 
            if (stack.isEmpty()) check = 1;
            else check = 0;
			
            
			
//			char[] arr = str.toCharArray();
//			int a=0,b=0,c=0,d=0;
//			for(int i = 0; i < len; i++) {
//				if(arr[i] == '(' || arr[i] == ')') ++a;
//				else if(arr[i] == '[' || arr[i] == ']') ++b;
//				else if(arr[i] == '{' || arr[i] == '}') ++c;
//				else if(arr[i] == '<' || arr[i] == '>') ++d;
//			}
//			int check =0;
//			if(a%2==0 && b%2==0 && c%2==0 && d%2 ==0) chek = 1;
//			else chek =0;
			
            
            
			sb.append("#").append(t+1).append(" ").append(check).append("\n");
		}
		System.out.println(sb);
	}

}
