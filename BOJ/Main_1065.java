import java.util.Scanner;

public class Main_1065 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] temp = new int[3];

        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (i < 100)
                count++;
            else {
                int a = i / 100;
                int b = (i % 100) / 10;
                int c = (i % 100) % 10;
                if(a - b == b-c)
                    count++;
            }
        }

        System.out.println(count);

	}

}
