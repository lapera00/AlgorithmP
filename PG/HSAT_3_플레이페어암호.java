import java.util.*;
import java.io.*;

public class HSAT_3_플레이페어암호 {

	public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String key = br.readLine();
        char[][] arr = new char[5][5];
        List<Character> alpha = new ArrayList<>();
        
        for(int i = 0; i < 26; i++){
            if((char)'A' + i =='J'){
                continue;
            }
            alpha.add((char)('A'+i));
        }

        int r = 0;
        int c = 0;

        for(int i = 0; i<key.length(); i++){
            if(alpha.contains(key.charAt(i))){
                arr[r][c] = key.charAt(i);
                alpha.remove(Character.valueOf(arr[r][c]));
                c++;
                if( c == 5) {
                    c = 0;
                    r++;
                }
            }
        }
        
        for(int i = 0; i < alpha.size(); i++) {
			arr[r][c] = alpha.get(i);
			c++;
			if (c == 5) {
				c = 0;
				r++;
			}
		}

        StringBuilder sb = new StringBuilder();
		sb.append(str);
        
		int idx = 0;

        // 두글자 꺠기
		while (idx < sb.length() - 1) {
			if (sb.charAt(idx) == sb.charAt(idx + 1)) {
				if (sb.charAt(idx) == 'X') {
					sb.insert(idx + 1, 'Q');
				} else {
					sb.insert(idx + 1, 'X');
				}
			}
			idx += 2;
		}

        //홀수길이 X추가
        if (sb.length() % 2 == 1) {
			sb.append('X');
		}

        idx = 0;
        while(idx < sb.length() - 1) {
            char c1 = sb.charAt(idx);
			char c2 = sb.charAt(idx + 1);
			int cx = 0, cy = 0, cx2 = 0, cy2 = 0;

            //문자의 좌표
            for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (c1 == arr[i][j]) {
						cx = i;
						cy = j;
					}
					if (c2 == arr[i][j]) {
						cx2 = i;
						cy2 = j;
					}
				}
			}

            // 같은 행
			if (cx == cx2) {
				if (cy + 1 >= 5)
					cy = -1;
				if (cy2 + 1 >= 5)
					cy2 = -1;
				sb.setCharAt(idx, arr[cx][cy + 1]);
				sb.setCharAt(idx + 1, arr[cx2][cy2 + 1]);
				idx += 2;
				continue;
			}

			// 같은 열
			if (cy == cy2) {
				if (cx + 1 >= 5)
					cx = -1;
				if (cx2 + 1 >= 5)
					cx2 = -1;
				sb.setCharAt(idx, arr[cx + 1][cy]);
				sb.setCharAt(idx + 1, arr[cx2 + 1][cy]);
				idx += 2;
				continue;
			}

			// 교체
			sb.setCharAt(idx, arr[cx][cy2]);
			sb.setCharAt(idx + 1, arr[cx2][cy]);
            
			idx += 2;

        }

        System.out.print(sb);

    }	

}
