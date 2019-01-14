
import java.util.Scanner;
public class Series {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] value = new long[1000000]; // µü´úÖµ
        value[1] = 1;
        value[2] = 2;
        for (int j = 3; j < value.length; j++) {
                value[j] = (2 * value[j-1] + value[j - 2]) % 32767;
            }
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            System.out.println(value[temp]);
        }
    }
}